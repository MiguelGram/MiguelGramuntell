package OrientadoAObjetos;

public class Instrumento {
    public void tocar(){
        System.out.println("Estas tocando");
    }
    public static class guitarra extends Instrumento{
        public void tocar(){
            System.out.println("Tocando guitarra");
        }
    }
    public static class piano extends Instrumento{
        public void tocar(){
            System.out.println("Tocando piano");
        }
    }

    public static void main(String[] args) {
        Instrumento i1 = new guitarra();
        Instrumento i2 = new piano();
        i1.tocar();
        i2.tocar();
    }
}
