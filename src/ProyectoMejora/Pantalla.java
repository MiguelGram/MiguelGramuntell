package ProyectoMejora;

public class Pantalla {

    public static void inicializar(char[][] tablero){
        for(int fil = 0; fil < tablero.length; fil++){
            for(int col = 0; col < tablero[1].length; col++){
                tablero[fil][col] = '~';
            }
        }
    }
    public static void visualizar(char[][] tablero, char[][] tableroDisparos){
        borrarPantalla();
        for(int fil = 0; fil < tablero.length; fil++){
            System.out.print((char)('A'+fil) + "  ");
            for(int col = 0; col < tablero[1].length; col++){
                System.out.print(tablero[fil][col] + "  ");
            }
            System.out.print("    ");
            System.out.print((char)('A'+fil) + "  ");
            for(int col = 0; col < tableroDisparos[1].length; col++){
                System.out.print(tableroDisparos[fil][col] + "  ");
            }
            System.out.println();
        }
    }
    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
