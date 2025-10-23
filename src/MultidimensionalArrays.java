import java.util.Arrays;
import java.util.Scanner;

public class MultidimensionalArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantos alumnos hay -> ");
        int num = sc.nextInt();
        System.out.println("Cuantos asignaturas hay -> ");
        int asig = sc.nextInt();
        String[][] notas = new String[asig + 1][num + 1];
        notas[0][0] = "";
        nombres(notas);
        asignaturas(notas);
        autofill(notas);

        for(int b = 0; b < notas.length; b++){
            for(int i = 0; i < notas[1].length; i++){
                System.out.print(notas[b][i] + " ");
            }
            System.out.println("");
        }

        System.out.println("");

        show(notas);

    }

    private static void show(String[][] notas){
        for(String[] numero : notas){
            System.out.println(Arrays.toString(numero));
        }
        System.out.println();
    }

    public static void autofill(String[][] notas) {
        double result = 0;
        for(int col = 1; col < notas.length; col++){
            for(int fil = 1; fil < notas[1].length; fil++){
                result = Math.round(Math.random()*1000);
                notas[col][fil] = "" + result/100;
            }
        }
    }

    public static void nombres(String[][] notas) {
        Scanner sc = new Scanner(System.in);
        for(int col = 1; col < notas[1].length; col++){
            System.out.println("Escribe el " + (col) + " alumno");
            notas[0][col] = sc.nextLine();
        }
    }

    public static void asignaturas(String[][] notas) {
        Scanner sc = new Scanner(System.in);
        for(int fil = 1; fil < notas.length; fil++){
            System.out.println("Escribe la " + (fil) + " asignatura");
            notas[fil][0] = sc.nextLine();
        }
    }
}
