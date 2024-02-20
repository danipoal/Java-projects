package chatClienteServidor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        final int puerto = 12345; // Puerto en el que escucha el servidor

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Servidor iniciado. Esperando conexiones en el puerto " + puerto + "...");
            
            // Espera una conexión entrante
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado desde " + clienteSocket.getInetAddress() + ":" + clienteSocket.getPort());

            // Lee los datos enviados por el cliente
            BufferedReader entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String mensajeCliente;
            while ((mensajeCliente = entrada.readLine()) != null) {
                System.out.println("Mensaje recibido: " + mensajeCliente);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
