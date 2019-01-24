package dan.turtle.common;

import java.awt.Dimension;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileSystemView;

public class Main extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// Compatibility version of the code
	// This number will be changed whenever the code is changed
	// in a way that invalidates old code
	public static int compatVers = 2;
	private static String TITLE = "Turtle Coder V0.1";
	public static int WIDTH = 800;
	public static int HEIGHT = 800;
	
	private static Scanner sc;
	
	public Main(String filename) {
		// Sets options for the window
		setSize(WIDTH, HEIGHT);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		// Adds the canvas object to the screen
		TurtleCanvas canvas = new TurtleCanvas(WIDTH, HEIGHT, filename);
		add(canvas);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FileSystemView fsv = FileSystemView.getFileSystemView();
		JFileChooser fc = new JFileChooser("./instr/", fsv);
		String filename = null;
		while(filename == null) {
			int output = fc.showOpenDialog(null);
			if(output == JFileChooser.APPROVE_OPTION) {
				filename = fc.getSelectedFile().getAbsolutePath();
			}
		}
		new Main(filename);

	}

}
