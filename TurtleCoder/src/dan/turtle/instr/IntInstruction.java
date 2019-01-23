package dan.turtle.instr;

/**
 * Instruction with 1 integer parameter
 * Eg. MOVF 10
 *
 */
public class IntInstruction extends Instruction {
	
	private int arg;

	/**
	 * Instruction with 1 integer parameter
	 * @param type The type of instruction
	 * @param arg The parameter of the instruction
	 */
	public IntInstruction(InstructionType type, int arg) {
		super(type);
		this.arg = arg;
	}
	
	/**
	 * @return Returns an integer which is the parameter for the instruction
	 */
	public int getArg() {
		return arg;
	}
	
	public String toString() {
		return "Instruction with 1 integer parameter:\nTYPE: " + type.toString() + "\nArgument: " + arg;
	}

}
