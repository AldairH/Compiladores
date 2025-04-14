package main.app;

public enum TokenConstant {
    PARENI(1),     // (
    PAREND(2),     // )
    MAS(3),       // +
    MENOS(4),      // -
    MULT(5),       // *
    DIV(6),        // /
    POT(7),        // ^
    IGUAL(8),      // =
    MOD(9),        // %
    LOG(10),       // log
    RAIZ(11),       // sqr
    PI(12),        // PI
    MIN(13),       // min
    MAX(14),       // max
    FLOAT(15),     // Números flotantes
    INTEGER(16),   // Números enteros
    ERROR(999);    // Errores

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