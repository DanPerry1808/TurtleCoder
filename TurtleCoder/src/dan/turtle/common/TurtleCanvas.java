package dan.turtle.common;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dan.turtle.instr.FileParser;
import dan.turtle.instr.Instruction;

public class TurtleCanvas extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 1L;
	
	private int width;
	private int height;
	
	private Thread thread;
	private boolean running;
	
	private BufferStrategy bs;
	
	private Turtle turtle;
	
	private Instruction[] program;
	
	/**
	 * Main canvas object for drawing
	 * @param width Width of canvas in pixels
	 * @param height Height of canvas in pixels
	 */
	public TurtleCanvas(int width, int height) {
		this.width = width;
		this.height = height;
		
		running = false;
		turtle = new Turtle(100, 100);
		
		// Creates an array of Instruction objects from the commands in the
		// test file
		program = FileParser.parseInstructions("instr/test.trtl");
		turtle.setProgram(program);
		
		start();
	}
	
	// Starts the program thread
	private void start() {
		running = true;
		thread = new Thread(this, "TurtleCoder");
		thread.start();
	}
	
	// Stops the program thread
	private void stop() {
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Main logic loop for the program, runs updates 60 times a second
	 */
	public void run() {
		// Timing variables for updating
		long lastTime = System.nanoTime();
		final double UPS = 60.0;
		final double UPDATE_TIME = 1000000000.0 / UPS;
		double delta = 0;
		
		// Main logic loop
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / UPDATE_TIME;
			lastTime = now;
			
			// Checks if time for update
			while(delta >= 1) {
				turtle.update();
				delta--;
			}
			
			// Checks if canvas ready to draw yet
			while(!isDisplayable()) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// Calling main draw function
			render();
			
		}
		stop();
	}
	
	// Main drawing function
	private void render() {
		
		// Generating buffer strategy and graphics object
		bs = getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		// Clearing screen
		g.clearRect(0, 0, width, height);
		
		// DRAWING STARTS HERE
		
		turtle.draw(g);
		
		// DRAWING ENDS HERE
		
		g.dispose();
		bs.show();
	}

}
