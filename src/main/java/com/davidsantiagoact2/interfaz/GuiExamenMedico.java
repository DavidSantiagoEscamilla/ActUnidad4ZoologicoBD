package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.ExamenMedico;
import com.davidsantiagoact2.infraestructura.RepositorioExamenMedicoImpl;
import com.davidsantiagoact2.repositorios.RepositorioExamenMedico;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class GuiExamenMedico extends JFrame {
    private final JTextField txtId = new JTextField(5);
    private final JTextField txtTipo = new JTextField(15);
    private final JTextField txtResultado = new JTextField(15);
    private final JTextField txtIdAnimal = new JTextField(5);
    private final JTextField txtFecha = new JTextField(10);
    private final JTextArea areaExamenes = new JTextArea(10, 30);
    private final RepositorioExamenMedico repositorio = new RepositorioExamenMedicoImpl();

    public GuiExamenMedico() {
        setTitle("Gestión de Exámenes Médicos");
        setSize(400, 500);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(6, 2));
        panel.add(new JLabel("ID Examen:"));
        panel.add(txtId);
        panel.add(new JLabel("Tipo Examen:"));
        panel.add(txtTipo);
        panel.add(new JLabel("Resultado:"));
        panel.add(txtResultado);
        panel.add(new JLabel("ID Animal:"));
        panel.add(txtIdAnimal);
        panel.add(new JLabel("Fecha (YYYY-MM-DD):"));
        panel.add(txtFecha);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarExamen());

        JButton btnMostrar = new JButton("Mostrar");
        btnMostrar.addActionListener(e -> mostrarExamenes());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);

        JScrollPane scroll = new JScrollPane(areaExamenes);
        areaExamenes.setEditable(false);

        add(panel, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarExamen() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String tipo = txtTipo.getText().trim();
            String resultado = txtResultado.getText().trim();
            int idAnimal = Integer.parseInt(txtIdAnimal.getText().trim());
            LocalDate fecha = LocalDate.parse(txtFecha.getText().trim());

            ExamenMedico examen = new ExamenMedico(id, tipo, resultado, idAnimal, fecha);
            repositorio.crear(examen);
            limpiarCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos: " + ex.getMessage(), "❌ Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarExamenes() {
        areaExamenes.setText("");
        for (ExamenMedico examen : repositorio.consultarTodos()) {
            areaExamenes.append(examen.toString() + "\n");
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtTipo.setText("");
        txtResultado.setText("");
        txtIdAnimal.setText("");
        txtFecha.setText("");
    }
}
