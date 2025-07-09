package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Zona;
import com.davidsantiagoact2.infraestructura.RepositorioZonaImpl;
import com.davidsantiagoact2.repositorios.RepositorioZona;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiZona extends JFrame {
    private final JTextField txtIdZona = new JTextField(5);
    private final JTextField txtNombre = new JTextField(15);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final RepositorioZona repositorio = new RepositorioZonaImpl();

    public GuiZona() {
        setTitle("Gestión de Zonas");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID Zona:"));
        panel.add(txtIdZona);
        panel.add(new JLabel("Nombre:"));
        panel.add(txtNombre);

        JButton btnAgregar = new JButton("Agregar Zona");
        btnAgregar.addActionListener(e -> agregarZona());

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        add(panel, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        cargarZonas();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarZona() {
        try {
            int idZona = Integer.parseInt(txtIdZona.getText().trim());
            String nombre = txtNombre.getText().trim();

            Zona zona = new Zona(idZona, nombre);
            repositorio.crear(zona);
            modeloLista.addElement(zona.toString());

            txtIdZona.setText("");
            txtNombre.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarZonas() {
        modeloLista.clear();
        List<Zona> lista = repositorio.consultarTodos();
        for (Zona z : lista) {
            modeloLista.addElement(z.toString());
        }
    }
}
