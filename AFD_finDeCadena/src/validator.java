import java.util.ArrayList;
import java.util.Arrays;

class validator {
    private afd AFD = new afd();

    public void validateLine(String linea, int numLineas) {
        linea = linea.trim();

        if (!linea.endsWith(";")) {
            System.out.println("Error en la línea " + numLineas + ": Falta ';' al final.");
        } else {
            linea = linea.substring(0, linea.length() - 1); // Removemos el ;
            ArrayList<String> palabras = new ArrayList<>();

            String[] tempPalabras = linea.split(" "); // Usamos split
            for (String palabra : tempPalabras) {
                palabras.add(palabra);
            }

            int numPalabra = 1;
            for (String palabra : palabras) {
                boolean resultado = AFD.afd(palabra);
                if (!resultado) {
                    System.out.println("Error en la línea " + numLineas + ", palabra " + numPalabra + ".");
                } else {
                    System.out.println("Palabra " + numPalabra + " de línea " + numLineas + " aceptada.");
                }
                numPalabra++;
            }
        }
    }
}