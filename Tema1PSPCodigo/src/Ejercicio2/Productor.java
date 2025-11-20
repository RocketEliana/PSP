/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
/*IP → dirección de la casa.

Puerto → puerta concreta de esa casa.

Socket → tubería que conecta tu puerta con otra puerta en otra casa.*/
public class Productor {//el cliente,manda mensajes
    /*Rol	Función en la Red (Sockets)	Función Lógica (Productor/Consumidor)
Lector/Consumidor	Servidor (ServerSocket)	El que recibe y procesa los datos.
Productor/Escritor	Cliente (Socket)	El que genera y envía los datos.*/
    //defino puerto y host para el constructor del socket
   private static final int PUERTO=6000;
   private static final String HOST="localhost";//servidor
    public static void main(String[] args) {
        //socket y flujos
    
       try(Socket socket=new Socket(HOST, PUERTO);
       PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);//autoflush()
       BufferedReader br=new  BufferedReader(new InputStreamReader(socket.getInputStream()));//para el servidor
               ){
           System.out.println("Conexion hecha");
           pw.println("Hola servidor");
            String respuesta=br.readLine();
            System.out.println("El servidor ha dicho: " + respuesta );
            
           
         
       }catch (IOException ex) {
           Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
/*cuando usas un try-with-resources, el socket y los flujos se cierran automáticamente al salir 
del bloque try (tanto si termina bien como si ocurre una excepción).*/
