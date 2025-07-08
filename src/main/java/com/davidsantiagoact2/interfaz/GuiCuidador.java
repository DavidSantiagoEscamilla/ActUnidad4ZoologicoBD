package com.davidsantiagoact2.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiCuidador extends JFrame {
    private final JTextField txtId;
    private final JTextField txtNombre;
    private final JTextField txtEspecialidad;
    private final DefaultListModel<String> modeloLista;
    private final JList<String> listaCuidadores;

    private final java.util.List<Cuidador> cuidadores = new ArrayList<>();

    public GuiCuidador() {
        setTitle("Gestión de Cuidadores");
        setSize(450, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(4, 2));
        formPanel.add(new JLabel("ID Cuidador:"));
        txtId = new JTextField();
        formPanel.add(txtId);

        formPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formPanel.add(txtNombre);

        formPanel.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        formPanel.add(txtEspecialidad);

        JButton btnAgregar = new JButton("Agregar");
        formPanel.add(btnAgregar);

        JButton btnEliminar = new JButton("Eliminar");
        formPanel.add(btnEliminar);

        panel.add(formPanel, BorderLayout.NORTH);

        modeloLista = new DefaultListModel<>();
        listaCuidadores = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaCuidadores);
        panel.add(scroll, BorderLayout.CENTER);

        add(panel);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idTexto = txtId.getText().trim();
                String nombre = txtNombre.getText().trim();
                String especialidad = txtEspecialidad.getText().trim();

                if (idTexto.isEmpty() || nombre.isEmpty() || especialidad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.");
                    return;
                }

                try {
                    int id = Integer.parseInt(idTexto);
                    Cuidador cuidador = new Cuidador(id, nombre, especialidad);
                    cuidadores.add(cuidador);
                    modeloLista.addElement(cuidador.toString());
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaCuidadores.getSelectedIndex();
                if (index != -1) {
                    cuidadores.remove(index);
                    modeloLista.remove(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un cuidador para eliminar.");
                }
            }
        });
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
        txtEspecialidad.setText("");
    }

    static class Cuidador {
        private final int id;
        private final String nombre;
        private final String especialidad;

        public Cuidador(int id, String nombre, String especialidad) {
            this.id = id;
            this.nombre = nombre;
            this.especialidad = especialidad;
        }

        @Override
        public String toString() {
            return id + " - " + nombre + " (" + especialidad + ")";
        }
    }
}
