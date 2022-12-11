package Components;

import java.awt.*;
import javax.swing.*;

public class DrawField extends JPanel {

  public void printDrawing(int failCounter) {
    Graphics g = getGraphics();
    ((Graphics2D) g).setStroke(new BasicStroke(5));
    g.setColor(Color.BLACK);

    for (int i = 0; i < failCounter; i++) {
      workers[i].draw(300, g);
    }
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
