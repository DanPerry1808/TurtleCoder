package dan.turtle.instr;

public enum ParameterType {
	INT,
	BOOL;
	
	public static ParameterType getParameterType(InstructionType type, int index) {
		switch(type) {
		case TPEN:
			return BOOL;
		default:
			return INT;
		}
	}
	
}
