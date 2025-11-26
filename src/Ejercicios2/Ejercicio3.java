package Ejercicios2;

public class Ejercicio3 {
    public static void main(String[] args) {
        int[] enteros = new int[100];
        int total = 0;
        for(int i = 0; i < enteros.length; i++){
            enteros[i] = (int)(Math.random()*100);
        }
        for(int i = 0; i < enteros.length; i++){
            total = total + enteros[i];
        }
        System.out.println("total = " + total);
        System.out.println("media = " + total/100);
    }
}
