/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ConsumidorServidor {
    private static final int puerto=6000;
    public static void main(String[] args) {
        try(ServerSocket ss=new ServerSocket(puerto);
                Socket socket=ss.accept();
                PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
                BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                ){
               System.out.println("Cliente conectado desde: " + socket.getInetAddress());
            System.out.println("Servidor esperando mensaje...");

            String recibido = br.readLine();
            System.out.println("Cliente dice: " + recibido);

            pw.println("Recibido: " + recibido);
            System.out.println("Respuesta enviada al cliente.");
            
        } catch (IOException ex) {
            Logger.getLogger(ConsumidorServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
