package cliente.tcp.cliente.vista;

import cliente.tcp.cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Registro extends JFrame{
    private JPanel Registro;
    private JTextField nombre;
    private JRadioButton ingreso;
    private JButton Registrar;
    private JRadioButton salidaAlmuerzo;
    private JRadioButton retornoAlmuerzo;
    private JRadioButton salida;
    private JLabel Resultado;
    private JButton cerrarButton;

    public Registro() {
        setTitle("Registro");
        setContentPane(Registro);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 500));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(ingreso);
        grupo.add(salidaAlmuerzo);
        grupo.add(retornoAlmuerzo);
        grupo.add(salida);

        Registrar.addActionListener(e -> {
            if (nombre.getText().isEmpty()) {
                Resultado.setText("No ha ingresado un nombre");
                Resultado.setForeground(Color.RED);
                return;
            }
            String tipo = null;
            if (ingreso.isSelected()) tipo = "entrada";
            else if (salidaAlmuerzo.isSelected()) tipo = "almuerzo";
            else if (retornoAlmuerzo.isSelected()) tipo = "regreso";
            else if (salida.isSelected()) tipo = "salida";
            if (tipo == null) {
                Resultado.setText("No se ha seleccionado el registro");
                Resultado.setForeground(Color.RED);
                return;
            }
            try {
                String respuesta = Cliente.enviarNombre(nombre.getText(), tipo);
                dispose();
                new Resultado(respuesta);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        Registrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                Registrar.setBackground(new Color(0, 60, 201));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                Registrar.setBackground(new Color(0, 81, 132));
            }
        });
        cerrarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                cerrarButton.setBackground(new Color(229,85,87));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cerrarButton.setBackground(new Color(226,115,118));
            }
        });
        cerrarButton.addActionListener(e -> dispose());
    }
}
