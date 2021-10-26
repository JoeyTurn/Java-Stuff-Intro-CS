/**  Joey Turnbull
  *  03/07/2020
  *  CSE142
  *  TA: Esther Chien
  *  Assignment #8
  *  
  *  These subclasses (Bear, Lion, Giant, and Husky) are all extentions of the Critter Class
  *  
  *  Note: All Critters first "movement" is to infect, then followed by the listed actions
  *
  *  Bear:
  *   -Color: White (polar) or Black (bipolar)(jk just !polar)
  *   -String: Alternating / and \ characters
  *   -Movement: Hop if space in front empty, turn left
  *
  *  Lion:
  *   -Color: RGB (randomly chosen, switches every 3 turns)
  *   -String: L
  *   -Movement: Turn left if wall front or right, turn right if Lion in front, hop
  *
  *
  *  Giant:
  *   -Color:Grey (spelled correctly)
  *   -String: Fee for 6 turns, then Fie for 6 turns, then Foe for 6 turns; on loop
  *   -Movement: Hop if possible, turn right
  *
  *  Husky:
  *   -Attrubutes: Boundless (assuming someone cloned me), has innate RNG to determing color/string
  *   -RNG: 0=common, 1=uncommon, 2=rare, 3=quite rare, 4=very rare, 5=very very rare, 6=1/8000
  *   -Color: Brown(0), Purple(1), Crimson(2), Mouth Red(3), Yellowish(4), White(5), Pure Gold(6)
  *   -String: D(0), UW(1), Bork(2), blep(3), Mr. Peanutbutter(4), hOI I'm temmie(5), *secret*(6)
  *   -Movement: Runs away if threat is near, turns towards prey if they are at the side,
  *              hops if empty space in front and the wall isn't to the left,
  *              turns left if wall is to the right, turns right
  *
  * These class files are used in the CritterMain program, which simulates what would happen
  * if these creatures (as programmed) are placed into a simulation
  *
  * Note: Husky should win 99% of the time on fair grounds*/

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   Random r = new Random();
   
   private int changeEmoji = 15;
   private int emojiInt;
   
   //gets a random int between 0 and 8000 which lasts for 15 turns to make random color/string
   //i wish this could be a part of randNumConditions, but it simply doesn't work:
   //the color and strings would change at two different times
   public int getRandomNum() {
      if (changeEmoji == 15) {
         changeEmoji = 0;
         return r.nextInt(8001);
      }
      return emojiInt;
   }
   
   
   //then turns the random int into a value between 0 and 6 to determine rarity of color/string
   public int randNumConditions() {
      if (emojiInt <= 6750)
         return 0; //common
      else if (emojiInt <= 7750)
         return 1; //uncommon
      else if (emojiInt <= 7950)
         return 2; //rare
      else if (emojiInt <= 7989)
         return 3; //quite rare
      else if (emojiInt <= 7996)
         return 4; //very rare
      else if (emojiInt <= 7999)
         return 5; //very very rare
      return 6; //1 in 8000
   }
   
   //Infect, runs away if threat is near, turns towards prey if they are at the side, hops if empty
   //space in front and the wall isn't to the left, turns left if wall is to the right, turns right
    public Action getMove(CritterInfo info) {
        if (info.getFront() == Neighbor.OTHER)
            return Action.INFECT;
        else if (info.leftThreat() == true || info.rightThreat() == true || info.backThreat() == 
                  true)
            return Action.HOP;
        else if (info.getRight() == Neighbor.OTHER)
            return Action.RIGHT;
        else if (info.getLeft() == Neighbor.OTHER)
            return Action.LEFT;
        else if (info.getFront() == Neighbor.EMPTY && info.getLeft() != Neighbor.WALL)
            return Action.HOP;
        else if (info.getRight() == Neighbor.WALL)
            return Action.LEFT;
        else
            return Action.RIGHT;
    }

   //Brown(0), Purple(1), Crimson(2), Mouth Red(3), Yellowish(4), White(5), Pure Gold(6)
    public Color getColor() {
      emojiInt = getRandomNum();
      if (randNumConditions() == 0)
         return new Color(210,105,30);
      else if (randNumConditions() == 1)
         return new Color(128,0,128);
      else if (randNumConditions() == 2)
         return new Color(220,20,60);
      else if (randNumConditions() == 3)
         return Color.RED;
      else if (randNumConditions() == 4)
         return new Color(255,255,50);
      else if (randNumConditions() == 5)
         return Color.WHITE;
      return new Color(218,165,32);
    }
   
   //D(0), UW(1), Bork(2), blep(3), Mr. Peanutbutter(4), hOI I'm temmie(5), *secret*(6)   
    public String toString() {
      emojiInt = getRandomNum();
      changeEmoji++;
      if (randNumConditions() == 0)
         return "D";
      else if (randNumConditions() == 1)
         return "UW";
      else if (randNumConditions() == 2)
         return "Bork";
      else if (randNumConditions() == 3)
         return "blep";
      else if (randNumConditions() == 4) 
         return "Mr. Peanutbutter";
      else if (randNumConditions() == 5)
         return "hOI I'm temmie"; //need moni 4 colleg
      return "U•w•U";
    }
}

/* this is another strategy I thought of, except it isn't very interesting

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
*/