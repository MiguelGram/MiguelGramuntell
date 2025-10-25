package Proyecto1Evalucion;

public class testss {
    public static void main(String[] args) {
        char[][] tablero = new char[11][11];
        inicializarTablero(tablero);
        for(int i = 0; i < 10; i++){
            colocarBarcosPC(tablero, new int[]{4, 2, 4});
            visualizarTablero(tablero, tablero);
            tablero = new char[11][11];
            inicializarTablero(tablero);
        }

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
            fil = (int)(Math.random()*10);
            col = (int)((Math.random()*10)+1);
            verhor = (int)(Math.random()*2); // 1 -> vertical 0 -> horizontal
            if(cabeBarco(tablero, barcos[i], fil, col, verhor)){
                for(int b = 0; b < barcos[i]; b++){
                    tablero[fil][col] = 'B';
                    if(verhor == 0){
                        col++;
                    }
                    else{
                        fil++;
                    }
                }
            }

        }
    }

    public static boolean cabeBarco(char[][] tablero, int longitudBarco, int fila, int columna, int orientacion){
        boolean valor = true;
        for(int i = 9, b = 10; i > longitudBarco; i--, b--){
            if(orientacion == 1){
                if(fila == i && longitudBarco > (9-i+1)){
                    valor = false;
                }
            }
            else if(orientacion == 0){
                if(columna ==  b && longitudBarco > (10-b+1)){
                    valor =  false;
                }
            }
        }
        if(!valor){
            return false;
        }
        else{
            return true;
        }
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
