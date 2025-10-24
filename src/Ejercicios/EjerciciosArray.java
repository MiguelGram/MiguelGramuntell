package Ejercicios;

import java.util.Scanner;

public class EjerciciosArray {
    public static void main(String[] args) {
        int[] nums = numeros();
        mostrarnum(nums);
        suma(nums);
        sumanegativa(nums);
        media(nums,suma(nums));

    }

    public static int[] numeros() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[10];
        for(int i = 0; i < nums.length; i++){
            System.out.println((i+1) + " Escribe un numero: ");
            nums[i] = sc.nextInt();
        }
        return nums;
    }

    public static void mostrarnum(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            System.out.println(nums[i]);
        }
    }

    public static int suma(int[] nums) {
        int suma = 0;
        for (int i = 0; i < nums.length; i++){
            suma += nums[i];
        }
        System.out.println("El resultado total es -> " + suma + " <- Los numeros negativos restan");
        return suma;
    }

    public static void sumanegativa(int[] nums) {
        int suma = 0;
        int suman = 0;
        for (int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                suman += nums[i];
            }
            else{
                suma += nums[i];
            }
        }
        System.out.println("El resultado total de numeros positivos es -> " + suma);
        System.out.println("El resultado total de numeros negativos es -> " + suman);
    }

    public static void media(int[] nums, int suma) {
        float media = (float)suma/nums.length;
        System.out.println("La media es " + media);

    }
}
