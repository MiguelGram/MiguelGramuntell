package ProyectoMejora;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

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
        tableronums();
        System.out.println();
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
        tableronums();
        System.out.println();
        System.out.println();
    }
    public static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void mostrarPantalla(String texto){
        System.out.println(texto);
    }
    public static void mostrarError(String mensajeError){
        System.out.println(colorize("Error!!", Attribute.TEXT_COLOR(255,0,0)));
        System.out.println(colorize(mensajeError, Attribute.TEXT_COLOR(255,0,0)));
    }
    public static void ganador(String ganador){
        System.out.println(colorize(ganador, Attribute.TEXT_COLOR(0,255,0)));
    }
    public static void tableronums(){
        System.out.print("   ");
        for(int i = 0; i < 10; i++){
            System.out.print(i + "  ");
        }
        System.out.print("       ");
        for(int i = 0; i < 10; i++){
            System.out.print(i + "  ");
        }
    }
}