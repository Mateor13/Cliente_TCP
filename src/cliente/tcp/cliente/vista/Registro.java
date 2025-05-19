package cliente.tcp.cliente.vista;

import cliente.tcp.cliente.clase.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro extends JFrame{
    private JPanel Registro;
    private JTextField nombre;
    private JRadioButton ingreso;
    private JButton Registrar;
    private JRadioButton salidaAlmuerzo;
    private JRadioButton retornoAlmuerzo;
    private JRadioButton salida;
    private JLabel Resultado;

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
        String nombreTxt = nombre.getText();

        Registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombre.getText().isEmpty()){
                    Resultado.setText("No ha ingresado un nombre");
                }else {
                    if (ingreso.isSelected()) {
                        try {
                            Cliente.enviarNombre(nombreTxt, "Ingreso");
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (salidaAlmuerzo.isSelected()) {
                        try {
                            Cliente.enviarNombre(nombreTxt, "Almuerzo");
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (retornoAlmuerzo.isSelected()) {
                        try {
                            Cliente.enviarNombre(nombreTxt, "Regreso");
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    } else if (salida.isSelected()) {
                        try {
                            Cliente.enviarNombre(nombreTxt, "Salida");
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                    } else {
                        Resultado.setText("No se ha seleccionado el registro");
                    }
                }
            }
        });
    }
}
