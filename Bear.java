//Class comment in Husky.java

import java.awt.*;

public class Bear extends Critter {
   private boolean polar;
   private String last = "\\";
   
   //setter of polar boolean
   public Bear(boolean polar) {
      this.polar = polar;
   }
   
   //Movement: Infect, hop if space in front empty, turn left
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if (info.getFront() == Neighbor.EMPTY)
            return Action.HOP;
        else
            return Action.LEFT;
    }

    //if bear is polar, they are white; if not, they are black
    public Color getColor() {
        if (polar)
            return Color.WHITE;
        return Color.BLACK;
    }

    //bear alternates between / and \ between moves
    public String toString() {
        if (last.equals("\\"))
            last = "/";
        else
            last = "\\";
        return last;
    }
}