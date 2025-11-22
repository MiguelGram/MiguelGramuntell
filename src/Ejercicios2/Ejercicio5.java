package Ejercicios2;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        char[] letras = new char[26];
        Scanner sc = new Scanner(System.in);
        String texto = "";
        int pos;
        rellenar(letras);
        do{
            do{
                System.out.println("Escribe una posicion entre 0 - 25 o '-1' para terminar");
                pos = sc.nextInt();
            }while(pos < -1 || pos > 25 );
            if(pos != -1){
                texto = texto + letras[pos];
            }
        }while(pos != -1);

        System.out.println(texto);
    }
    public static void rellenar(char[] letras){
        for(int i = 0; i < letras.length; i++){
            letras[i] = (char)('A' + i);
        }
    }
}
