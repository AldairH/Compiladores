package main.app;

public enum TokenConstant {
    EOF(99),
    PARENI(1),
    PAREND(2),
    AND(3),
    OR(4),
    NOT(5),
    TRUE(6),
    FALSE(7),
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
