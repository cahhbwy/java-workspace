

import java.awt.*;

public class Bulldog extends Critter{
	int hungry;
	
	public Bulldog(){
		hungry=5;
	}
	
	public boolean eat() {
		if(hungry>0){
			hungry--;
			return true;
		}
		else
			return false;
	}

	public Attack fight(String opponent) {
		if(opponent.equals("C"))
			return Attack.ROAR;
		else
			switch(((int)(Math.random()*3))%3){
			case 0:return Attack.POUNCE;
			case 1:return Attack.ROAR;
			default:return Attack.SCRATCH;
			}
	}

	public Color getColor() {
		if(hungry>0)
			return Color.GRAY;
		return Color.BLUE;
	}

	public Direction getMove() {
		switch(((int)(Math.random()*4))%4){
		case 0:return Direction.SOUTH;
		case 1:return Direction.NORTH;
		case 2:return Direction.EAST;
		case 3:return Direction.WEST;
		default:return Direction.CENTER;
		}
	}

	public String toString() {
		return "B"+hungry;
	}
	
	// called when you win a fight against another animal
	public void win() {
		hungry=5;
	}

	// called when you lose a fight against another animal, and die
	public void lose() {
		setAlive(false);
	}

	// called when your animal is put to sleep for eating too much food
	public void sleep() {
		setAwake(false);
	}

	// called when your animal wakes up from sleeping
	public void wakeup() {
		setAwake(true);
	}

	// called when the game world is reset
	public void reset() {
		hungry=5;
	}
	
	// called when your critter mates with another critter
	public void mate() {
		hungry=0;
	}
	
	// called when your critter is done mating with another critter
	public void mateEnd() {
		hungry=5;
	}
}
