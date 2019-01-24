package dan.turtle.instr;

/**
 * Class for representing one instruction for the turtle to
 * carry out. Base class to be extended
 */
public class OldInstruction {
	
	protected InstructionType type;
	
	/**
	 * DO NOT create Instruction objects, create objects from
	 * classes which extend Instruction
	 * @param type The type of the instruction
	 */
	public OldInstruction(InstructionType type) {
		this.type = type;
	}
	
	/**
	 * @return The type of the instruction
	 */
	public InstructionType getInstructionType() {
		return type;
	}

}
