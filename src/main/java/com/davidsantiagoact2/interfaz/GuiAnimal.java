package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Animal;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GuiAnimal extends JFrame {
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtFechaNacimiento = new JTextField(15);
    private final JTextField txtSexo = new JTextField(5);
    private final JTextField txtIdEspecie = new JTextField(5);
    private final JTextField txtIdHabitat = new JTextField(5);
    private final JTextField txtIdPersonal = new JTextField(5);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final List<Animal> listaAnimales = new ArrayList<>();
    private int contadorId = 1;

    public GuiAnimal() {
        setTitle("Gestión de Animales");
        setSize(400, 500);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(7, 2));
        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Fecha Nacimiento (YYYY-MM-DD):"));
        panelFormulario.add(txtFechaNacimiento);
        panelFormulario.add(new JLabel("Sexo (M/F):"));
        panelFormulario.add(txtSexo);
        panelFormulario.add(new JLabel("ID Especie:"));
        panelFormulario.add(txtIdEspecie);
        panelFormulario.add(new JLabel("ID Hábitat:"));
        panelFormulario.add(txtIdHabitat);
        panelFormulario.add(new JLabel("ID Personal:"));
        panelFormulario.add(txtIdPersonal);

        JButton btnAgregar = new JButton("Agregar Animal");
        btnAgregar.addActionListener(e -> agregarAnimal());

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(lista);

        add(panelFormulario, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarAnimal() {
        try {
            String nombre = txtNombre.getText().trim();
            LocalDate fechaNacimiento = LocalDate.parse(txtFechaNacimiento.getText().trim());
            String sexo = txtSexo.getText().trim().toUpperCase();
            int idEspecie = Integer.parseInt(txtIdEspecie.getText().trim());
            int idHabitat = Integer.parseInt(txtIdHabitat.getText().trim());
            int idPersonal = Integer.parseInt(txtIdPersonal.getText().trim());

            Animal animal = new Animal(contadorId++, nombre, fechaNacimiento, sexo, idEspecie, idHabitat, idPersonal);
            listaAnimales.add(animal);
            modeloLista.addElement(animal.toString());

            limpiarCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al ingresar datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtFechaNacimiento.setText("");
        txtSexo.setText("");
        txtIdEspecie.setText("");
        txtIdHabitat.setText("");
        txtIdPersonal.setText("");
    }
}
