public class AFD {

    private final int[][] tablaTransicion = {
            {      1,       2,         2,         2},
            {      1,       1,         1,         2},
            {      2,       2,         2,         2}
    };
    private int getTipoCaracter(char simbolo) {
        if (Character.isLetter(simbolo)) return 0;
        if (Character.isDigit(simbolo)) return 1;
        if (simbolo == '_') return 2;
        return 3;
    }
    public boolean afd(String cadena) {
        int estado = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char simbolo = cadena.charAt(i);
            int tipo = getTipoCaracter(simbolo);
            estado = tablaTransicion[estado][tipo];
            if (estado == 2) return false;
        }
        return estado == 1;
    }
}