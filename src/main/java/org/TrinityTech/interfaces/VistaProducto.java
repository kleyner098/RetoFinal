package org.TrinityTech.interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaProducto extends JFrame{

    private JTable clientesTable;
    private DefaultTableModel clientesTableModel;
    private JButton agregarButton;
    private JButton refreshButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JButton exportarButton;
    private AgregarProductoDialog agregarClienteDialog;
    private ModificarProductoDialog modificarProductoDialog;
    private EliminarProductoDialog eliminarProductoDialog;

    public VistaProducto() {


        setTitle("Gestionar prodcutos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));

        JPanel panelClientes = new JPanel(new BorderLayout());

        agregarButton = new JButton("Agregar clientes");
        modificarButton = new JButton("Modificar cliente");
        eliminarButton = new JButton("Eliminar cliente");
        refreshButton = new JButton("Actualizar clientes");
        exportarButton = new JButton("Exportar a XML"); // Nuevo botón

        clientesTable = new JTable(clientesTableModel);

        JScrollPane scrollPane = new JScrollPane(clientesTable);
        panelClientes.add(scrollPane, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(modificarButton);
        buttonPanel.add(eliminarButton);
        buttonPanel.add(exportarButton);
        panelClientes.add(buttonPanel, BorderLayout.SOUTH);

        panelPrincipal.add(panelClientes);

        add(panelPrincipal);

        agregarClienteDialog = new AgregarProductoDialog();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregarClienteDialog.setVisible(true);
            }
        });

        modificarProductoDialog = new ModificarProductoDialog();
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarProductoDialog.setVisible(true);
            }
        });

        eliminarProductoDialog = new EliminarProductoDialog();
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarProductoDialog.setVisible(true);
            }
        });

        setVisible(true);
    }

    public JButton getExportarButton() {
        return exportarButton;
    }

    public JTable getClientesTable() {
        return clientesTable;
    }

    public DefaultTableModel getClientesTableModel() {
        return clientesTableModel;
    }

    public EliminarProductoDialog getEliminarProductoDialog() {
        return eliminarProductoDialog;
    }

    public ModificarProductoDialog getModificarProductoDialog() {
        return modificarProductoDialog;
    }

    public AgregarProductoDialog getAgregarClienteDialog() {
        return agregarClienteDialog;
    }

    public class AgregarProductoDialog extends JDialog {
        private JTextField nombreField, emailField;
        private JButton agregarButton;

        public AgregarProductoDialog() {

            setSize(300, 200);
            setLocationRelativeTo(null);

            JPanel panelFormulario = new JPanel(new GridLayout(3, 2));
            JLabel nombreLabel = new JLabel("Nombre:");
            nombreField = new JTextField(20);
            JLabel emailLabel = new JLabel("Email:");
            emailField = new JTextField(20);
            agregarButton = new JButton("Agregar");

            panelFormulario.add(nombreLabel);
            panelFormulario.add(nombreField);
            panelFormulario.add(emailLabel);
            panelFormulario.add(emailField);
            panelFormulario.add(new JLabel());
            panelFormulario.add(agregarButton);

            add(panelFormulario);

        }

        public JTextField getNombreField() {
            return nombreField;
        }

        public JTextField getEmailField() {
            return emailField;
        }

        public JButton getAgregarButton() {
            return agregarButton;
        }
    }

    public class ModificarProductoDialog extends JDialog {
        private JTextField idField, nombreField, emailField;
        private JButton modificarButton;

        public ModificarProductoDialog() {

            setSize(300, 200);
            setLocationRelativeTo(null);

            JPanel panelFormulario = new JPanel(new GridLayout(4, 2));
            JLabel idLabel = new JLabel("ID del Cliente:");
            idField = new JTextField(20);
            JLabel nombreLabel = new JLabel("Nuevo Nombre:");
            nombreField = new JTextField(20);
            JLabel emailLabel = new JLabel("Nuevo Email:");
            emailField = new JTextField(20);
            modificarButton = new JButton("Modificar");

            panelFormulario.add(idLabel);
            panelFormulario.add(idField);
            panelFormulario.add(nombreLabel);
            panelFormulario.add(nombreField);
            panelFormulario.add(emailLabel);
            panelFormulario.add(emailField);
            panelFormulario.add(new JLabel());
            panelFormulario.add(modificarButton);

            add(panelFormulario);
        }

        public JTextField getIdField() {
            return idField;
        }

        public JTextField getNombreField() {
            return nombreField;
        }

        public JTextField getEmailField() {
            return emailField;
        }

        public JButton getModificarButton() {
            return modificarButton;
        }
    }

    public class EliminarProductoDialog extends JDialog {
        private JTextField idField;
        private JButton eliminarButton;

        public JTextField getIdField() {
            return idField;
        }

        public JButton getEliminarButton() {
            return eliminarButton;
        }

        public EliminarProductoDialog() {
            setSize(300, 150);
            setLocationRelativeTo(null);

            JPanel panelFormulario = new JPanel(new GridLayout(2, 2));
            JLabel idLabel = new JLabel("ID del Cliente a Eliminar:");
            idField = new JTextField(20);
            eliminarButton = new JButton("Eliminar");

            panelFormulario.add(idLabel);
            panelFormulario.add(idField);
            panelFormulario.add(new JLabel());
            panelFormulario.add(eliminarButton);

            add(panelFormulario);

        }
    }

    public static void main(String[] args) {
        new VistaProducto();
    }
}
