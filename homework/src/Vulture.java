

import java.awt.*;

public class Vulture extends Bird{
	boolean hungry;
	
	public Vulture() {
		hungry=true;
	}
	
	public boolean eat() {
		if(hungry){
			hungry=false;
			return true;
		}
		return hungry;
	}

	public Color getColor() {
		return Color.black;
	}
	
	public Attack fight(String opponent) {
		hungry=true;
		if(opponent.equals("%"))
			return Attack.ROAR;
		else
			return Attack.POUNCE;
	}
}
