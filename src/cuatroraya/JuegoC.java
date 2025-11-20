package cuatroraya;

public class JuegoC {
    public static void main(String[] args) {
        char[][] tablero = new char[6][7];
        int pos;
        int i = 0;

        PantallaC.rellenar(tablero);
        PantallaC.visualizar(tablero);

        while(i != 10){
            pos = EntradaC.tirarFichaPC();
            EntradaC.cabeFicha(tablero, pos, 'X');
            System.out.println();
            System.out.println();
            PantallaC.visualizar(tablero);
            i++;

        }
    }
}
