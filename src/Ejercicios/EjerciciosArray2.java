package Ejercicios;

import java.util.Scanner;

public class EjerciciosArray2 {
    public static void main(String[] args) {
        numero1();
    }

    private static void numero1() {
        Scanner sc = new Scanner(System.in);
        int nalum = 0;
        System.out.println("Cuantos alumnos hay: ");
        nalum = sc.nextInt();
        sc.nextLine();
        String[] alumnos = new String[nalum];
        Double[] altura = new Double[nalum];
        Double[] alturaorden = new Double[nalum];
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Dime el nombre del alumno " + (i+1) + " de " + alumnos.length);
            alumnos[i] = sc.nextLine();
            System.out.println("Ahora dime la altura de ese mismo alumno ");
            altura[i] = sc.nextDouble();
            sc.nextLine(); // ← importante: limpiar el buffer después de nextDouble()
        }
        double max = 0;
        int i = 0;
        int p = 0;
        for(int b = 0; b < alumnos.length; b++){
            for (i = 0; i < alumnos.length; i++) {
                if (altura[i] > max) {
                    max = altura[i];
                    p = i;
                }
            }
            altura[p] = 0.0;
            p = 0;
            System.out.print(max + " ");
            max = 0;
        }
    }
}