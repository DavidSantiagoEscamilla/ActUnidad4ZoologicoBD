package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.EspecieHabitat;
import com.davidsantiagoact2.infraestructura.RepositorioEspecieHabitatImpl;
import com.davidsantiagoact2.repositorios.RepositorioEspecieHabitat;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiEspecieHabitat extends JFrame {
    private final JTextField txtIdEspecie = new JTextField(5);
    private final JTextField txtIdHabitat = new JTextField(5);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final RepositorioEspecieHabitat repositorio = new RepositorioEspecieHabitatImpl();

    public GuiEspecieHabitat() {
        setTitle("Gestión de Especie-Hábitat");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("ID Especie:"));
        panel.add(txtIdEspecie);
        panel.add(new JLabel("ID Hábitat:"));
        panel.add(txtIdHabitat);

        JButton btnAgregar = new JButton("Agregar Relación");
        btnAgregar.addActionListener(e -> agregarRelacion());

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        add(panel, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        cargarRelaciones();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarRelacion() {
        try {
            int idEspecie = Integer.parseInt(txtIdEspecie.getText().trim());
            int idHabitat = Integer.parseInt(txtIdHabitat.getText().trim());

            EspecieHabitat relacion = new EspecieHabitat(idEspecie, idHabitat);
            repositorio.crear(relacion);
            modeloLista.addElement(relacion.toString());

            txtIdEspecie.setText("");
            txtIdHabitat.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarRelaciones() {
        modeloLista.clear();
        List<EspecieHabitat> lista = repositorio.consultarTodos();
        for (EspecieHabitat rel : lista) {
            modeloLista.addElement(rel.toString());
        }
    }
}
