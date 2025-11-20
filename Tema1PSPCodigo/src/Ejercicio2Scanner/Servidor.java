/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio2Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Servidor {
    private static final int puerto=6000;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        try(ServerSocket ss=new ServerSocket(puerto);
                Socket s=ss.accept();
                BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));//necesito un nuevo flujo para convertir a caracteres
                PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
               ){
            //💡 Analogía: el PrintWriter se construye sobre el flujo de salida. No estás “usando el Socket directo”, 
            //sino su canal de salida, igual que con el BufferedReader. La diferencia es que con PrintWriter puedes escribir texto directamente; 
            //con BufferedReader necesitas el InputStreamReader de por medio para convertir bytes en texto legible.
            System.out.println("Servidor conectado");
            String mensaje;
            while((mensaje=br.readLine()) !=null){
                System.out.println("Cliente dice : " + mensaje);
              
            String contesta=sc.nextLine();
            pw.println(contesta);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
