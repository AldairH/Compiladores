import java.io.*;
class Reader {
    public void read(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            AFD afd = new AFD();
            String linea;
            int numLineas = 1;
            while ((linea = br.readLine()) != null){
                boolean resultado = afd.afd(linea);
                if (!resultado) {
                    System.out.println("Error en la linea " + numLineas + ".");
                }else{
                    System.out.println("Palabra " + numLineas + " aceptada.");
                }
                numLineas++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}