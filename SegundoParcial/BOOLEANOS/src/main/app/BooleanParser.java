package main.app;

import java.io.IOException;

public class BooleanParser {
    private Lexer lexer;
    private Token currentToken;

    public BooleanParser(Lexer lexer) throws IOException {
        this.lexer = lexer;
        this.currentToken = lexer.yylex();
    }

    public void parse() throws IOException {
        parseA();
        if (currentToken != null && currentToken.getType() != TokenConstant.EOF) {
            throw new RuntimeException("Tokens adicionales: " + currentToken);
        }
    }


    private void parseA() throws IOException {
        parseB();
        parseAprime();
    }

    private void parseAprime() throws IOException {
        if (currentToken != null && currentToken.getType() == TokenConstant.OR) {
            consume(TokenConstant.OR);
            parseB();
            parseAprime();
        }
        //no hacer nada
    }

    private void parseB() throws IOException {
        parseC();
        parseBprime();
    }

    private void parseBprime() throws IOException {
        if (currentToken != null && currentToken.getType() == TokenConstant.AND) {
            consume(TokenConstant.AND);
            parseC();
            parseBprime();
        }
        //no hacer nada
    }

    private void parseC() throws IOException {
        switch (currentToken.getType()) {
            case NOT:
                consume(TokenConstant.NOT);
                parseC();
                break;
            case PARENI:
                consume(TokenConstant.PARENI);
                parseA();
                if (currentToken != null && currentToken.getType() == TokenConstant.PAREND) {
                    consume(TokenConstant.PAREND);
                } else {
                    throw new RuntimeException("Se esperaba ')'");
                }
                break;
            case TRUE:
            case FALSE:
                consume(currentToken.getType());
                break;
            default:
                throw new RuntimeException("Token inesperado: " + currentToken.getType());
        }
    }

    private void consume(TokenConstant expected) throws IOException {
        System.out.println("Consumiendo: " + currentToken);
        if (currentToken == null || currentToken.getType() == TokenConstant.EOF) {
            throw new RuntimeException("Se esperaba " + expected);
        }
        if (currentToken.getType() == expected) {
            currentToken = lexer.yylex();
            if (currentToken == null) return;
        } else {
            throw new RuntimeException("Token inesperado: " + currentToken);
        }
    }

}