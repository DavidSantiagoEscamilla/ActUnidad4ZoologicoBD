package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Animal;
import com.davidsantiagoact2.repositorios.RepositorioAnimal;
import com.davidsantiagoact2.infraestructura.RepositorioAnimalImpl;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class GuiAnimal extends JFrame {
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtFechaNacimiento = new JTextField(15);
    private final JTextField txtSexo = new JTextField(5);
    private final JTextField txtIdEspecie = new JTextField(5);
    private final JTextField txtIdHabitat = new JTextField(5);
    private final JTextField txtIdPersonal = new JTextField(5);

    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final JList<String> lista = new JList<>(modeloLista);

    private final RepositorioAnimal repositorio = new RepositorioAnimalImpl();

    public GuiAnimal() {
        setTitle("Gestión de Animales");
        setSize(500, 500);
        setLayout(new BorderLayout());

        // Formulario
        JPanel panelFormulario = new JPanel(new GridLayout(7, 2, 5, 5));
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

        // Botones
        JButton btnAgregar = new JButton("Agregar Animal");
        btnAgregar.addActionListener(e -> agregarAnimal());

        JButton btnMostrar = new JButton("Mostrar Animales");
        btnMostrar.addActionListener(e -> mostrarAnimales());

        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);

        // Lista
        JScrollPane scrollPane = new JScrollPane(lista);

        // Estructura
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
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

            Animal animal = new Animal(0, nombre, fechaNacimiento, sexo, idEspecie, idHabitat, idPersonal);
            repositorio.crear(animal);

            JOptionPane.showMessageDialog(this, "✅ Animal guardado en la base de datos.");
            limpiarCampos();
            mostrarAnimales();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "❌ Error al ingresar datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarAnimales() {
        modeloLista.clear();
        List<Animal> animales = repositorio.consultarTodos();
        for (Animal a : animales) {
            modeloLista.addElement(a.toString());
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
