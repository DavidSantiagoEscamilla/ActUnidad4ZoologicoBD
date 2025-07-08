package com.davidsantiagoact2.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuiEspecie extends JFrame {
    private final JTextField txtId;
    private final JTextField txtNombre;
    private final DefaultListModel<String> modeloLista;
    private final JList<String> listaEspecies;

    private final java.util.List<Especie> especies = new ArrayList<>();

    public GuiEspecie() {
        setTitle("Gestión de Especies");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("ID:"));
        txtId = new JTextField();
        formPanel.add(txtId);

        formPanel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        formPanel.add(txtNombre);

        JButton btnAgregar = new JButton("Agregar");
        formPanel.add(btnAgregar);

        JButton btnEliminar = new JButton("Eliminar");
        formPanel.add(btnEliminar);

        panel.add(formPanel, BorderLayout.NORTH);

        modeloLista = new DefaultListModel<>();
        listaEspecies = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaEspecies);
        panel.add(scroll, BorderLayout.CENTER);

        add(panel);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idTexto = txtId.getText().trim();
                String nombre = txtNombre.getText().trim();

                if (idTexto.isEmpty() || nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor completa todos los campos.");
                    return;
                }

                try {
                    int id = Integer.parseInt(idTexto);
                    Especie especie = new Especie(id, nombre);
                    especies.add(especie);
                    modeloLista.addElement(especie.toString());
                    limpiarCampos();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El ID debe ser un número entero.");
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaEspecies.getSelectedIndex();
                if (index != -1) {
                    especies.remove(index);
                    modeloLista.remove(index);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una especie para eliminar.");
                }
            }
        });
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombre.setText("");
    }

    static class Especie {
        private final int id;
        private final String nombre;

        public Especie(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public String toString() {
            return id + " - " + nombre;
        }
    }
}
