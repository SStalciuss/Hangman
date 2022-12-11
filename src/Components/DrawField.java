package Components;

import java.awt.*;
import javax.swing.*;

public class DrawField extends JPanel {

  public void paint(Graphics g) {
    ((Graphics2D) g).setStroke(new BasicStroke(5));
    g.setColor(Color.BLACK);
  }

  Worker[] workers = new Worker[] {
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawBasic(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawStick(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawHorizontal(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawVertical(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawHead(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawBody(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawRightHand(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawLeftHand(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawRightLeg(x, g);
      }
    },
    new Worker() {
      public void draw(int x, Graphics g) {
        DrawFunctions.drawLeftLeg(x, g);
      }
    },
  };
}
