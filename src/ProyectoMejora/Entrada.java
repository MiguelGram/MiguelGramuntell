package ProyectoMejora;

public class Entrada {
    public static void main(String[] args) {

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
        int orientacion;
        orientacion = orientacionBot();
        pos1 = numeroRandom();
        pos2 = numeroRandom();
        tablero[pos1][pos2] = 'B';
        if(orientacion == 1){
            for(int i = 0; i < barcos[i]; i++){
                tablero[pos1+i][pos2] = 'B';
            }
        }
        else{
            for(int i = 0; i < barcos[i]; i++){
                tablero[pos1][pos2+i] = 'B';
            }
        }
    }
}
