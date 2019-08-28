package main;

import processing.core.PApplet;
import processing.serial.Serial;

public class Main extends PApplet{

	
	int pantalla = 1;
	boolean rectangulo1 = false;
	boolean rectangulo2 = false;
	boolean rectangulo3 = false;
	
	public static void main(String[] args) {
		PApplet.main("main.Main");
	}
	
	public void settings() {
		size(900,900);
	}
	
	public void setup() {
		
	}
	
	public void draw() {
		if(pantalla == 1) {
			background(255);
			fill(255,0,0);
			rectMode(CENTER);
			rect(width/2, height/2, 500, 100);
		}else if(pantalla == 2) {
			background(255,255,255);
			line(0, 300, width, 300);
			line(0, 600, width, 600);
			line(300,0, 300, height);
			line(600,0, 600, height);

			//RECT1
			rectMode(CORNER);
			fill(255,255,0);
			if(rectangulo1 == true) {
				rect(0,0,300,300);
			}
			if(rectangulo2 == true) {
				rect(300,0,300,300);
			}
			if(rectangulo3 == true) {
			rect(600,0,300,300);
			}
			
		}else if(pantalla == 3) {
			background(0,0,0);
		}
		
		
		
	}
	
	public void mousePressed() {
		if(pantalla == 1) {
			if(mouseX>200 && mouseX<700 && mouseY>400 && mouseY<500) {
				pantalla = 2;
			}
		}else if(pantalla == 2) {
			
			if(mouseX>0 && mouseX<300 && mouseY>0 && mouseY<300) {
				rectangulo1 = true;
			}
			
		}
		if(pantalla==4) {
			pantalla=1;
		}
		
	}

}
