package ProyectoMejora;

import a.conectados.Pantalla;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        letraNumero();
    }
    public static int numeroRandom(){
        int num;
        num = (int)(Math.random()*10);
        return num;
    }
    public static int orientacionBot(){
        int num;
        num = (int)(Math.random()*2);
        return num;
    }
    public static void colocarBarcosPC(char[][] tablero, int[] barcos){
        int pos1;
        int pos2;
        int orient;
        boolean colo = false;
        for(int b = 0 ; b < barcos.length; b++){
            colo = false;
            orient = orientacionBot();
            do{
                pos1 = numeroRandom();
                pos2 = numeroRandom();
                if(cabeBarco(tablero, barcos[b], pos1, pos2, orient)){
                    tablero[pos1][pos2] = 'B';
                    if(orient == 1){
                        for(int i = 0; i < barcos[b]; i++){
                            tablero[pos1+i][pos2] = 'B';
                        }
                        colo = true;
                    }
                    else {
                        for(int i = 0; i < barcos[b]; i++){
                            tablero[pos1][pos2+i] = 'B';
                        }
                        colo = true;
                    }
                }
            }while(!colo);
        }
    }
    public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion){
        boolean cabe = true;
        if(orientacion == 1){
            if((longitudBarco + fila) > 10){
                cabe = false;
            }
        }
        else if(orientacion == 0){
            if((longitudBarco + columna) > 10){
                cabe = false;
            }
        }
        if(cabe){
            if(orientacion == 1){
                for(int x = 0; x < longitudBarco; x++) {
                    if (tablero[fila + x][columna] != '~') {
                        cabe = false;
                    }
                }
            }
            else if (orientacion == 0) {
                for(int x = 0; x < longitudBarco; x++) {
                    if (tablero[fila][columna + x] != '~') {
                        cabe = false;
                    }
                }
            }
        }
        return cabe;
    }
    public static String letraNumero(){
        String pos;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Escribe una posicion entre la A-J y del 0-9");
            pos = sc.nextLine().toUpperCase();
            if(pos.length() != 2){
                Pantalla.mostrarError("La posicion indicada son solo 1 letra y 1 numero");
            }
            if((pos.charAt(1)) > '9'){
                Pantalla.mostrarError("Numero no valido");
            }
            if(pos.charAt(0) < 'A' || pos.charAt(0) > 'J'){
                Pantalla.mostrarError("La letra no es valida");
            }
        }while(pos.length() != 2 || pos.charAt(0) < 'A' || pos.charAt(0) > 'J' || pos.charAt(1) > '9');

        return pos;
    }
    public static int orientacion(){
        Scanner sc = new Scanner(System.in);
        String orientacion;
        int num;
        do{
            System.out.println("Vertical -> 1 Horizontal -> 0");
            orientacion = sc.nextLine();
            if(orientacion.length() != 1){
                Pantalla.mostrarError("Solo puede tener un numero");
            }
            if((orientacion.charAt(0)-'0') != 0 && (orientacion.charAt(0)-'0') != 1){
                Pantalla.mostrarError("Numero invalido");
            }

        }while((orientacion.charAt(0)-'0') != 0 && (orientacion.charAt(0)-'0') != 1 || orientacion.length() != 1);
        num = orientacion.charAt(0) - '0';
        return num;
    }
    public static void colocarBarcos(char[][] tablero, int[] barcos){
        String pos;
        int pos1;
        int pos2;
        int orient;
        boolean colo = false;
        for(int b = 0 ; b < barcos.length; b++){
            System.out.println("Coloca el barco " + (b+1) + " ocupa " + barcos[b] + " casillas");
            colo = false;
            orient = orientacion();
            do{
                pos = letraNumero();
                pos1 = (pos.charAt(0)-'A');
                pos2 = (pos.charAt(1)-'0');
                if(cabeBarco(tablero, barcos[b], pos1, pos2, orient)){
                    tablero[pos1][pos2] = 'B';
                    if(orient == 1){
                        for(int i = 0; i < barcos[b]; i++){
                            tablero[pos1+i][pos2] = 'B';
                        }
                        colo = true;
                    }
                    else {
                        for(int i = 0; i < barcos[b]; i++){
                            tablero[pos1][pos2+i] = 'B';
                        }
                        colo = true;
                    }
                }
            }while(!colo);
            ProyectoMejora.Pantalla.visualizar(tablero, tablero);
        }
    }
    public static boolean disparosPC(char[][] tablero, char[][] tableroDisparosPC){
        int num1 = 0;
        int num2 = 0;
        boolean vacio = true;

        do{
            num1 = numeroRandom();
            num2 = numeroRandom();
            if(tableroDisparosPC[num1][num2] != '~'){
                vacio = false;
            }
            else{
                vacio = true;
            }
        }while(!vacio);
        if(tablero[num1][num2] == 'B'){
            tableroDisparosPC[num1][num2] = 'T';
            tablero[num1][num2] = 'T';
            return true;
        }
        else if(tablero[num1][num2] == '~'){
            tableroDisparosPC[num1][num2] = 'X';
            tablero[num1][num2] = 'X';
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean disparosJugador(char[][] tableroPC, char[][] tableroDisparosJugador){
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una letra entre la A - J y un numero entre el 0 - 9");
        String disparo = sc.nextLine().toUpperCase();
        if (tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1)) - '0'] == 'B') {
            tableroDisparosJugador[disparo.charAt(0) - 'A'][(disparo.charAt(1)) - '0'] = 'T';
            tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1)) - '0'] = 'T';
            return true;
        } else if (tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1)) - '0'] == '~') {
            tableroDisparosJugador[disparo.charAt(0) - 'A'][(disparo.charAt(1)) - '0'] = 'X';
            tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1)) - '0'] = 'X';
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }
    public static int sumaCeldas(int[] unVector){
        int sum;
        sum = 0;
        for(int i = 0; i < unVector.length; i++){
            sum += unVector[i];
        }
        return sum;
    }
    public static int[] contadorDeTocados(char[][] tablero, char[][] tableroPC, int[] contador){
        contador[0] = 0;
        contador[1] = 0;
        for(int fil = 0; fil < tablero.length; fil++){
            for(int col = 1; col < tablero[1].length; col++){
                if(tablero[fil][col] == 'T'){
                    contador[0] ++;
                }
            }
        }
        for(int fil = 0; fil < tableroPC.length; fil++){
            for(int col = 1; col < tableroPC[1].length; col++){
                if(tableroPC[fil][col] == 'T'){
                    contador[1] ++;
                }
            }
        }
        return contador;
    }
}