package dan.turtle.common;

public enum Direction {
	UP,
	LEFT,
	DOWN,
	RIGHT;
	
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
