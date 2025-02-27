package com.pesguicom.zona_fit;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.pesguicom.zona_fit.gui.ZonaFitForma;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import javax.swing.*;

@SpringBootApplication
public class ZonaFitSwing {
    public static void main(String[] args) {
        //Configuramos el modo oscuro
        FlatDarculaLaf.setup();
        //Instanciar la fábrica de Spring
        ConfigurableApplicationContext contextoSpring = new SpringApplicationBuilder(ZonaFitSwing.class)
                .headless(false) //método
                .web(WebApplicationType.NONE)  //método para que NO corra en la web
                .run(args); //método
        //Crear un objeto de Swing
        SwingUtilities.invokeLater(() -> {
            ZonaFitForma zonaFitForma = contextoSpring.getBean(ZonaFitForma.class); //creando objeto (de la clase)
            zonaFitForma.setVisible(true); //anotación Lambda
        });
    }
}
