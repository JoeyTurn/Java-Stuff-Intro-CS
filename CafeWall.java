import java.awt.*;

public class CafeWall {
   public static void main(String[] args) {
      DrawingPanel panel = new DrawingPanel(600, 400);
      Graphics g = panel.getGraphics();
      g.setColor(Color.BLUE);
      g.fillRect(17, 45, 139, 241);
      g.drawOval(234, 77, 100, 100);
   }
}