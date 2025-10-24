package Ejercicios;

import java.util.Scanner;

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("En que numero quieres empezar: ");
        int V = sc.nextInt();
        System.out.println("Cuanto quieres sumarle a ese valor: ");
        int I = sc.nextInt();
        System.out.println("Cuantos numeros quieres crear: ");
        int N = sc.nextInt();

        int[] nums = numeros(V, I , N);
        for(int i = 0; i < N; i++){
            System.out.println(nums[i]);
        }
    }

    public static int[] numeros(int V, int I, int N) {
        int nums[] = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = V;
            V = V+I;
        }
        return nums;
    }
}
