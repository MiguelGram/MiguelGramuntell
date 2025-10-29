package ProyectoMejora;

public class Juego {
    public static void main(String[] args) {
        char[][] tablero = new char[10][10];
        char[][] tableroDisparos = new char[10][10];
        Pantalla.inicializar(tablero);
        Pantalla.inicializar(tableroDisparos);
        Pantalla.visualizar(tablero, tableroDisparos);
        Entrada.colocarBarcosPC(tablero, new int[]{2,3});
        Pantalla.visualizar(tablero, tableroDisparos);
    }
}
