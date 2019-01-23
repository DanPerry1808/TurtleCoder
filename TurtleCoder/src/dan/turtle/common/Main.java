package dan.turtle.common;

import java.awt.Dimension;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;

import dan.turtle.instr.FileParser;

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
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle(TITLE);
		// Adds the canvas object to the screen
		TurtleCanvas canvas = new TurtleCanvas(WIDTH, HEIGHT, filename);
		add(canvas);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("--Welcome to TurtleCoder--");
		System.out.println();
		printHelp();
		
		// Continually checks user input until they choose to quit
		sc = new Scanner(System.in);
		String input = "";
		while(input != "Q") {
			input = sc.nextLine();
			// Checks which command they entered
			switch(input.charAt(0)) {
			case 'R':
				// Checks file exists before trying to load it
				String filename = input.split(" ")[1];
				File f = new File("./instr/" + filename + ".trtl");
				if(f.exists()) {
					new Main(filename);
				}else {
					System.out.println("ERROR: " + filename + ".trtl does not exist!");
				}
				break;
			case 'L':
				printFiles();
				break;
			case 'H':
				printHelp();
				break;
			case 'Q':
				break;
			default:
				System.out.println("Invalid command, type H to display command list");
				break;
			}
		}
		sc.close();
	}
	
	// Prints the names of all files in the /instr/ folder
	private static void printFiles() {
		File[] files = new File("./instr/").listFiles();
		
		// Checks if folder doesn't exit and outputs error message if true
		if(files == null) {
			System.out.println("You seem to have deleted your /instr/ folder.");
		}else {
			// Checks number of files in folder
			if(files.length == 0) {
				System.out.println("WARNING: No .trtl files to display.\nMake sure they are in the /instr folder.");
			}else {
				for (File file : files) {
				    if (file.isFile()) {
				        System.out.println(file.getName());
				    }
				}
			}
		}
	}
	
	// Prints all possible commands
	private static void printHelp() {
		System.out.println();
		System.out.println("Please select one of the following options: ");
		System.out.println("R ... - Run the file with the given name");
		System.out.println("L - List all files in the directory");
		System.out.println("H - Reprint this help text");
		System.out.println("Q - Quit the program");
		System.out.println("");
	}

}
