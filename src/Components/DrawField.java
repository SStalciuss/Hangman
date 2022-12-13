package Components;

import Interfaces.Worker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawField extends JPanel {

  private JPanel drawing = new JPanel();
  private int xOffset;
  private int yOffset;
  private int size;

  public DrawField() {
    this.add(drawing);

    this.setBorder(BorderFactory.createLineBorder(Color.green, 3));
    drawing.setBorder(BorderFactory.createLineBorder(Color.RED, 3));

    this.addComponentListener(
        new ComponentAdapter() {
          public void componentResized(ComponentEvent event) {
            int height = event.getComponent().getHeight();
            int width = event.getComponent().getWidth();
            if (height > width) {
              yOffset = (height - width) / 2;
              xOffset = 0;
              size = width;
            } else {
              xOffset = (width - height) / 2;
              yOffset = 0;
              size = height;
            }
            drawing.setBounds(xOffset, yOffset, size, size);
          }
        }
      );
  }

  public void printDrawing(int failCounter) {
    Graphics g = drawing.getGraphics();
    ((Graphics2D) g).setStroke(new BasicStroke(5));
    g.setColor(Color.BLACK);
    System.out.println("x" + xOffset);
    System.out.println("y" + yOffset);
    for (int i = 0; i < failCounter; i++) {
      workers[i].draw(size, g);
    }
  }

  Worker[] workers = new Worker[] {
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawBasic(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawStick(size, g);
      }
    },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawHorizontal(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawVertical(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawHead(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawBody(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawRightHand(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawLeftHand(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawRightLeg(size, x, y, g);
    //   }
    // },
    // new Worker() {
    //   public void draw(int size, int x, int y, Graphics g) {
    //     DrawFunctions.drawLeftLeg(size, x, y, g);
    //   }
    // },
  };
}
