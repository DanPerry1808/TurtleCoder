package dan.turtle.instr;

/**
 * Enum for a type of instruction
 * Each accepted command in .trtl files has an equivalent entry here
 */
public enum InstructionType {
	MOVE,
	TURN,
	SPED,
	TPEN,
	VERS,
	MVTO;
	
	/**
	 * @param type The type on instruction you want the number of parameters of
	 * @return The number of parameters that instruction has
	 */
	public static int getNumParams(InstructionType type) {
		switch(type) {
		case MVTO:
			return 2;
		default:
			return 1;
		}
	}
	
}
