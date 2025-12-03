package OrientadoAObjetos;

public class bicicleta {
    private int velocidadActual;
    private int platoActual;
    private int pinonActual;

    public bicicleta(int velocidadActual, int platoActual, int pinonActual) {
        this.velocidadActual = velocidadActual;
        this.platoActual = platoActual;
        this.pinonActual = pinonActual;
    }

    public void acelerar() {
        this.velocidadActual = velocidadActual * 2;
    }

    public void frenar() {
        this.velocidadActual = velocidadActual / 2;
    }

    public void cambiarPlato(int plato) {
        this.platoActual = plato;
    }

    public void cambiarPinon(int pinon) {
        this.pinonActual = pinon;
    }

    public static void main(String[] args) {
        bicicleta miBicicleta = new bicicleta(5, 3, 2);
        bicicleta tuBicicleta = new bicicleta(7, 5, 3);

    }
}
