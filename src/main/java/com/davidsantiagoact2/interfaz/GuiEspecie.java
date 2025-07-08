package com.davidsantiagoact2.interfaz;

import com.davidsantiagoact2.clases.Especie;
import com.davidsantiagoact2.infraestructura.RepositorioEspecieImpl;
import com.davidsantiagoact2.repositorios.RepositorioEspecie;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiEspecie extends JFrame {

    private final JTextField txtId = new JTextField(5);
    private final JTextField txtNombreCientifico = new JTextField(15);
    private final JTextField txtNombreComun = new JTextField(15);
    private final JTextField txtTipo = new JTextField(10);
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final RepositorioEspecie repositorio = new RepositorioEspecieImpl();

    public GuiEspecie() {
        setTitle("Gestión de Especies");
        setSize(400, 500);
        setLayout(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2));
        panelFormulario.add(new JLabel("ID:"));
        panelFormulario.add(txtId);
        panelFormulario.add(new JLabel("Nombre Científico:"));
        panelFormulario.add(txtNombreCientifico);
        panelFormulario.add(new JLabel("Nombre Común:"));
        panelFormulario.add(txtNombreComun);
        panelFormulario.add(new JLabel("Tipo:"));
        panelFormulario.add(txtTipo);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnActualizar = new JButton("Actualizar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnRefrescar = new JButton("Refrescar");

        btnGuardar.addActionListener(e -> guardarEspecie());
        btnActualizar.addActionListener(e -> actualizarEspecie());
        btnEliminar.addActionListener(e -> eliminarEspecie());
        btnRefrescar.addActionListener(e -> cargarEspecies());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnGuardar);
        panelBotones.add(btnActualizar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(lista);

        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        cargarEspecies();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void guardarEspecie() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String cientifico = txtNombreCientifico.getText().trim();
            String comun = txtNombreComun.getText().trim();
            String tipo = txtTipo.getText().trim();

            Especie especie = new Especie(id, cientifico, comun, tipo);
            repositorio.crear(especie);
            limpiarCampos();
            cargarEspecies();
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    private void actualizarEspecie() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            String cientifico = txtNombreCientifico.getText().trim();
            String comun = txtNombreComun.getText().trim();
            String tipo = txtTipo.getText().trim();

            Especie especie = new Especie(id, cientifico, comun, tipo);
            repositorio.actualizar(especie);
            limpiarCampos();
            cargarEspecies();
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    private void eliminarEspecie() {
        try {
            int id = Integer.parseInt(txtId.getText().trim());
            repositorio.eliminar(id);
            limpiarCampos();
            cargarEspecies();
        } catch (Exception e) {
            mostrarError(e.getMessage());
        }
    }

    private void cargarEspecies() {
        modeloLista.clear();
        List<Especie> especies = repositorio.consultarTodos();
        for (Especie especie : especies) {
            modeloLista.addElement(especie.toString());
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtNombreCientifico.setText("");
        txtNombreComun.setText("");
        txtTipo.setText("");
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, "⚠️ Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
