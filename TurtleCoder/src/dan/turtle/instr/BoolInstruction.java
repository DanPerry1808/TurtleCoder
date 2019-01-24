package dan.turtle.instr;

/**
 * Instruction with one boolean parameter
 *
 */
public class BoolInstruction extends OldInstruction{
	
	private boolean arg;
	
	/**
	 * Instruction with 1 boolean parameter
	 * @param type The type of instruction
	 * @param arg The parameter of the instruction
	 */
	public BoolInstruction(InstructionType type, boolean arg) {
		super(type);
		this.arg = arg;
	}
	
	/**
	 * @return Returns a boolean which is the parameter for the instruction
	 */
	public boolean getArg() {
		return arg;
	}
	
	public String toString() {
		return "Instruction with 1 boolean parameter:\nTYPE: " + type.toString() + "\nArgument: " + arg;
	}

}
