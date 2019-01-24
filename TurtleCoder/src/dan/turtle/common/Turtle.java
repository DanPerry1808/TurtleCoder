package dan.turtle.common;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import dan.turtle.instr.BoolInstruction;
import dan.turtle.instr.Instruction;
import dan.turtle.instr.InstructionType;
import dan.turtle.instr.IntArrInstruction;
import dan.turtle.instr.IntInstruction;

/**
 * Class for representing the turtle itself
 */
public class Turtle {
	
	// Radius of the turtle on the screen
	private final int WIDTH = 10;
	
	// x and y coords on the screen
	private int x;
	private int y;
	
	// The coordinates of the turtle at the last place it ended an instruction
	private int lastX;
	private int lastY;
	
	// List of all lines that the turtle has drawn
	private ArrayList<int[]> lines;
	
	// Pixels per update the turtle travels
	private int speed;
	
	// Distance left for the turtle to travel
	private int distanceLeft;
	
	// Whether the turtle is current executing an instruction
	private boolean busy;
	
	// Whether the turtle is drawing a line behind it as it moves
	private boolean penDown;
	// Colour of the pen
	private Color colour;
	
	// Direction the turtle is facing
	private Direction dir;
	
	// Array of instructions it is currently executing
	private Instruction[] program;
	// Index of the above array of the instruction it is currently executing
	private int currInstr;
	
	/**
	 * Object that represents a turtle on the screen
	 * @param x Starting x coordinate on the canvas
	 * @param y Starting y coordinate on the canvas
	 */
	public Turtle(int x, int y) {
		this.x = x;
		this.y = y;
		lastX = x;
		lastY = y;
		lines = new ArrayList<int[]>();
		
		speed = 1;
		dir = Direction.RIGHT;
		penDown = true;
		colour = Color.RED;
		busy = false;
		currInstr = -1;
	}
	
	/**
	 * Runs 60 times a second, moves the turtle and runs next instruction
	 */
	public void update() {
		// Checks turtle has instructions before trying to run them
		if(program != null) {
			
			if(busy) {
				// If turtle is still executing a move instruction, keep moving at speed
				if(program[currInstr].getInstructionType() == InstructionType.MOVE) {
					if(distanceLeft >= speed) {
						move(speed);
					}else {
						move(distanceLeft);
					}
				}
			} else {
				// Checking if reached end of instruction list
				if(currInstr == program.length - 1) {
					program = null;
				}else {
					currInstr++;
					runInstruction(program[currInstr]);
				}
			}
		}
	}
	
	/**
	 * Moves the turtle the specified amount of pixels in the direction it is currently facing
	 * @param amount The number of pixels to move it
	 */
	private void move(int amount) {
		switch(dir) {
		case LEFT:
			x -= amount;
			break;
		case RIGHT:
			x += amount;
			break;
		case UP:
			y -= amount;
			break;
		case DOWN:
			y += amount;
		}
		
		// Deducts the amount moved from the distance the turtle has left to move
		distanceLeft -= amount;
		
		// Checks if movement completed
		if(distanceLeft == 0) {
			moveDone();
		}
	}
	
	private void moveDone() {
		busy = false;
		// If pen is down, save the line to be drawn
		if(penDown) {
			lines.add(new int[] {lastX, lastY, x, y});
		}
		lastX = x;
		lastY = y;
	}
	
	// Makes the turtle execute the next instruction
	private void runInstruction(Instruction in) {
		// Makes turtle busy to make sure only 1 instruction is executed at a time
		busy = true;
		
		// Checks through each type of instruction, calling the appropriate method
		switch(in.getInstructionType()) {
		case MOVE:
			makeMove(((IntInstruction)in).getArg());
			break;
		case TURN:
			turn(((IntInstruction)in).getArg());
			break;
		case SPEED:
			setSpeed(((IntInstruction)in).getArg());
			break;
		case TPEN:
			setPenDown(((BoolInstruction)in).getArg());
			break;
		case VERSION:
			busy = false;
			break;
		case MOVETO:
			moveTo(((IntArrInstruction)in).getArgs());
			break;
		}
	}
	
	/**
	 * Sets the list of instructions the turtle should run.
	 * The turtle runs these instructions immediately
	 * @param program The list of instructions to run
	 */
	public void setProgram(Instruction[] program) {
		this.program = program;
	}
	
	/**
	 * Changes the turtle's speed to the given value
	 * @param newSpeed The new speed of the turtle in pixels per update
	 */
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
		busy = false;
	}
	
	/**
	 * Draws the turtle on screen at its current position
	 * @param g Graphics object to use for drawing
	 */
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval(x, y, WIDTH, WIDTH);
		g.setColor(colour);
		for(int[] line : lines) {
			g.drawLine(line[0], line[1], line[2], line[3]);
		}
		if(penDown) {
			g.drawLine(lastX, lastY, x, y);
		}
	}
	
	private void moveTo(int[] coords) {
		boolean temp = penDown;
		penDown = false;
		x = coords[0];
		y = coords[1];
		moveDone();
		penDown = temp;
	}
	
	// Gives the turtle a distance to travel in its current direction
	private void makeMove(int amount) {
		distanceLeft = amount;
	}
	
	// Sets penDown to the parameter
	private void setPenDown(boolean newPen) {
		penDown = newPen;
		busy = false;
	}
	
	// Turns the turtle the set amount of degrees
	// Note: this only works with multiple of 90
	private void turn(int amount) {
		// Finds the number of 90 degree turns the parameter is equivalent to
		int turns = Math.abs(amount) / 90;
		
		// Checks if turning positive (clockwise) degrees
		if(amount > 0) {
			// Turns clockwise 90 degrees until amount rotated is equal
			// to the parameter
			for(int i = 0; i < turns; i++) {
				dir = Direction.clockwise(dir);
			}
		}else {
			// Turns anticlockwise 90 degrees until amount rotated
			// is equal to the parameter
			for(int i = 0; i < turns; i++) {
				dir = Direction.anticlockwise(dir);
			}
		}
		busy = false;
	}

}
