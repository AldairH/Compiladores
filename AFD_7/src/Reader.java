import java.io.*;

class Reader {
    public void read(String nombreArchivo, TablaAFD tabla) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            AFD afd = new AFD(tabla);
            String linea;
            int numLineas = 1;
            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                int numPalabra = 1;
                for (String palabra : palabras) {
                    boolean resultado = afd.afd(palabra);
                    System.out.println("Palabra '" + palabra + "' en línea " + numLineas + " resultado: " + (resultado ? "Aceptada" : "Rechazada"));
                    numPalabra++;
                }
                numLineas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}