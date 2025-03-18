import java.io.*;
class Reader {
    public void read(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            AFD afd = new AFD();
            String linea;
            int numLineas = 1;
            while ((linea = br.readLine()) != null){
                int indice = linea.indexOf(";");
                if (indice == -1) {
                    System.out.println("Línea " + numLineas + " no contiene ';'.");
                    numLineas++;
                    continue;
                }
                linea = linea.substring(0, indice).trim();
                if (linea.isEmpty()) {
                    numLineas++;
                    continue;
                }
                String[] palabras = linea.split(" ");
                int numPalabra = 1;
                for (int i = 0; i < palabras.length; i++){
                    boolean resultado = afd.afd(palabras[i]);
                    if (!resultado) {
                        System.out.println("Error en la linea " + numLineas + " palabra " + numPalabra + ":" + palabras[i]);
                    }else{
                        System.out.println("Palabra " + numPalabra + " de linea " + numLineas + " aceptada: " + palabras[i]);
                    }
                    numPalabra++;
                }
                numLineas++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}