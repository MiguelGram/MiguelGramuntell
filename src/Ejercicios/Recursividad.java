package Ejercicios;

public class Recursividad {
    public static void main(String[] args) {


    }
    public static int multi(int m, int n){
        if(n == 0) return 0;
        if(n == 1) return m;

        return m + multi(m, n-1);
    }

}
