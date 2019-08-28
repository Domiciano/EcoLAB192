package main;

import processing.core.PApplet;
import processing.serial.Serial;

public class Main extends PApplet{

	Serial puerto;
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
		
	}
	
	public void setup() {
		printArray(Serial.list());
		puerto = new Serial(this,Serial.list()[0], 9600);
		puerto.bufferUntil('\n');
	}
	
	public void settings() {
		size(500,500);
	}
	
	public void draw() {
		background(0);
	}
	
	public void mousePressed() {
		puerto.write("Hola desde processing\n");
	}
	
	public void serialEvent(Serial p) { 
		  String inString = p.readStringUntil('\n');
		  System.out.println(inString);
	}

}
