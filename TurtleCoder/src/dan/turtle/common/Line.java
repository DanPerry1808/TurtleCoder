package dan.turtle.common;

import java.awt.Color;
import java.awt.Graphics;

public class Line {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color colour;
	
	public Line(int x1, int y1, int x2, int y2, Color colour) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.colour = colour;
	}
	
	/**
	 * Draws the line to the screen
	 * @param g The Graphics objet being used to draw with
	 */
	public void draw(Graphics g) {
		g.setColor(colour);
		g.drawLine(x1, y1, x2, y2);
	}

}
