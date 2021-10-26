import java.awt.*;
import java.util.*;

public class BottomFeeder extends Critter {
   Random r = new Random();
   private int rint;
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER) {
            return Action.INFECT;
        } else if (info.leftThreat() == true) {
             return Action.LEFT;
        } else if (info.rightThreat() == true) {
             return Action.RIGHT;
        } else if (info.getDirection() == Direction.NORTH && info.getBehind() == Neighbor.Wall && info.getRight() != Neighbor.WALL) {
             return Action.RIGHT;
        } else if (info.getDirection() == Direction.WEST && info.getLeft() == Neighbor.Wall && info.getBack() != Neighbor.WALL) {
             return Action.RIGHT;
        } else if ((info.getDirection() == Direction.WEST && info.getFront() != Neighbor.SAME && info.getFront() != Neighbor.WALL)) {
            return Action.LEFT;
        } else if ((info.getDirection() == Direction.NORTH && info.getFront() != Neighbor.SAME && info.getFront() != Neighbor.WALL)) {
            return Action.RIGHT;
        } else if ((info.getDirection() == Direction.SOUTH || info.getDirection() == Direction.EAST) 
                     && info.getFront() != Neighbor.WALL) {
            return Action.HOP;
        } else if (info.getRight() == Neighbor.SAME && info.getLeft() == Neighbor.SAME) {
             return Action.INFECT;
        } else if (info.getDirection() == Direction.SOUTH) {
             return Action.RIGHT;
        } else if (info.getDirection() == Direction.SOUTH) {
             return Action.LEFT;
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
        return Color.GREEN;
    }

    public String toString() {
        return "E";
    }
}