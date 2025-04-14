package main.app;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class App {
    private static final String INPUT_FILE = "entrada.txt";

    public static void main(String[] args) {
        try (Reader reader = new FileReader(INPUT_FILE)) {
            Lexer lexer = new Lexer(reader);

            Token token;
            while ((token = lexer.yylex()) != null) {
                System.out.println(token);

                if (token.getTokenType() == TokenConstant.ERROR) {
                    System.err.println("¡Error léxico en línea " + token.getLine() +
                            ", columna " + token.getColumn() + ": " + token.getLexeme());
                    System.exit(1);
                }
            }

            System.out.println("Análisis léxico completado sin errores.");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo '" + INPUT_FILE + "': " + e.getMessage());
            System.exit(1);
        }
    }
}