package Ejercicios2;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total;
        System.out.println("De cuanto quieres que sea tu array");
        total = sc.nextInt();
        int[] nums = new int[total];
        rellenar(nums);
        mostrar(nums);
    }

    public static boolean primos(int num){

        for(int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void rellenar(int[] nums){
        Scanner sc = new Scanner(System.in);
        int i = 0;
        System.out.println("Rango minimo");
        int min = sc.nextInt();
        System.out.println("Rango maximo");
        int max = sc.nextInt();
        for(i = 0;min < max; min++){
            if(primos(min)){
                nums[i] = min;
                i++;
            }
        }
    }
    public static void mostrar(int[] nums){
        for(int x = nums.length-1; x > 0; x--){
            if(nums[x] != 0){
                System.out.println("El primo mas grande es -> " + nums[x]);
                x = 0;
            }
        }
    }
}
