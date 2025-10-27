package OrdenArrays;

import java.util.Arrays;

public class Ejercicio1 {
    public static void main(String[] args) {
        int[] nums = new int[]{
                2, 5, -4, 0, 5, 7,4,8,9,-7
        };

        String[] texto = new String[]{
                "hola", "mundo", "alo", "aalo", "choca", "aaaalo"
        };

        //seleccion(nums);
        //System.out.println(Arrays.toString(nums));

        //seleccion(texto);
        //System.out.println(Arrays.toString(texto));

        orden(texto);
        //System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(texto));

    }

    private static void seleccion(int[] numeros){
        int posMenor;
        int aux;

        posMenor = 0;
        for(int i = 0; i < numeros.length; i++){
            posMenor = i;
            for(int j = i; j < numeros.length; j++){
                if(numeros[j] < numeros[posMenor]){
                    posMenor=j;
                }
            }
            aux = numeros[i];
            numeros[i] = numeros[posMenor];
            numeros[posMenor] = aux;
        }
    }

    private static void seleccion(String[] palabras){
        int posMenor;
        String aux;

        posMenor = 0;
        for(int i = 0; i < palabras.length; i++){
            posMenor = i;
            for(int j = i; j < palabras.length; j++){
                if((palabras[j].compareTo(palabras[posMenor])) < 0){
                    posMenor=j;
                }
            }
            aux = palabras[i];
            palabras[i] = palabras[posMenor];
            palabras[posMenor] = aux;
        }
    }

    private static void orden(int[] numeros){
        int aux;
        aux = 0;
        for(int j = 0; j < numeros.length; j++){
            for(int i = 0; i < numeros.length-1; i++){
                if(numeros[i] > numeros[i+1]){
                    aux = numeros[i];
                    numeros[i] = numeros[i+1];
                    numeros[i+1] = aux;
                }
            }
            System.out.println(Arrays.toString(numeros));
        }

    }

    private static void orden(String[] texto){
        String aux;
        aux = "";
        for(int j = 0; j < texto.length; j++){
            for(int i = 0; i < texto.length-1; i++){
                if((texto[i].compareTo(texto[i+1])>0)){
                    aux = texto[i];
                    texto[i] = texto[i+1];
                    texto[i+1] = aux;
                }
            }
            //System.out.println(Arrays.toString(texto));
        }

    }
}
