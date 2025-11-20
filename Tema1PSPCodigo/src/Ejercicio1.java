import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio1 {
    public static void main(String[] args) {
        
        // Detección del SO (¡Esto está perfecto!)
        String soNombre = System.getProperty("os.name").toUpperCase(); 
        Process p = null;

        // INICIO DEL BLOQUE TRY
        try {
            if (soNombre.contains("WIN")) {
                // Windows
                System.out.println("Detectado Windows. Ejecutando notepad.exe...");
                p = new ProcessBuilder("notepad.exe").start();
    
            } else if (soNombre.contains("LINUX") || soNombre.contains("MAC")) {
                // Linux o macOS (Nota: MAC estará en mayúsculas por el toUpperCase() inicial)
                System.out.println("Detectado Linux/Mac. Ejecutando gedit...");
                p = new ProcessBuilder("gedit").start();
            
            } else {
                // SO no reconocido
                System.out.println("No se reconoce el sistema operativo.");
            }
            
        
        // FIN DEL BLOQUE TRY
        } catch (IOException ex) {
            // Un solo bloque catch maneja errores de ejecución de cualquiera de los ProcessBuilder
            System.err.println("ERROR: No se pudo ejecutar el programa externo (gedit o notepad).");
            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}