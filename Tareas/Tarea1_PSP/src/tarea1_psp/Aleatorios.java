/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_psp;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Aleatorios {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numerosAleatorios=40;
        int numero=0;
        int[] numeros= new int[numerosAleatorios];
        for (int i = 0; i <numeros.length; i++) {
            numero=(int)(Math.random()*101);
            numeros[i]=numero;
            
        }
        for(int n:numeros){
            System.out.println(n);
        }
        
    }
    //en cmd si no hay principal:java -cp . tarea1_psp.Aleatorios | java -cp . tarea1_psp.OrdenarNumeros

}
