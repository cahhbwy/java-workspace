
// author: YRY
// A class to represent a Snake critter. 
// Snakes move south in a growing zig zag motion.
// The design is to use the guard technique:
// First design a non event-driven version
// Then convert to an event-driven version
public class Snake extends Critter {
    private int cycleLength;   // # steps in curr. Horiz. cycle
    private int steps;         // # of cycle's steps already taken
    
    public Snake() {
        cycleLength = 1;
        steps = 0;
    }
    
    public Direction getMove() {
      if (steps < cycleLength) {
          steps++;
          if (cycleLength % 2 == 1) {
                return Direction.EAST;
            } else {
                return Direction.WEST;
            }
        } else {
           steps = 0;
           cycleLength ++;
           return Direction.SOUTH;
        }
    }
    
    public String toString() {
        return "S";
    }
    
	  
}