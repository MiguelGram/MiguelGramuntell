package OrientadoAObjetos;

public class vehiculo {

    // ESTADO

    String tipoCombustible;
    public vehiculo(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public void tipoCombustible(){
        System.out.println(tipoCombustible);
    }

    public void mover(){
        System.out.println("El vehiculo se esta moviendo");
    }
    public static class moto extends vehiculo {
        public moto() {
            super("Diesel");
        }
        public void mover(){
            System.out.println("La moto se esta desplazando por la carretera a 2 ruedas");
        }
    }
    public static class coche extends vehiculo {
        public coche() {
            super("Gasolina");
        }

        public void mover() {
            System.out.println("El coche se está desplazando por la carretera.");
        }
    }
    public static class bicicleta extends vehiculo {
        public bicicleta( ) {
            super("No lleva nada");
        }
            public void mover(){
                System.out.println("La bicicleta se está pedaleando en el carril.");
            }
        }

    public static void main(String[] args) {
        coche miCoche = new coche();
        bicicleta miBicicleta = new bicicleta();
        moto miMoto = new moto();
        vehiculo[] array = new vehiculo[]{miCoche,miBicicleta, miMoto};
        for(int i = 0; i < array.length; i++){
            array[i].mover();
            array[i].tipoCombustible();
            System.out.println();
        }
    }
}
