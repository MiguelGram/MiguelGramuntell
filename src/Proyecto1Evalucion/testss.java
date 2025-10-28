package Proyecto1Evalucion;

import java.util.Scanner;

public class testss {
    public static void main(String[] args) {
        borrarPantalla();
        Scanner sc = new Scanner(System.in);
        char[][] tablero = new char[11][11];
        char[][] tableroDisparos = new char[11][11];
        int[] barcos = new int[]{2,2};
        int hbola = 0;
        inicializarTablero(tablero);
        inicializarTablero(tableroDisparos);
        colocarBarcosPC(tablero, barcos);
        boolean si = true;
        for(int i = 0; i < 10; i++){
            disparoPC(tableroDisparos, tablero);
            visualizarTablero(tablero, tableroDisparos);
        }
    }

    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void inicializarTablero(char[][] tablero) {
        for (int fil = 0; fil < tablero.length - 1; fil++) {
            tablero[fil][0] = (char) ('A' + fil);
        }
        for (int col = 1; col < tablero[1].length; col++) {
            tablero[tablero.length - 1][col] = (char) ('0' + (col - 1));
        }
        for (int fil = 0; fil < tablero.length - 1; fil++) {
            for (int col = 1; col < tablero[1].length; col++) {
                tablero[fil][col] = '~';
            }
        }
        tablero[tablero.length - 1][0] = ' ';
    }

    public static void visualizarTablero(char[][] tablero, char[][] tableroDisparos) {

        for (int fil = 0; fil < tablero.length; fil++) {
            for (int col = 0; col < tablero[1].length; col++) {
                System.out.print(tablero[fil][col] + "  ");
            }
            System.out.print("\t");
            for (int col = 0; col < tableroDisparos[1].length; col++) {
                System.out.print(tableroDisparos[fil][col] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
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

    public static boolean disparoJugador(char[][] tableroPC, char[][] tableroDisparosJugador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una letra entre la A - J y un numero entre el 0 - 9");
        String disparo = sc.nextLine().toUpperCase();
        if (tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] == 'B') {
            tableroDisparosJugador[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] = 'T';
            tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] = 'T';
            return true;
        } else if (tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] == '~') {
            tableroDisparosJugador[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] = 'X';
            tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] = 'X';
            return true;
        } else {
            System.out.println("Error");
            return false;
        }
    }

    public static boolean disparoPC(char[][] tableroDisparosPC, char[][] tableroJugador){
        int num1 = 0;
        int num2 = 0;
        boolean vacio = true;

        do{
            num1 = (int)(Math.random()*10);
            num2 = (int)((Math.random()*10));
            if(tableroDisparosPC[num1][num2] != '~'){
                vacio = false;
            }
            else{
                vacio = true;
            }
        }while(!vacio);
        if(tableroJugador[num1][num2] == 'B'){
            tableroDisparosPC[num1][num2] = 'T';
            tableroJugador[num1][num2] = 'T';
            return true;
        }
        else if(tableroJugador[num1][num2] == '~'){
            tableroDisparosPC[num1][num2] = 'X';
            tableroJugador[num1][num2] = 'X';
            return true;
        }
        else{
            return false;
        }
    }

    public static void colocarBarcosPC(char[][] tablero, int[] barcos) {
        int fil;
        int col;
        int verhor;
        boolean puesto = false;
        for(int i = 0; i < barcos.length; i++){
            verhor = (int)(Math.random()*2);
            if(verhor == 0){
                do{
                    fil = (int)(Math.random()*10);
                    col = (int)((Math.random()*(10-barcos[i]))+1);
                    if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                        tablero[fil][col] = 'B';
                        for(int b = 0; b < barcos[i]; b++){
                            tablero[fil][col+b] = 'B';
                            puesto = true;
                        }
                    }
                }while(!puesto);
                puesto = false;
            }
            else{
                do{
                    fil = (int)(Math.random()*(10-barcos[i]));
                    col = (int)(Math.random()*10);
                    if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                        tablero[fil][col] = 'B';
                        for(int b = 0; b < barcos[i]; b++){
                            tablero[fil+b][col] = 'B';
                            puesto = true;
                        }
                    }
                }while(!puesto);
                puesto = false;
            }
        }
    }// 0 -> horizontal 1 -> vertical

    public static void colocarBarcosJugador(char[][] tablero, int[] barcos) {
        int fil;
        int col;
        String pos;
        int verhor;
        Scanner sc = new Scanner(System.in);
        boolean puesto = false;
        for(int i = 0; i < barcos.length; i++){
            System.out.println("El barco " + (i+1) + " mide " + barcos[i] + " casillas");
            System.out.println("Para el barco en vertical -> 1. Para en horizontal -> 0");
            verhor = sc.nextInt();
            sc.nextLine();
            if(verhor == 0){
                do{
                    System.out.println("Escribe la posicion donde va a empezar tu barco ");
                    pos = sc.nextLine().toUpperCase();
                    fil = (pos.charAt(0) - 'A');
                    col = (pos.charAt(1) - '0')+1;
                    if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                        tablero[fil][col] = 'B';
                        for(int b = 0; b < barcos[i]; b++){
                            tablero[fil][col+b] = 'B';
                            puesto = true;
                        }
                        visualizarTablero(tablero, tablero);
                    }
                }while(!puesto);
                puesto = false;
            }
            else if(verhor == 1){
                do{
                    System.out.println("Escribe la posicion donde va a empezar tu barco ");
                    pos = sc.nextLine().toUpperCase();
                    fil = (pos.charAt(0) - 'A');
                    col = (pos.charAt(1) - '0')+1;
                    if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                        tablero[fil][col] = 'B';
                        for(int b = 0; b < barcos[i]; b++){
                            tablero[fil+b][col] = 'B';
                            puesto = true;
                        }
                        visualizarTablero(tablero, tablero);
                    }
                }while(!puesto);
                puesto = false;
            }
        }
    }// 0 -> horizontal 1 -> vertical


    public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
        boolean valor = true;
        if(orientacion == 1){
            for(int x = 0; x < longitudBarco; x++) {
                if (tablero[fila + x][columna] != '~') {
                    valor = false;
                }
            }
        }
        else if (orientacion == 0) {
            for(int x = 0; x < longitudBarco; x++) {
                if (tablero[fila][columna + x] != '~') {
                    valor = false;
                }
            }
        }
        return valor;
    }

    public static int sumaCeldas(int[] unVector){
        int sum;
        sum = 0;
        for(int i = 0; i < unVector.length; i++){
            sum += unVector[i];
        }
        return sum;
    }
}


// cabe barco para mi es ver si hay colision y mi cabe barco esta integrado en colocar barco si no entra te vuelve a pedir dato.