package Ejercicio2.lenguage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Lenguaje {
    public static void main(String[] args) {
        // Comprobar que hay dos argumentos
        if (args.length < 2) {
            System.out.println("Uso: java -jar lenguaje.jar <numConjuntos> <nombreFichero>");
            return;
        }

        int conjuntos;
        try {
            conjuntos = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("Error: el primer argumento debe ser un número entero.");
            return;
        }

        String nombreFichero = args[1];

        // Cuántas letras tendrá cada conjunto (puedes cambiarlo si lo pide el ejercicio)
        int letrasPorConjunto = 8;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero,true))) {
            for (int i = 0; i < conjuntos; i++) {
                StringBuilder palabra = new StringBuilder();
                for (int j = 0; j < letrasPorConjunto; j++) {
                    char letra = (char) ('a' + Math.random() * 26);
                    palabra.append(letra);
                }
                bw.write(palabra.toString());
                bw.newLine();
            }
            System.out.println("Archivo '" + nombreFichero + "' creado con " + conjuntos + " palabras.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}



//args[0] = número de conjuntos (por ejemplo, 40)

//args[1] = nombre del fichero (por ejemplo, miFicheroDeLenguaje.txt)
