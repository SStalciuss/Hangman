package Components;

import Interfaces.Worker;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawField extends JPanel {

  private JPanel drawing = new JPanel();
  private JPanel sideLeft = new JPanel();
  private JPanel sideRight = new JPanel();
  private int innerCounter = 0;

  public DrawField() {
    this.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.weighty = constraints.weightx = 1;

    this.add(sideLeft, constraints);
    this.add(drawing, constraints);
    this.add(sideRight, constraints);

    drawing.addComponentListener(
      new ComponentAdapter() {
        public void componentResized(ComponentEvent event) {
          printDrawing(innerCounter);
        }
      }
    );
  }

  public void printDrawing(int failCounter) {
    innerCounter = failCounter;
    int height = drawing.getHeight();
    int width = drawing.getWidth();
    int size = height > width ? width : height;
    Graphics g = drawing.getGraphics();
    ((Graphics2D) g).setStroke(new BasicStroke(5));
    g.setColor(Color.BLACK);
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
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawHorizontal(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawVertical(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawHead(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawBody(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawRightHand(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawLeftHand(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawRightLeg(size, g);
      }
    },
    new Worker() {
      public void draw(int size, Graphics g) {
        DrawFunctions.drawLeftLeg(size, g);
      }
    },
  };
}
