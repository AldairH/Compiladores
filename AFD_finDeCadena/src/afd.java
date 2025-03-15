public class afd {
    public boolean afd(String cadena){
        int estadoInicial = 0;

        for (int i = 0; i < cadena.length(); i++) {
            char simbolo = cadena.charAt(i);
            int ascii = (int) simbolo;

            switch (estadoInicial){
                case 0:
                    if((ascii>=97 && ascii<=122)||(ascii>=65 && ascii<=90)) estadoInicial = 1;
                    else estadoInicial = 2;
                    break;
                case 1:
                    if ((ascii>=65 && ascii<=90)||(ascii>=48 && ascii<=57)||(ascii==95)||(ascii>=97 && ascii<=122)) estadoInicial = 1;
                    else estadoInicial = 2;
                    break;
                case 2:
                    return false;
            }
        }
        return estadoInicial == 1;
    }
}