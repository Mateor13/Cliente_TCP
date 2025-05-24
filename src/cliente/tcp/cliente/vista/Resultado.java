package cliente.tcp.cliente.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Resultado extends JFrame{
    private JButton regresarButton;
    private JPanel Resultado;
    private JLabel Nombre;
    private JLabel Entrada;
    private JLabel almuerzo;
    private JLabel regreso;
    private JLabel salida;
    private JLabel ID;

    public Resultado(String resultado) {
        setTitle("Registro Horario");
        setContentPane(Resultado);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 500));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        String[] partes = resultado.split(",");
        ID.setText(partes[0].split(":", 2)[1].trim());
        Nombre.setText(partes[1].split(":", 2)[1].trim());
        Entrada.setText(partes[2].split(":", 2)[1].trim());
        almuerzo.setText(partes[3].split(":", 2)[1].trim());
        regreso.setText(partes[4].split(":", 2)[1].trim());
        salida.setText(partes[5].split(":", 2)[1].trim());
        regresarButton.addActionListener(e -> {
            dispose();
            new Registro();
        });
        regresarButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                regresarButton.setBackground(new Color(0, 60, 201));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                regresarButton.setBackground(new Color(0, 81, 132));
            }
        });
    }
}
