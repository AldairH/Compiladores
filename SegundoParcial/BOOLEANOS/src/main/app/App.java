package main.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {
    private static final String ARCHIVO = "entrada.txt";

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            int numLinea = 1;

            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    System.out.println("\n➡ Línea " + numLinea + ": " + linea);

                    Lexer lexer = new Lexer(new java.io.StringReader(linea));
                    BooleanParser parser = new BooleanParser(lexer);

                    try {
                        parser.parse();
                        System.out.println("Expresión válida");
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                numLinea++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}