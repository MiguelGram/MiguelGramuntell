package cuatroraya;

public class PantallaC {
    public static void rellenar(char[][] tablero){
        for(int fil = 0; fil < tablero.length; fil++){
            for(int col = 0; col < tablero[0].length; col++){
                tablero[fil][col] = '_';
            }
        }
    }
    public static void visualizar(char[][] tablero){
        for(int i = 0; i < tablero.length; i++){
            for(int x = 0; x < tablero[0].length; x++){
                System.out.print(tablero[i][x] + "  ");
            }
            System.out.println();
        }
    }
}
