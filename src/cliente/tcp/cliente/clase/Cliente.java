package cliente.tcp.cliente.clase;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    private static final int puerto = 5000;
    private static final String IP = "172.31.116.85";
    public static String enviarNombre(String nombre, String tipo) throws Exception {
        Socket cliente = new Socket(IP, puerto);
        InputStream in = cliente.getInputStream();
        OutputStream out = cliente.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);
        dos.writeUTF(nombre);
        dos.writeUTF(tipo);
        DataInputStream dis = new DataInputStream(in);
        String respuesta = dis.readUTF();
        cliente.close();
        dos.close();
        dis.close();
        return respuesta;
    }
}
