package Ejercicios2;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        int[] resultados = new int[]{0,0,0};
        ingresar(nums);
        int[] total = comprobar(nums, resultados);
        int mediapos = total[1];
        int medianega = total[0];
        System.out.println("Negativos -> " + total[0]);
        System.out.println("Postivos -> " + total[1]);
        System.out.println("Zeros -> " + total[2]);
        double[] mediatot = media(nums, mediapos, medianega);
        System.out.println("La media de los positivos " + mediatot[0]);
        System.out.println("La media de los negativos " + mediatot[1]);

    }
    public static void ingresar(int[] nums){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < nums.length; i++){
            System.out.println("Escribe el numero " + (i+1));
            nums[i]=sc.nextInt();
        }
    }
    public static int[] comprobar(int[] nums, int[] resultados){
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                resultados[0]++;
            }
            else if(nums[i] > 0){
                resultados[1]++;
            }
            else{
                resultados[2]++;
            }
        }
        return resultados;
    }
    public static double[] media(int[] nums, int meadiapos, int medianeg){
        double total = 0;
        double total2 = 0;
        double[] resultado = new double[2];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                total = total + nums[i];
            }
            if(nums[i] < 0){
                total2 = total2 + nums[i];
            }
        }
        resultado[0] = total/meadiapos;
        resultado[1] = total2/medianeg;
        return resultado;
    }
}
