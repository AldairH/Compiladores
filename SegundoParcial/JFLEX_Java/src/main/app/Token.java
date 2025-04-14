package main.app;

public class Token {
    private final TokenConstant tokenType;
    private final String lexeme;
    private final int line;
    private final int column;


    public Token(TokenConstant tokenType, String lexeme, int line, int column) {
        this.tokenType = tokenType;
        this.lexeme = lexeme;
        this.line = line;
        this.column = column;
    }

    public Token(int tokenTypeValue, String lexeme, int line, int column) {
        this(TokenConstant.fromValue(tokenTypeValue), lexeme, line, column);
    }

    public TokenConstant getTokenType() {
        return tokenType;
    }

    public String getLexeme() {
        return lexeme;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return String.format("Token [%s, '%s', Línea: %d, Columna: %d]",
                tokenType.name(), lexeme, line, column);
    }
}