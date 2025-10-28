package Proyecto1Evalucion;

public class testss {
    public static void main(String[] args) {
        char[][] tablero = new char[11][11];
        inicializarTablero(tablero);
        colocarBarcosPC(tablero, new int[]{4, 2, 4});
        visualizarTablero(tablero, tablero);

    }

    public static void inicializarTablero(char[][] tablero){
        for(int fil = 0; fil < tablero.length-1; fil++){
            tablero[fil][0] = (char)('A' + fil);
        }
        for(int col = 1; col < tablero[1].length; col++){
            tablero[tablero.length-1][col] = (char)('0' + (col-1));
        }
        for(int fil = 0; fil < tablero.length-1; fil++){
            for (int col = 1; col < tablero[1].length; col++){
                tablero[fil][col] = '~';
            }
        }
        tablero[tablero.length-1][0] = ' ';
    }

    public static void visualizarTablero(char[][] tableroDisparos,char[][] tablero){

        for(int fil = 0; fil < tablero.length; fil++) {
            for (int col = 0; col < tablero[1].length; col++) {
                System.out.print(tablero[fil][col] + "\t");
            }
            for (int col = 0; col < tableroDisparos[1].length; col++) {
                System.out.print(tableroDisparos[fil][col] + "\t");
            }
            System.out.println();
        }
    }

    public static void colocarBarcosPC(char[][] tablero, int[] barcos){
        int fil;
        int col;
        int verhor;
        for(int i = 0; i < barcos.length; i++){
            verhor = (int)(Math.random()*2);
            if(verhor == 0){
                fil = (int)(Math.random()*10);
                col = (int)((Math.random()*(10-barcos[i]))+1);
                if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                    tablero[fil][col] = 'B';
                    for(int b = 0; b < barcos[i]; b++){
                        tablero[fil][col+b] = 'B';
                    }
                }

            }
            else{
                fil = (int)(Math.random()*(10-barcos[i]));
                col = (int)(Math.random()*10);
                if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                    tablero[fil][col] = 'B';
                    for(int b = 0; b < barcos[i]; b++){
                        tablero[fil+b][col] = 'B';
                    }
                }
            }
        }
    }

    public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion){
        boolean valor = true;
        if(orientacion == 1){
            for(int x = 0; x < longitudBarco-1; x++) {
                if (tablero[fila + x][columna] != '~') {
                    valor = false;
                    break;
                }
            }
        }
        else if (orientacion == 0) {
            for(int x = 0; x < longitudBarco-1; x++) {
                if (tablero[fila][columna + x] != '~') {
                    valor = false;
                    break;
                }
            }
        }
        return valor;
    }

    private static void pruebas() {
        String[][] letter = new String[11][11];
        char letra = (char)(Math.random() * 6);
        char[][] tablero = new char[11][11];
        char pos2;
        char b = '8';
        int longitudBarco = 2;
        System.out.println((('9') - b)+1);
        if(longitudBarco > (10-b)){
            System.out.println("false");
        }

        //System.out.println(letra);
        for(int i = 0; i < 10; i++){

            System.out.println((int)(Math.random()*2)  + " SUma *2");
            letra = (char)(((Math.random() + 'A') + (Math.random()*10)));
            pos2 = (char)(Math.random()*10);
            System.out.print(letra + "  ");
            System.out.println((int)pos2);
        }
        for(int i = 'A'; i < 'J'; i++){
            System.out.println(i);
        }
    }
}
