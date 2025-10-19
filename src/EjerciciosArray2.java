import java.util.Scanner;

public class EjerciciosArray2 {

}

public static void alumnos() {
    Scanner sc = new Scanner(System.in);
    int nalum = 0;
    System.out.println("Cuantos alumnos hay: ");
    nalum = sc.nextInt();
    String[] alumnos = new String[nalum];
    Double[] altura = new Double[nalum];
    Double[] alturaorden = new Double[nalum];
    for(int i = 0; i < alumnos.length; i++){
        System.out.println("Dime el nombre del alumno " + (i + 1 ));
        alumnos[i] = sc.nextLine();
        System.out.println("Ahora dime la altura de ese mismo alumno ");
        altura[i] = sc.nextDouble();
    }
    for(int i = 0; i < alumnos.length; i++){

    }

}
