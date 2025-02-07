public class AFD {
    public boolean afd(String cadena){
        int estadoInicial = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char simbolo = cadena.charAt(i);

            switch (estadoInicial){
                case 0:
                    if (simbolo == 'a') estadoInicial = 0;
                    else if (simbolo == 'b') estadoInicial = 1;
                    else estadoInicial = 3;
                    break;
                case 1:
                    if (simbolo == 'a') estadoInicial = 2;
                    else if (simbolo == 'b') estadoInicial = 3;
                    else estadoInicial = 3;
                    break;
                case 2:
                    if (simbolo == 'a') estadoInicial = 3;
                    else if (simbolo == 'b') estadoInicial = 3;
                    else estadoInicial = 3;
                    break;
                case 3:
                    return false;
            }
        }
        return estadoInicial == 2;
    }
}
