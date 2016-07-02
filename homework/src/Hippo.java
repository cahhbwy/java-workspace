

import java.awt.*;

public class Hippo extends Critter{
	int hungry;
	int step;
	Direction dir;
	public Hippo(int hungry) {
		this.hungry=hungry;
		step=0;
	}
	
	public boolean eat() {
		if(hungry>0){
			hungry--;
			return true;
		}
		else
			return false;
	}

	public Color getColor() {
		if(hungry>0)
			return Color.gray;
		else
			return Color.white;
	}
	
	public Direction getMove() {
		if(step%5==0)	
			switch(((int)(Math.random()*4))%4){
			case 0:dir=Direction.NORTH;break;
			case 1:dir=Direction.EAST;break;
			case 2:dir=Direction.WEST;break;
			default:dir=Direction.SOUTH;break;
			}
		step++;
		return dir;
	}
	
	public Attack fight(String opponent) {
		if(hungry>0)
			return Attack.SCRATCH;
		else
			return Attack.POUNCE;
	}
	
	public String toString() {
		return ""+hungry;
	}
}
