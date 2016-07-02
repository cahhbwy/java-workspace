

import java.awt.*;

public class Ant extends Critter{

	boolean walkSouth;
	int step;
	
	public Ant(boolean walkSouth) {
		this.walkSouth=walkSouth;
		step=0;
	}
	
	public boolean eat() {
		return true;
	}

	// need to override
	public Color getColor() {
		return Color.RED;	
	}
	
	// need to override
	public Direction getMove() {
		if (walkSouth)
			if(step++%2==0)
				return Direction.SOUTH;
			else
				return Direction.EAST;
		else
			if(step++%2==0)
				return Direction.NORTH;
			else
				return Direction.EAST;
		
	}
	
	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
	
	public String toString() {
		return "%";
	}
}
