package dan.turtle.instr;

public class IntArrInstruction extends Instruction {

	private int[] args;
	
	public IntArrInstruction(InstructionType type, int[] args) {
		super(type);
		this.args = args;
	}
	
	public int[] getArgs() {
		return args;
	}
	
	public int getArg(int index) {
		return args[index];
	}
	
	public int getNumArgs() {
		return args.length;
	}

}
