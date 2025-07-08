package com.davidsantiagoact2;

import com.davidsantiagoact2.interfaz.GuiAnimal;
import com.davidsantiagoact2.interfaz.GuiEspecie;
import com.davidsantiagoact2.interfaz.GuiCuidador;

import javax.swing.*;
import java.awt.*;

public class Menu2 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu2::mostrarMenuPrincipal);
    }

    private static void mostrarMenuPrincipal() {
        JFrame frame = new JFrame("Gestión del Zoológico");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new GridLayout(10, 1, 10, 10));

        frame.add(crearBoton("Gestionar Animales", () -> new GuiAnimal()));
        frame.add(crearBoton("Gestionar Especies", () -> new GuiEspecie().setVisible(true)));
        frame.add(crearBoton("Gestionar Cuidadores", () -> new GuiCuidador().setVisible(true)));
        frame.add(crearBoton("Gestionar Especie-Hábitat", () -> JOptionPane.showMessageDialog(null, "Próximamente...")));
        frame.add(crearBoton("Gestionar Cuidado", () -> JOptionPane.showMessageDialog(null, "Próximamente...")));
        frame.add(crearBoton("Gestionar Zonas", () -> JOptionPane.showMessageDialog(null, "Próximamente...")));
        frame.add(crearBoton("Gestionar Hábitat", () -> JOptionPane.showMessageDialog(null, "Próximamente...")));
        frame.add(crearBoton("Gestionar Itinerarios", () -> JOptionPane.showMessageDialog(null, "Próximamente...")));

        JButton salirBtn = new JButton("Salir");
        salirBtn.addActionListener(e -> System.exit(0));
        frame.add(salirBtn);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static JButton crearBoton(String texto, Runnable accion) {
        JButton boton = new JButton(texto);
        boton.addActionListener(e -> accion.run());
        return boton;
    }
}
