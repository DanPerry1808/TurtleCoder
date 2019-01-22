package dan.turtle.instr;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileParser {
	
	public FileParser() {
	}
	
	public Instruction[] parseInstructions(String filepath) {
		ArrayList<String> lines = readInstructions(filepath);
		Instruction[] instr = new Instruction[lines.size()];
		
		for(int i = 0; i < instr.length; i++) {
			instr[i] = parseLine(lines.get(i));
			System.out.println(instr[i].toString());
		}
		
		return instr;
		
	}
	
	private ArrayList<String> readInstructions(String filepath) {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader file = new BufferedReader(new FileReader(filepath));
			try {
				String line;
				while((line = file.readLine()) != null) {
					lines.add(line);
					System.out.println(line);
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
	
	private Instruction parseLine(String line) {
		String[] lineParts = line.split(" ");
		
		// Checks through all possible instruction types
		switch(lineParts[0]) {
		case "MOVF":
			return new IntInstruction(InstructionType.MOVE, Integer.parseInt(lineParts[1]));
		case "TURN":
			return new IntInstruction(InstructionType.TURN, Integer.parseInt(lineParts[1]));
		default:
			System.out.println("Error parsing line: " + line);
			return null;
		}
	}

}
