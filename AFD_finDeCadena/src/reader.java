import java.io.*;

class reader {
    public void read(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            validator validator = new validator();
            String linea;
            int numLineas = 1;

            while ((linea = br.readLine()) != null) {
                validator.validateLine(linea, numLineas);
                numLineas++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}