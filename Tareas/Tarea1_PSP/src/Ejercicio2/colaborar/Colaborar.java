package Ejercicio2.colaborar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Colaborar {

    public static void main(String[] args) {
        String nombreFichero = "granLenguaje.txt";
        String rutaJar = "lenguaje.jar"; // Asegúrate de que está en la misma carpeta

        List<Process> procesos = new ArrayList<>();

        try {
            // Lanzar 10 procesos con cantidades crecientes
            for (int i = 1; i <= 10; i++) {
                int cantidad = i * 10; // 10, 20, ..., 100
                System.out.println("Lanzando proceso con " + cantidad + " palabras...");

                ProcessBuilder pb = new ProcessBuilder(
                        "java", "-jar", rutaJar,
                        String.valueOf(cantidad),
                        nombreFichero
                );

                pb.inheritIO(); // Para ver la salida en consola (opcional)
                Process proceso = pb.start();
                procesos.add(proceso);
            }

            // Esperar a que terminen todos los procesos
            for (Process p : procesos) {
                p.waitFor();
            }

            System.out.println("\n✅ Todos los procesos han terminado.");
            System.out.println("El fichero " + nombreFichero + " debería contener 550 líneas.");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
