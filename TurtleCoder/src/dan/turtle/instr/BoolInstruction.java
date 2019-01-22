package dan.turtle.instr;

public class BoolInstruction extends Instruction{
	
	private boolean arg;
	
	public BoolInstruction(InstructionType type, boolean arg) {
		super(type);
		this.arg = arg;
	}

}
