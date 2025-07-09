package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Habitat;
import com.davidsantiagoact2.infraestructura.RepositorioHabitatImpl;
import com.davidsantiagoact2.repositorios.RepositorioHabitat;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiHabitat extends JFrame {
    private final JTextField txtIdHabitat = new JTextField(5);
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtClima = new JTextField(10);
    private final JTextField txtIdZona = new JTextField(5);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final RepositorioHabitat repositorio = new RepositorioHabitatImpl();

    public GuiHabitat() {
        setTitle("Gestión de Hábitats");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        panel.add(new JLabel("ID Hábitat:"));
        panel.add(txtIdHabitat);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Clima:"));
        panel.add(txtClima);
        panel.add(new JLabel("ID Zona:"));
        panel.add(txtIdZona);

        JButton btnAgregar = new JButton("Agregar Hábitat");
        btnAgregar.addActionListener(e -> agregarHabitat());

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        add(panel, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        cargarHabitats();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarHabitat() {
        try {
            int idHabitat = Integer.parseInt(txtIdHabitat.getText().trim());
            String nombre = txtNombre.getText().trim();
            String clima = txtClima.getText().trim();
            int idZona = Integer.parseInt(txtIdZona.getText().trim());

            Habitat habitat = new Habitat(idHabitat, nombre, clima, idZona);
            repositorio.crear(habitat);
            modeloLista.addElement(habitat.toString());

            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtIdHabitat.setText("");
        txtNombre.setText("");
        txtClima.setText("");
        txtIdZona.setText("");
    }

    private void cargarHabitats() {
        modeloLista.clear();
        List<Habitat> lista = repositorio.consultarTodos();
        for (Habitat h : lista) {
            modeloLista.addElement(h.toString());
        }
    }
}
