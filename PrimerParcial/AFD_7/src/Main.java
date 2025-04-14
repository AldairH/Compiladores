import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            TablaAFD tabla = new TablaAFD();
            tabla.cargarArchivo("config.txt");
            Reader lector = new Reader();
            lector.read("entrada.txt", tabla);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de configuración.");
            e.printStackTrace();
        }
    }
}