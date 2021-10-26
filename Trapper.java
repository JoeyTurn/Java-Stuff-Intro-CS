import java.awt.*;
import java.util.*;

public class Trapper extends Critter {
   Random r = new Random();
   private int rint;
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.leftThreat() == true) {
             return Action.LEFT;
        } else if (info.rightThreat() == true) {
             return Action.RIGHT;
        } else if (info.getRight() == Neighbor.SAME && info.getLeft() == Neighbor.SAME) {
             return Action.INFECT;
        } else if (info.getRight() == Neighbor.SAME) {
             return Action.LEFT;
        } else if (info.getLeft() == Neighbor.SAME) {
             return Action.RIGHT;
        } else if (info.getBack() == Neighbor.SAME) {
             rint = r.nextInt(2);
             if (rint == 0)
               return Action.LEFT;
             return Action.INFECT;
        } else {
            return Action.LEFT;
        }
    }

    public Color getColor() {
        return Color.BLACK;
    }

    public String toString() {
        return "_";
    }
}