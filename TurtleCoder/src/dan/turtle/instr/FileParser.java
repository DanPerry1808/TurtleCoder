package dan.turtle.instr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class of static methods for creating lists of executable
 * instruction objects from .trtl files
 *
 */
public class FileParser {
	
	/**
	 * Returns an array of Instruction object from the contents of a file
	 * @param filepath The path to the file to be read
	 * @return An array of Instruction objects which the turtle can run
	 */
	public static Instruction[] parseInstructions(String filepath) {
		// Gets the contents of the files as a list of strings
		ArrayList<String> lines = readInstructions(filepath);
		// Creates new array to store instructions
		Instruction[] instr = new Instruction[lines.size()];
		
		// Convert each String into an Instruction and store in arrays
		for(int i = 0; i < lines.size(); i++) {
			instr[i] = parseLine(lines.get(i));
		}
		
		return instr;
		
	}
	
	// Reads in a file and returns its contents as an ArrayList of Strings
	private static ArrayList<String> readInstructions(String filepath) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(filepath));
			try {
				String line;
				// Reads each line from the file and adds it to the ArrayList
				while((line = file.readLine()) != null) {
					if(!line.startsWith("#") && !line.trim().isEmpty()) {
						lines.add(line);
					}
				}
				
				file.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not locate " + filepath);
			e.printStackTrace();
		}
		
		return lines;
		
	}
	
	// Converts a string into an instruction
	private static Instruction parseLine(String line) {
		// Splits the line by spaces to get the different parts of the instruction
		String[] lineParts = line.split(" ");
		
		// Checks through all possible instruction types
		// lineParts[0] is the first part of the instruction
		// A 4 character instruction code
		switch(lineParts[0]) {
		case "MOVE":
			// Move forward command
			return new IntInstruction(InstructionType.MOVE, Integer.parseInt(lineParts[1]));
		case "TURN":
			// Turn command
			return new IntInstruction(InstructionType.TURN, Integer.parseInt(lineParts[1]));
		case "SPED":
			// Change speed command
			return new IntInstruction(InstructionType.SPEED, Integer.parseInt(lineParts[1]));
		case "TPEN":
			return new BoolInstruction(InstructionType.TPEN, Boolean.parseBoolean(lineParts[1]));
		case "VERS":
			return new IntInstruction(InstructionType.VERSION, Integer.parseInt(lineParts[1]));
		default:
			System.out.println("Error parsing line: " + line);
			return null;
		}
	}

}
