package ProyectoMejora;

public class Juego {
    public static void main(String[] args) {
        char[][] tableroPC = new char[10][10];
        char[][] tableroDisparosPC = new char[10][10];
        char[][] tablero = new char[10][10];
        char[][] tableroDisparos = new char[10][10];
        int[] barcos = new int[]{2,4,4,3,5};
        Pantalla.inicializar(tableroPC);
        Pantalla.inicializar(tablero);
        Pantalla.inicializar(tableroDisparosPC);
        Pantalla.visualizar(tableroPC, tableroDisparosPC);
        Pantalla.visualizar(tablero, tableroDisparos);
        //Entrada.colocarBarcos(tablero, barcos);
        Entrada.colocarBarcosPC(tableroPC, barcos);
        Pantalla.visualizar(tableroPC, tableroDisparosPC);
    }
}