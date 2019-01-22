package dan.turtle.common;

import java.awt.Color;
import java.awt.Graphics;

public class Turtle {
	
	// Radius of the turtle on the screen
	private final int WIDTH = 10;
	
	private int x;
	private int y;
	
	// Pixels per update the turtle travels
	private int speed;
	
	// Distance left for the turtle to travel
	private int distanceLeft;
	
	// Whether the turtle is current executing an instruction
	private boolean busy;
	
	private boolean pen = false;
	private Color color = Color.RED;
	
	private Direction dir;
	
	public Turtle(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 1;
		dir = Direction.RIGHT;
		busy = false;
	}
	
	public void update() {
		if(distanceLeft != 0) {
			switch(dir) {
			case LEFT:
				x -= speed;
				break;
			case RIGHT:
				x += speed;
				break;
			case UP:
				y -= speed;
				break;
			case DOWN:
				y += speed;
			}
			distanceLeft -= speed;
			if(distanceLeft == 0) {
				busy = false;
			}
		}
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	public void draw(Graphics g) {
		g.fillOval(x, y, WIDTH, WIDTH);
	}
	
	public void move(int amount) {
		distanceLeft = amount;
	}

}
