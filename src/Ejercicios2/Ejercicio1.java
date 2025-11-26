package Ejercicios2;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        rellenar(nums);
        mostrar(nums);

    }
    public static void rellenar(int[] nums){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < nums.length; i++){
            System.out.println("Escribe el numero " + (i+1));
            nums[i] = sc.nextInt();
        }
    }
    public static void mostrar(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
