package Ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos alumnos hay -> ");
        int num = sc.nextInt();
        System.out.println("Cuantos asignaturas hay -> ");
        int asig = sc.nextInt();
        String[][] notas = new String[asig + 2][num + 2];
        notas[0][0] = "\t";
        notas[0][notas[1].length - 1] = " MEDIA ";
        notas[notas.length - 1][0] = " MEDIA ";
        notas[notas.length-1][notas[0].length-1] = " ";
        nombres(notas);
        asignaturas(notas);
        autofill(notas);
        media(notas);
        mediaasig(notas);

        System.out.println("hola");


        for(int b = 0; b < notas.length; b++){
            for(int i = 0; i < notas[1].length; i++){
                System.out.print(notas[b][i] + "\t");
            }
            System.out.println("");
        }

        System.out.println("");

        //show(notas);  // <- OTRA FORMA DE MOSTRAR LA TABLA DE ARRAYS

        media(notas);

    }

    private static void media(String[][] notas) {
        float sum = 0;
        float media = 0;
        for(int col = 1; col < notas[1].length-1; col++){
            for(int fil = 1; fil < notas.length-1; fil++){
                sum += Float.parseFloat(notas[fil][col]);
            }
            media = sum / (notas.length-2);
            notas[notas.length-1][col] = "" + media;
            sum = 0;
        }
    }

    private static void mediaasig(String[][] notas) {
        float sum = 0;
        float media = 0;
        for(int fil = 1; fil < notas.length-1; fil++){
            for(int col = 1; col < notas[0].length-1; col++){
                sum += Float.parseFloat(notas[fil][col]);
            }
            media = sum / (notas[1].length-2);
            notas[fil][notas[1].length-1] = "" + media;
            sum = 0;
        }
    }

    private static void show(String[][] notas){
        for(String[] numero : notas){
            System.out.println(Arrays.toString(numero));
        }
        System.out.println();
    }

    public static void autofill(String[][] notas) {
        double result = 0;
        for(int col = 1; col < notas.length-1; col++){
            for(int fil = 1; fil < notas[1].length-1; fil++){
                result = Math.round(Math.random()*1000);
                notas[col][fil] = "" + result/100;
            }
        }
    }

    public static void nombres(String[][] notas) {
        Scanner sc = new Scanner(System.in);
        for(int col = 1; col < notas[1].length-1; col++){
            System.out.println("Escribe el " + (col) + " alumno \t");
            notas[0][col] = sc.nextLine();
        }
    }

    public static void asignaturas(String[][] notas) {
        Scanner sc = new Scanner(System.in);
        for(int fil = 1; fil < notas.length-1; fil++){
            System.out.println("Escribe la " + (fil) + " asignatura \t");
            notas[fil][0] = sc.nextLine();
        }
    }


}
