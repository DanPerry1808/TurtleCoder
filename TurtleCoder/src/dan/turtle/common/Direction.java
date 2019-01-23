package dan.turtle.common;

/**
 * Enum represents the direction that the turtle is facing
 */
public enum Direction {
	UP,
	LEFT,
	DOWN,
	RIGHT;
	
	/**
	 * Given the Direction d, returns the direction 90 degrees clockwise of it 
	 * @param d a Direction enum
	 * @return the Direction 90 clockwise of it
	 */
	public static Direction clockwise(Direction d) {
		switch(d) {
		case UP:
			return LEFT;
		case LEFT:
			return DOWN;
		case DOWN:
			return RIGHT;
		case RIGHT:
			return UP;
		default:
			return null;
		}
	}
	
	/**
	 * Given the Direction d, returns the direction 90 degrees anticlockwise of it 
	 * @param d a Direction enum
	 * @return the Direction 90 anticlockwise of it
	 */
	public static Direction anticlockwise(Direction d) {
		switch(d) {
		case UP:
			return RIGHT;
		case LEFT:
			return UP;
		case DOWN:
			return LEFT;
		case RIGHT:
			return DOWN;
		default:
			return null;
		}
	}
}
