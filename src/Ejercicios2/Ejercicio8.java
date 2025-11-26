package Ejercicios2;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double altura;
        double total = 0;
        System.out.println("cuantas personas son ");
        int personas = sc.nextInt();
        double[] alturas = new double[personas];
        for(int i = 0; i < personas; i++){
            do{
                System.out.println("Altura de la " + (1+i) + " persona");
                altura = sc.nextDouble();
                if(altura > 0){
                    alturas[i] = altura;
                }
                else{
                    System.out.println("Error");
                }
            }while(altura < 1);
        }
        for(int z = 0; z < alturas.length; z++){
            total = total + alturas[z];
        }
        double media = total / personas;
        System.out.println("la media es " + media);
        for(int x = 0; x < alturas.length; x++){
            if(alturas[x] > media){
                System.out.println("Esta por encima de la media " + alturas[x]);
            }
        }
    }

}
