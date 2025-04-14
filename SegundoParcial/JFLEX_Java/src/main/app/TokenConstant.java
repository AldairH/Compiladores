package main.app;

public enum TokenConstant {
    RESERVED_WORD(1),
    FLOAT(2),
    SCIENTIFIC(3),
    INTEGER(5),
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
