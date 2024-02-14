package controlador;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import vista.VntLogin;

public class Principal {

    public static void main(String[] args) {
        // Crear una instancia de VntLogin
        FlatLaf.registerCustomDefaultsSource("flat");
        FlatMacLightLaf.setup();

        VntLogin ventanaPrincipal = new VntLogin();
        // Hacer visible la ventana
        ventanaPrincipal.setVisible(true);
    }
}
