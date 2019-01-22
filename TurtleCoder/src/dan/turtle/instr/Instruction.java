package dan.turtle.instr;

public class Instruction {
	
	protected InstructionType type;
	
	public Instruction(InstructionType type) {
		this.type = type;
	}
	
	public InstructionType getInstructionType() {
		return type;
	}

}
