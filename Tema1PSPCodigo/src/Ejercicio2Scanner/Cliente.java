package Ejercicio2Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Cliente que se conecta a un servidor por socket y permite enviar
 * mensajes de manera dinámica. El cliente puede enviar múltiples mensajes
 * hasta que escriba "salir" para cerrar la conexión.
 * 
 * @author User
 */
public class Cliente {
    private static final int PUERTO = 6000;
    private static final String HOST = "localhost";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try (
            Socket socket = new Socket(HOST, PUERTO);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true); // auto-flush
        ) {
            System.out.println("¡Conexión exitosa con el servidor!");
            System.out.println("Escribe mensajes para enviar al servidor. Escribe 'salir' para terminar.");

            String mensaje;
            while (true) {
                System.out.print("Tu mensaje: ");
                mensaje = sc.nextLine();

                if ("salir".equalsIgnoreCase(mensaje)) {
                    System.out.println("Cerrando conexión...");
                    break;
                }

                // Enviar mensaje al servidor
                pw.println(mensaje);

                // Recibir respuesta del servidor (si hay)
                String respuestaServidor = br.readLine();
                if (respuestaServidor != null) {
                    System.out.println("Servidor: " + respuestaServidor);
                } else {
                    System.out.println("Servidor desconectado.");
                    break;
                }
            }

        } catch (IOException ex) {
            // Manejo de errores de comunicación
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error de comunicación con el servidor:");
            System.err.println("- Verifica que el servidor esté ejecutándose en " + HOST + ":" + PUERTO);
            System.err.println("- Comprueba que no haya firewalls bloqueando la conexión");
            System.err.println("- Asegúrate de que el puerto no esté ocupado por otra aplicación");
        } finally {
            sc.close();
        }
    }
}
