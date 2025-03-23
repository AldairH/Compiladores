/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fes.aragon.inicio;

import fes.aragon.codigo.Lexico;
import fes.aragon.codigo.Sym;
import fes.aragon.codigo.Tokens;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author MASH
 */
public class Inicio {
    private boolean error = true;
    private Tokens tokens = null;
    private Lexico analizador = null;

    public static void main(String[] args) {
        Inicio ap = new Inicio();
        BufferedReader buf;
        try {
            buf = new BufferedReader(
                    new FileReader(System.getProperty("user.dir")
                            + "/archivo.txt"));
            ap.analizador = new Lexico(buf);
            ap.siguienteToken();
            ap.sentencia();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sentencia() {
        do {
            asignacion();
            if (tokens.getLexema() != Sym.PUNTOCOMA) {
                errorSintactico();
                siguienteToken();
            }
            if (!this.error) {
                System.out.println("Invalida linea= " + (tokens.getLinea() + 1));
                this.error = true;
            } else {
                System.out.println("Valida  linea= " + (tokens.getLinea() + 1));
            }
            siguienteToken();
        } while (tokens.getLexema() != Sym.EOF);
    }

    private void asignacion() {
        if (tokens.getLexema() == Sym.ID) {
            siguienteToken();
            if (tokens.getLexema() == Sym.IGUAL) {
                siguienteToken();
                expresion();
            } else {
                errorSintactico();
            }
        } else {
            errorSintactico();
        }
    }

    private void expresion() {
        if (tokens.getLexema() == Sym.ID || tokens.getLexema() == Sym.ENTERO) {
            siguienteToken();
            if (tokens.getLexema() == Sym.MAS || tokens.getLexema() == Sym.MENOS) {
                siguienteToken();
                expresion();
            } else {
                if (tokens.getLexema() != Sym.PUNTOCOMA) {
                    errorSintactico();
                }
            }
        } else {
            if (tokens.getLexema() != Sym.PUNTOCOMA) {
                errorSintactico();
            }
        }
    }

    private void errorSintactico() {
        this.error = false;
        //descartar todo hasta encontrar ;            
        do {
            System.out.println(tokens.toString());
            if (tokens.getLexema() != Sym.PUNTOCOMA) {
                siguienteToken();
            }
        } while (tokens.getLexema() != Sym.PUNTOCOMA && tokens.getLexema() != Sym.EOF);

    }

    private void siguienteToken() {
        try {
            tokens = analizador.yylex();
            if (tokens == null) {
                tokens = new Tokens("EOF", Sym.EOF, 0, 0);
                throw new IOException("Fin Archivo");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
