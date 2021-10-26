//Class comment in Husky.java

import java.awt.*;
import java.util.*;

public class Lion extends Critter {
   
   Random r = new Random();
   
   private int changeColor = 3;
   private int colorInt;
   
   //Infect, turn left if wall front or right, turn right if Lion in front, hop
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
            return Action.LEFT;
        else if (info.getFront() == Neighbor.SAME)
            return Action.RIGHT;
        else
            return Action.HOP;
    }
   
   //RGB (randomly chosen, switches every 3 turns)
    public Color getColor() {
        if (changeColor == 3) {
            changeColor = 0;
            colorInt = r.nextInt(3);
        }
        changeColor++;
        if (colorInt == 0)
           return Color.RED;
        else if (colorInt == 1)
           return Color.GREEN;
        return Color.BLUE;
         
    }

    public String toString() {
        return "L";
    }
}