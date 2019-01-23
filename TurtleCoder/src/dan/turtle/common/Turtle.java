package dan.turtle.common;

import java.awt.Color;
import java.awt.Graphics;

import dan.turtle.instr.Instruction;
import dan.turtle.instr.IntInstruction;

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
	
	private Instruction[] program;
	private int currInstr;
	
	public Turtle(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 1;
		dir = Direction.RIGHT;
		busy = false;
		currInstr = -1;
	}
	
	public void update() {
		// Checks turtle has instructions
		if(program != null) {
			if(busy) {
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
			} else {
				if(currInstr == program.length - 1) {
					program = null;
				}else {
					currInstr++;
					runInstruction(program[currInstr]);
				}
			}
		}
	}
	
	private void runInstruction(Instruction in) {
		busy = true;
		switch(in.getInstructionType()) {
		case MOVE:
			move(((IntInstruction)in).getArg());
			break;
		case TURN:
			turn(((IntInstruction)in).getArg());
		}
	}
	
	public void setProgram(Instruction[] program) {
		this.program = program;
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	public void draw(Graphics g) {
		g.fillOval(x, y, WIDTH, WIDTH);
	}
	
	private void move(int amount) {
		distanceLeft = amount;
	}
	
	private void turn(int amount) {
		int turns = Math.abs(amount) / 90;
		
		// Checks if turning positive (clockwise) degrees
		if(amount > 0) {
			for(int i = 0; i < turns; i++) {
				dir = Direction.clockwise(dir);
			}
		}else {
			for(int i = 0; i < turns; i++) {
				dir = Direction.anticlockwise(dir);
			}
		}
		busy = false;
	}

}
