package dan.turtle.instr;

public class Instruction {
	
	private InstructionType type;
	private Object[] params;
	
	/**
	 * Instruction represents one command from a .trtl code file
	 * @param type The InstructionType of the command
	 * @param params The parameters of the command
	 */
	public Instruction(InstructionType type, Object[] params) {
		this.type = type;
		this.params = params;
	}
	
	/**
	 * @return The InstructionType enum of the instruction
	 */
	public InstructionType getInstructionType() {
		return type;
	}
	
	/**
	 * @return The entire list of parameters for the instruction
	 */
	public Object[] getParams() {
		return params;
	}
	
	/**
	 * @param index The index of the wanted parameter
	 * @return A given parameter from the instruction
	 */
	public Object getParam(int index) {
		return params[index];
	}
	
	/**
	 * @return The number of parameters the instruction has
	 */
	public int getNumParams() {
		return params.length;
	}
	
	public String toString() {
		String s = "Instruction\nType: " + type.toString() + "\nParameters";
		for(Object param : params) {
			s = s + param.toString() + "\n";
		}
		return s;
	}
}
