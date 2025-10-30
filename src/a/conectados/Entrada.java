package a.conectados;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {

    }

    public static String obtenerTexto(String texto){
        Scanner sc = new Scanner(System.in);
        Pantalla.mostrarPantalla(texto);
        return sc.nextLine();
    }

    public static int obtenerEntero(String texto){
        Scanner sc = new Scanner(System.in);
        Pantalla.mostrarPantalla(texto);
        do{
            if(!sc.hasNextInt()){
                Pantalla.mostrarError("Debes introducir un entero");
                sc.nextLine();
                Pantalla.mostrarPantalla(texto);
            }
        }while(!sc.hasNextInt());

        return sc.nextInt();
    }

    public static int obtenerEntero(int min, int max, String texto){
        int numero;

        do{
            numero = obtenerEntero(texto);
            if(numero < min){
                Pantalla.mostrarError("El numero debe ser mayor o igual a " + min);
            }
            if(numero > max){
                Pantalla.mostrarError("El numero debe ser menor o igual a " + max);
            }
        }while(numero < min || numero > max);
        return numero;
    }

    public static char obtenerLetra(String mensaje){
        Scanner sc = new Scanner(System.in);
        String texto;
        do{
            texto = obtenerTexto(mensaje);
            if(texto.length() != 1){
                Pantalla.mostrarError("Debes introducir un solo caracter");
            }
            else if(texto.charAt(0) < 'A' || texto.charAt(0) > 'Z'){
                Pantalla.mostrarError("Desbes introducir una letra");
            }
        }while((texto.length()!=1) || (texto.charAt(0) < 'A' || texto.charAt(0) > 'Z'));

        return texto.charAt(0);
    }

    public static char obtenerLetra(char min, char max, String mensaje){
        String texto;

        do{
            texto = obtenerTexto(mensaje);
            if(texto.charAt(0) < min || texto.charAt(0) > max){
                Pantalla.mostrarError("El caracter tiene que estar entre " + min + " y " + max);
            }
        }while(texto.charAt(0) < min || texto.charAt(0) > max);
        return texto.charAt(0);
    }
}
