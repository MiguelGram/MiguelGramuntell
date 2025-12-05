package OrientadoAObjetos;

public class empleado {
    public double calcularSalario() {
        return 0;
    }

    public static class EmpleadoTiempoCompleto extends empleado{
        public double salarioFijo;
        public EmpleadoTiempoCompleto(double salarioFijo){
            this.salarioFijo=salarioFijo;
        }
        public double calcularSalario(){
            return salarioFijo;
        }
    }
    public static class EmpleadoPorHoras extends empleado{
        public double horas;
        public double dinero;
        public EmpleadoPorHoras(double horas, double dinero){
            this.horas=horas;
            this.dinero=dinero;
        }
        public double calcularSalario(){
            return horas*dinero;
        }
    }

    public static void main(String[] args) {
        empleado e1 = new EmpleadoPorHoras(30, 13);
        empleado e2 = new EmpleadoTiempoCompleto(1500);

        System.out.println(e1.calcularSalario());
        System.out.println(e2.calcularSalario());
    }
}
