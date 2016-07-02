

import java.awt.Color;

public class Bird extends Critter{
	int step;
	
	public Bird() {
		step=0;
	}

	public Color getColor() {
		return Color.BLUE;	
	}

	public Direction getMove() {
		switch(step++/3%4){
		case 0:return Direction.NORTH;
		case 1:return Direction.EAST;
		case 2:return Direction.SOUTH;
		default:return Direction.WEST;
		}
	}
	
	public Attack fight(String opponent) {
		if(opponent.equals("%"))
			return Attack.ROAR;
		else
			return Attack.POUNCE;
	}
	
	public String toString() {
		switch((step-1)/3%4){
		case 0:return "^";
		case 1:return ">";
		case 2:return "V";
		default:return "<";
		}
	}
}
