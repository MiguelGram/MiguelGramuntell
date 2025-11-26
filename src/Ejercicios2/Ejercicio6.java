package Ejercicios2;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] letras = new char[]{'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        System.out.println("Escribe los numeros de tu dni");
        int dni = sc.nextInt();
        if(String.valueOf(dni).length() != 8){
            System.out.println("Vuelve a intentarlo");
        }
        else{
            System.out.println("Tu letra de dni es: " + letras[dni%23]);
        }

    }
}
