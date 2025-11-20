/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1_psp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class OrdenarNumeros {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       
        ArrayList<Integer> numeros=new ArrayList<>();
        System.out.println("Escribe numeros,para con control + z");
       while(sc.hasNextInt()){
           int num=sc.nextInt();
           numeros.add(num);
       }        
       Collections.sort(numeros);
       numeros.forEach(n->{System.out.println(n);});
        
    }
    
}
