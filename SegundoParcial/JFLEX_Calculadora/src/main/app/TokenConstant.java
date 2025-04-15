package main.app;

public enum TokenConstant {
    PARENI(1),
    PAREND(2),
    MAS(3),
    MENOS(4),
    MULT(5),
    DIV(6),
    POT(7),
    IGUAL(8),
    MOD(9),
    LOG(10),
    RAIZ(11),
    PI(12),
    MIN(13),
    MAX(14),
    FLOAT(15),
    INTEGER(16),
    ERROR(999);

    private final int value;

    TokenConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TokenConstant fromValue(int value) {
        for (TokenConstant type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor de token inválido: " + value);
    }
}