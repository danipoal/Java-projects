package chatClienteServidor;




import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		Thread thread = new Thread(mimarco);
		thread.start();
	}	
}

class MarcoServidor extends JFrame implements Runnable{
	
	private	JTextArea areaTexto;
	
	public MarcoServidor(){
		
		setBounds(1200,300,280,350);				
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		
		areaTexto=new JTextArea();
		milamina.add(areaTexto,BorderLayout.CENTER);
		add(milamina);
		
		setVisible(true);
		
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//Abrimos un socket de servidor para que lleguen los paquetes en el puerto indicado
		try {
			ServerSocket servidor = new ServerSocket(12345);
			
			Socket miSocket = servidor.accept();
			
			//Ahora hay que crear un flujo de entrada que pase por estos sockets
			DataInputStream flujo_entrada = new DataInputStream(miSocket.getInputStream());
			String mensajeEntrada = flujo_entrada.readUTF();
			
			areaTexto.append("\n" + mensajeEntrada);
			miSocket.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
