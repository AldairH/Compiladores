import java.io.*;
import java.util.*;

class TablaAFD {
    private int[][] tablaTransicion;
    private List<Set<Character>> grupos;
    private Set<Integer> estadosAceptacion;

    public void cargarDesdeArchivo(String archivoConfig) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoConfig))) {
            String[] primeraLinea = br.readLine().split(",");
            int numEstados = Integer.parseInt(primeraLinea[0]);
            int numColumnas = Integer.parseInt(primeraLinea[1]);

            String alfabetoLinea = br.readLine().trim();
            grupos = new ArrayList<>();
            String[] gruposStr = alfabetoLinea.split(" ");
            for (String grupoStr : gruposStr) {
                if (grupoStr.startsWith("{") && grupoStr.endsWith("}")) {
                    grupoStr = grupoStr.substring(1, grupoStr.length() - 1);
                    Set<Character> grupo = new HashSet<>();
                    String[] elementos = grupoStr.split(",");
                    for (String elemento : elementos) {
                        elemento = elemento.trim();
                        if (elemento.length() == 1) {
                            grupo.add(elemento.charAt(0));
                        } else if (elemento.contains("-")) {
                            char inicio = elemento.charAt(0);
                            char fin = elemento.charAt(2);
                            for (char c = inicio; c <= fin; c++) {
                                grupo.add(c);
                            }
                        }
                    }
                    grupos.add(grupo);
                }
            }
            tablaTransicion = new int[numEstados][numColumnas - 1];
            estadosAceptacion = new HashSet<>();

            for (int i = 0; i < numEstados; i++) {
                String[] valores = br.readLine().split(" ");
                for (int j = 0; j < numColumnas - 1; j++) {
                    tablaTransicion[i][j] = Integer.parseInt(valores[j]);
                }
                if (Integer.parseInt(valores[numColumnas - 1]) == 1) {
                    estadosAceptacion.add(i);
                }
            }
        }
    }

    public int obtenerSiguienteEstado(int estadoActual, char simbolo) {
        for (int j = 0; j < grupos.size(); j++) {
            if (grupos.get(j).contains(simbolo)) {
                return tablaTransicion[estadoActual][j];
            }
        }
        return -1;
    }
    public boolean esEstadoDeAceptacion(int estado) {
        return estadosAceptacion.contains(estado);
    }
}