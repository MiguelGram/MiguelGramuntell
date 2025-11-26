package Ejercicios2;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("tamaño del array siguiente");
        int[] enteros = new int[sc.nextInt()];
        System.out.println("Escribe el valor minimo ");
        int min = sc.nextInt();
        System.out.println("Escribe el valor maximo");
        int max = sc.nextInt();
        aleatorio(enteros,max,min);
        for(int i = 0; i < enteros.length; i++){
            System.out.println(enteros[i]);
        }

    }
    public static void aleatorio(int[] enteros, int max, int min){
        int num;
        for(int i = 0; i < enteros.length; i++){
            num = (int)(Math.random()*max);
         if(num<min)
             i--;
         else
             enteros[i] = num;
        }

    }
}
