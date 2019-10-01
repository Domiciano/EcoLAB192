package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ComunicacionUDP extends Thread{
	DatagramSocket socket;
	InetAddress cliente;
	
	@Override
	public void run() {
		try {
			socket = new DatagramSocket(5000);
			cliente = InetAddress.getByName("172.30.76.135");
			
			while(true) {
				byte[] buff = new byte[200];
				DatagramPacket packet = new DatagramPacket(buff, buff.length);
				socket.receive(packet);
				String mensaje = new String(packet.getData()).trim();
				observer.onMessage(mensaje);
			}
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarMensaje(String mensaje) {
		new Thread(
				()->{
					try {
						DatagramPacket packet = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, cliente, 5000);
						socket.send(packet);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				).start();
	}
	
	
	public interface OnMensajeListener{
		public void onMessage(String msg);
	}
	
	OnMensajeListener observer;
	
	public void setObserver(OnMensajeListener observer) {
		this.observer = observer;
	}
	
	
	
	
}
