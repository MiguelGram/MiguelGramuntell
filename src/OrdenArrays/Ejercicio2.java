package OrdenArrays;

import java.util.Arrays;

public class Ejercicio2 {
    public static void main(String[] args) {
        String[][] alturas = new String[][]{
                {"Juan", "luisa", "Carmen", "Teresa"},
                {"1.7", "1.65", "1.69", "1.82"}

        };

        //ordenAlfa(alturas);
        //System.out.println(Arrays.toString(alturas[0]));
        //System.out.println(Arrays.toString(alturas[1]));

        seleccion(alturas);
        System.out.println(Arrays.toString(alturas[0]));
        System.out.println(Arrays.toString(alturas[1]));

    }

    private static void ordenAlfa(String[][]tabla){
        int posMenor;
        int posMenor2;
        String aux;
        String aux2;

        posMenor = 0;
        posMenor2 = 0;
        for(int i = 0; i < tabla[1].length; i++){
            posMenor = i;
            for(int j = i; j < tabla[1].length; j++){
                if((tabla[0][j].compareTo(tabla[0][posMenor])) < 0){
                    posMenor=j;
                }
            }
            aux = tabla[0][i];
            aux2 = tabla[1][i];
            tabla[0][i] = tabla[0][posMenor];
            tabla[1][i] = tabla[1][posMenor];
            tabla[0][posMenor] = aux;
            tabla[1][posMenor] = aux2;
        }
    }

    private static void seleccion(String[][] tabla){
        int posMenor;
        String aux;
        String aux2;

        posMenor = 0;
        for(int i = 0; i < tabla[1].length; i++){
            posMenor = i;
            for(int j = i; j < tabla[1].length; j++){
                if(tabla[1][j].compareTo(tabla[1][posMenor]) < 0){
                    posMenor=j;
                }
            }
            aux = tabla[1][i];
            aux2 = tabla[0][i];
            tabla[1][i] = tabla[1][posMenor];
            tabla[0][i] = tabla[0][posMenor];
            tabla[1][posMenor] = aux;
            tabla[0][posMenor] = aux2;
        }
    }
}
