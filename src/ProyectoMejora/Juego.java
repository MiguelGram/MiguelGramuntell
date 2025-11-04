package ProyectoMejora;

public class Juego {
    public static void main(String[] args) {
        char[][] tableroPC = new char[10][10];
        char[][] tableroDisparosPC = new char[10][10];
        char[][] tablero = new char[10][10];
        char[][] tableroDisparos = new char[10][10];
        int[] barcos = new int[]{2,3};
        int[] contador = new int[2];
        Pantalla.inicializar(tableroPC);
        Pantalla.inicializar(tablero);
        Pantalla.inicializar(tableroDisparosPC);
        Pantalla.inicializar(tableroDisparos);
        Pantalla.visualizar(tableroPC, tableroDisparosPC);
        Pantalla.visualizar(tablero, tableroDisparos);
        Entrada.colocarBarcos(tablero, barcos);
        Entrada.colocarBarcosPC(tableroPC, barcos);
        do{
            //Pantalla.visualizar(tableroPC, tableroDisparosPC);
            Entrada.disparosJugador(tableroPC, tableroDisparos);
            Entrada.disparosPC(tablero, tableroDisparosPC);
            Pantalla.visualizar(tablero, tableroDisparos);
            Pantalla.visualizar(tableroPC, tableroDisparosPC);
            Entrada.contadorDeTocados(tablero, tableroPC, contador);
        }while(Entrada.sumaCeldas(barcos) != contador[1] && Entrada.sumaCeldas(barcos) != contador[0]);
        Pantalla.mostrarError("Tenemos un ganador!!");

    }
}
