package dan.turtle.common;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	private static String TITLE = "Turtle Coder V0.1";
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	
	public Main() {
		// Sets options for the window
		setSize(WIDTH, HEIGHT);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		// Adds the canvas object to the screen
		add(new TurtleCanvas(WIDTH, HEIGHT));
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
