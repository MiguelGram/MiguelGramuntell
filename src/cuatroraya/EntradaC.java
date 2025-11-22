package cuatroraya;

public class EntradaC {
    public static int tirarFichaPC(){
        int num;
        num = (int)(Math.random()*7);
        return num;
    }

    public static void cabeFicha(char[][] tablero, int pos, char pieza){
        if(tablero[0][pos] == '_'){
            if(tablero[1][pos] == '_'){
                if(tablero[2][pos] == '_'){
                    if(tablero[3][pos] == '_'){
                        if(tablero[4][pos] == '_'){
                            if(tablero[5][pos] == '_'){
                                tablero[5][pos] = pieza;
                            }else{
                                tablero[4][pos] = pieza;
                            }
                        }else{
                            tablero[3][pos] = pieza;
                        }
                    }else{
                        tablero[2][pos] = pieza;
                    }
                }else{
                    tablero[1][pos] = pieza;
                }
            }else{
                tablero[0][pos] = pieza;
            }
        }else {
            System.out.println("Mal");
        }
    }
}
