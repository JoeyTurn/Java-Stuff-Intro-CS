//Class comment in Husky.java

import java.awt.*;

public class Giant extends Critter {
      
    private int feeFieFoeInt = 0;
    private String feeFieFoeString;
    
    //Infect, hop if possible, turn right
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.RIGHT;
    }

    public Color getColor() {
        return Color.GRAY;
    }

    //Fee for 6 turns, Fie for 6 turns, Foe for 6 turns, on loop
    public String toString() {
      if (feeFieFoeInt <= 5)
         feeFieFoeString = "Fee";
      else if (feeFieFoeInt <= 11)
         feeFieFoeString = "Fie";
      else
         feeFieFoeString = "Foe";
         
      feeFieFoeInt++;
      
      if (feeFieFoeInt == 18)
         feeFieFoeInt = 0;
         
      return feeFieFoeString;
    }
}