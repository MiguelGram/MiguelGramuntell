package Proyecto1Evalucion;

import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        borrarPantalla();
        Scanner sc = new Scanner(System.in);
        char[][] tablero = new char[11][11];
        char[][] tableroDisparos = new char[11][11];
        char[][] tableroPC = new char[11][11];
        char[][] tableroDisparosJugador = new char[11][11];
        int[] barcos = new int[]{2,2,2};
        int[] contador = new int[2];
        inicializarTablero(tablero);
        inicializarTablero(tableroDisparos);
        inicializarTablero(tableroPC);
        inicializarTablero(tableroDisparosJugador);
        colocarBarcosPC(tableroPC, barcos);
        visualizarTablero(tablero, tableroDisparosJugador);
        visualizarTablero(tableroPC, tableroDisparos);
        while(sumaCeldas(barcos) != contador[1] && sumaCeldas(barcos) != contador[0]){
            disparoJugador(tableroPC, tableroDisparosJugador);
            borrarPantalla();
            contadorDeTocados(tablero, tableroPC, contador);
            visualizarTablero(tablero, tableroDisparosJugador);
            visualizarTablero(tableroPC, tableroDisparos);
        }
        borrarPantalla();
        System.out.println("FIN");
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

    }

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
