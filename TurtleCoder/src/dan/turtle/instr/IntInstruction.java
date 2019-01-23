package dan.turtle.instr;

public class IntInstruction extends Instruction {
	
	private int arg;

	public IntInstruction(InstructionType type, int arg) {
		super(type);
		this.arg = arg;
	}
	
	public int getArg() {
		return arg;
	}
	
	public String toString() {
		return "Instruction with 1 integer parameter:\nTYPE: " + type.toString() + "\nArgument: " + arg;
	}

}
