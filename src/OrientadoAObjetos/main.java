package OrientadoAObjetos;

abstract class figuras{
    abstract double calcularArea();
}

class circulo extends figuras {
    double radio;

    public circulo(double radio) {
        this.radio = radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
    class rectangulo extends figuras {
        double base;
        double altura;

        public rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        public double calcularArea() {
            return base * altura;
        }
    }

    public class main{
        public static void main(String[] args) {
            circulo miCirculo = new circulo(4);
            rectangulo miRectangulo = new rectangulo(5,3);
            System.out.println(miCirculo.calcularArea());
            System.out.println(miRectangulo.calcularArea());
        }
    }

