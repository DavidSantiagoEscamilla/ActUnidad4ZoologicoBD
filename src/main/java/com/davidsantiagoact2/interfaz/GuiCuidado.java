package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Cuidado;
import com.davidsantiagoact2.infraestructura.RepositorioCuidadoImpl;
import com.davidsantiagoact2.repositorios.RepositorioCuidado;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class GuiCuidado extends JFrame {
    private final JTextField txtIdPersonal = new JTextField(5);
    private final JTextField txtIdAnimal = new JTextField(5);
    private final JTextField txtFecha = new JTextField(10);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final RepositorioCuidado repositorio = new RepositorioCuidadoImpl();

    public GuiCuidado() {
        setTitle("Gestión de Cuidado");
        setSize(400, 400);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("ID Personal:"));
        panel.add(txtIdPersonal);
        panel.add(new JLabel("ID Animal:"));
        panel.add(txtIdAnimal);
        panel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        panel.add(txtFecha);

        JButton btnAgregar = new JButton("Agregar Cuidado");
        btnAgregar.addActionListener(e -> agregarCuidado());

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        add(panel, BorderLayout.NORTH);
        add(btnAgregar, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        cargarCuidados();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarCuidado() {
        try {
            int idPersonal = Integer.parseInt(txtIdPersonal.getText().trim());
            int idAnimal = Integer.parseInt(txtIdAnimal.getText().trim());
            LocalDate fecha = LocalDate.parse(txtFecha.getText().trim());

            Cuidado cuidado = new Cuidado(idPersonal, idAnimal, fecha);
            repositorio.crear(cuidado);
            modeloLista.addElement(cuidado.toString());

            txtIdPersonal.setText("");
            txtIdAnimal.setText("");
            txtFecha.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "❌ Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarCuidados() {
        modeloLista.clear();
        List<Cuidado> lista = repositorio.consultarTodos();
        for (Cuidado c : lista) {
            modeloLista.addElement(c.toString());
        }
    }
}
