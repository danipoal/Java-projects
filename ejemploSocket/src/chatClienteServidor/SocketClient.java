package chatClienteServidor;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        final String servidor = "localhost"; // Dirección IP o nombre de host del servidor
        final int puerto = 12345; // Puerto en el que escucha el servidor

        try (Socket socket = new Socket(servidor, puerto)) {
            System.out.println("Conectado al servidor en " + servidor + ":" + puerto);

            // Flujo de salida para enviar datos al servidor
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter salida = new PrintWriter(outputStream, true);

            // Enviar mensaje al servidor
            salida.println("Hola, servidor!");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
