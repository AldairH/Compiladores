import java.io.*;
class Reader {
    public void read(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            AFD afd = new AFD();
            String linea;
            int numLineas = 1;
            while ((linea = br.readLine()) != null){
                String[] palabras = linea.split(" ");
                int numPalabra = 1;
                for (int i = 0; i < palabras.length; i++){
                    boolean resultado = afd.afd(palabras[i]);
                    if (!resultado) {
                        System.out.println("Error en la linea " + numLineas + " palabra " + numPalabra + ".");
                    }else{
                        System.out.println("Palabra " + numPalabra + " de linea " + numLineas + " aceptada.");
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
