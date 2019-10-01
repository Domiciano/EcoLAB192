package main;

import processing.core.PApplet;

public class Main extends PApplet implements ComunicacionUDP.OnMensajeListener{
	
	
	public static void main(String[] args) {
		PApplet.main("main.Main");

	}
	
	
	
	ComunicacionUDP udp;
	
	public void settings() {
		size(500,500);
	}
	
	public void setup() {
		udp = new ComunicacionUDP();
		udp.setObserver(this);
		udp.start();
	}
	
	public void draw() {
		background(255);
		fill(0);	
	}

	@Override
	public void onMessage(String msg) {
		System.out.println(msg);		
	}

		

}
