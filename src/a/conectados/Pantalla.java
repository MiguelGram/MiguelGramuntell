package a.conectados;

import com.diogonunes.jcolor.Attribute;

import static com.diogonunes.jcolor.Ansi.colorize;

public class Pantalla {

    public static void mostrarPantalla(String texto){
        System.out.println(texto);
    }
    public static void mostrarError(String mensajeError){
        System.out.println(colorize("Error!!", Attribute.TEXT_COLOR(255,0,0)));
        System.out.println(colorize(mensajeError, Attribute.TEXT_COLOR(255,0,0)));
    }
}
