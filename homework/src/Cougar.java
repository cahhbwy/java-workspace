

import java.awt.Color;

public class Cougar extends Critter {

	boolean fought;
	boolean west;
	
	public Cougar() {
		fought = false;
		west = true;
	}
	
	public boolean eat() {
		west = !west;
		return true;
	}

	// need to override
	public Color getColor() {
		if (fought) {
			return Color.RED;	
		} else {
			return Color.blue;
		}
		
	}
	
	// need to override
	public Direction getMove() {
		if (west) {
			return Direction.WEST;
		} else {
			return Direction.EAST;
		}
	}
	
	public Attack fight(String opponent) {
		fought = true;
		return Attack.POUNCE;
	}
	
	public String toString() {
		return "C";
	}
}