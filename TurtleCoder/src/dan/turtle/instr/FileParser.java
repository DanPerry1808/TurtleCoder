package dan.turtle.instr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
			instr[i] = validInstruction(lines.get(i));
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
			JOptionPane.showMessageDialog(null, "Could not locate " + filepath);
			e.printStackTrace();
			System.exit(0);
		}
		
		return lines;
		
	}
	
	// Checking if a command is valid
	private static Instruction validInstruction(String line) {
		// Splitting command into separate parts
		String[] lineParts = line.split(" ");
		
		// Check command word
		if(validCommand(lineParts[0])) {
			
			// Check number of parameters
			InstructionType type = InstructionType.valueOf(lineParts[0]);
			int numParams = InstructionType.getNumParams(type);
			if(lineParts.length - 1 == numParams) {
				
				// Check type of parameter
				Object[] params = new Object[numParams];
				ParameterType pType;
				for(int i = 1; i < lineParts.length; i++) {
					pType = ParameterType.getParameterType(type, i);
					switch(pType) {
					case INT:
						if(validInt(lineParts[i])){
							params[i - 1] = Integer.parseInt(lineParts[i]);
						}else {
							errorClose("Invalid integer parameter: " + lineParts[i], line);
						}
						break;
					case BOOL:
						if(validBool(lineParts[i])) {
							// Adds current parameter to the list of parameters
							params[i-1] = Boolean.parseBoolean(lineParts[i]);
						}else {
							errorClose("Invalid boolean parameter: " + lineParts[i], line);
						}
						break;
					}
				}
				
				// Once all parameters processed, create the instruction
				return new Instruction(type, params);
				
			}else {
				errorClose("Wrong number of parameters for " + lineParts[0], line);
				return null;
			}
		}else {
			errorClose("Unrecognised command " + lineParts[0], line);
			return null;
		}
	}
	
	private static boolean validCommand(String command) {
		int i = 0;
		while(i < InstructionType.values().length) {
			if(InstructionType.valueOf(command) == InstructionType.values()[i]) {
				return true;
			}
			i++;
		}
		return false;
	}
	
	// Checks if string is a valid integer
	private static boolean validInt(String linePart) {
		try {
			Integer.parseInt(linePart);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	// Displays error message to user, in two parts
	// Error description and line that caused error
	// Then closes the program
	private static void errorClose(String message, String line) {
		JOptionPane.showMessageDialog(null, message + "\nCannot parse: " + line);
		System.exit(0);
	}
	
	private static boolean validBool(String linePart) {
		if(linePart.contentEquals("true") || linePart.equals("false")) {
			return true;
		}else {
			return false;
		}
	}
	
}
