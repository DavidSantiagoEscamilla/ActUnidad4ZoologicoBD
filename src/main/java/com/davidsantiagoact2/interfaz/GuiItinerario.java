package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Itinerario;
import com.davidsantiagoact2.infraestructura.RepositorioItinerarioImpl;
import com.davidsantiagoact2.repositorios.RepositorioItinerario;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiItinerario extends JFrame {
    private final JTextField txtId = new JTextField(5);
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtDescripcion = new JTextField(20);
    private final JTextField txtDuracion = new JTextField(5);
    private final JTextField txtIdGuia = new JTextField(5);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final RepositorioItinerario repositorio = new RepositorioItinerarioImpl();

    public GuiItinerario() {
        setTitle("Gestión de Itinerarios");
        setSize(450, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("ID Itinerario:"));
        panel.add(txtId);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);
        panel.add(new JLabel("Descripción:"));
        panel.add(txtDescripcion);
        panel.add(new JLabel("Duración (min):"));
        panel.add(txtDuracion);
        panel.add(new JLabel("ID Guía:"));
        panel.add(txtIdGuia);

        JButton btnAgregar = new JButton("Agregar Itinerario");
        btnAgregar.addActionListener(e -> agregarItinerario());

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        add(panel, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        cargarItinerarios();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarItinerario() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String nombre = txtNombre.getText().trim();
            String descripcion = txtDescripcion.getText().trim();
            int duracion = Integer.parseInt(txtDuracion.getText().trim());
            int idGuia = Integer.parseInt(txtIdGuia.getText().trim());

            Itinerario i = new Itinerario(id, nombre, descripcion, duracion, idGuia);
            repositorio.crear(i);
            modeloLista.addElement(i.toString());

            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtDuracion.setText("");
        txtIdGuia.setText("");
    }

    private void cargarItinerarios() {
        modeloLista.clear();
        List<Itinerario> lista = repositorio.consultarTodos();
        for (Itinerario i : lista) {
            modeloLista.addElement(i.toString());
        }
    }
}
