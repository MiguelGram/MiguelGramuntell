package Proyecto1Evalucion;

import java.util.Scanner;

public class Proyecto {
    public static void main(String[] args) {
        int num = 0;
        Scanner sc = new Scanner(System.in);
        char[][] tablero = new char[11][11];
        char[][] tableroDisparos = new char[11][11];
        char[][] tableroPC = new char[11][11];
        char[][] tableroDisparosJugador = new char[11][11];
        inicializarTablero(tablero);
        inicializarTablero(tableroPC);
        inicializarTablero(tableroDisparos);
        inicializarTablero(tableroDisparosJugador);
        colocarBarcosPC(tablero, new int[]{4, 2, 4});
        visualizarTablero(tablero, tableroDisparosJugador);
        visualizarTablero(tableroPC, tableroDisparos);
        while ((disparoJugador(tablero, tableroDisparosJugador))) {
            visualizarTablero(tablero, tableroDisparosJugador);
            //visualizarTablero(tableroPC, tableroDisparos); //PREGUNTAR COMO TIENE QUE IR 4 TABLEROS 2 PARA CADA JUGADOR UNO DE BARCOS Y UNO DE DISPAROS SI ES ASI CAMBIAR EL METODO DE DISPARO DE JUGADOR
            if (disparoJugador(tablero, tableroDisparosJugador)) {
                visualizarTablero(tablero, tableroDisparosJugador);
                //visualizarTablero(tableroPC, tableroDisparos);
            }
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

    public static void visualizarTablero(char[][] tableroDisparos, char[][] tablero) {

        for (int fil = 0; fil < tablero.length; fil++) {
            for (int col = 0; col < tablero[1].length; col++) {
                System.out.print(tablero[fil][col] + "\t");
            }
            for (int col = 0; col < tableroDisparos[1].length; col++) {
                System.out.print(tableroDisparos[fil][col] + "\t");
            }
            System.out.println();
        }
    }

    public static boolean disparoJugador(char[][] tableroPC, char[][] tableroDisparosJugador) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una letra entre la A - J y un numero entre el 0 - 9");
        String disparo = sc.nextLine().toUpperCase();
        if (tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] == 'B') {
            tableroDisparosJugador[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] = 'T';
            return true;
        } else if (tableroPC[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] == '~') {
            tableroDisparosJugador[disparo.charAt(0) - 'A'][(disparo.charAt(1) + 1) - '0'] = 'X';
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
        for (int i = 0; i < barcos.length; i++) {
                fil = (int) (Math.random() * 10);
                col = (int) ((Math.random() * 10) + 1);
                verhor = (int) (Math.random() * 2); // 1 -> vertical 0 -> horizontal
                if (cabeBarco(tablero, barcos[i], fil, col, verhor)) {
                    for (int b = 0; b < barcos[i]; b++) {
                        tablero[fil][col] = 'B';
                        if (verhor == 0) {
                            col++;
                        } else {
                            fil++;
                        }
                    }
                }
        }
    }// 0 -> horizontal 1 -> vertical

    public static void colocarBarcosJugador(char[][] tablero, int[] barcos) {
        //PREGUNTAR COMO HACER NO SE -> PARECIDO AL DE ARRIBA SEGURO
    }

    public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion) {
        boolean valor = true;
        for (int i = 9, b = 10; i > longitudBarco; i--, b--) {
            if (orientacion == 1) {
                if (fila == i && longitudBarco > (9 - i + 1)) {
                    valor = false;
                }

            } else if (orientacion == 0) {
                if (columna == b && longitudBarco > (10 - b + 1)) {
                    valor = false;
                }
            }
        }
        if (!valor) {
            valor = false;
        } else if(valor){
            if(orientacion == 1){
                for(int x = 0; x < longitudBarco-1; x++) {
                    if (tablero[fila + x][columna] != '~') {
                        valor = false;
                    }
                }
            }
            else if (orientacion == 0) {
                for(int x = 0; x < longitudBarco-1; x++) {
                    if (tablero[fila][columna+x] != '~') {
                        valor = false;
                    }
                }
            }
        }
        return valor;
    }

    public static boolean colocarBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion, boolean jugador) {
        return true;
    }


}
