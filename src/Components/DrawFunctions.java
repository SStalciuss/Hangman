package Components;

import java.awt.*;
import javax.swing.*;

public class DrawFunctions extends JPanel {

  public static void drawBasic(int size, Graphics g) {
    int x1 = (int) Math.round(0.2 * size);
    int y1 = (int) Math.round(0.9 * size);
    int x2 = (int) Math.round(0.8 * size);
    g.drawLine(x1, y1, x2, y1);
  }

  public static void drawStick(int size, Graphics g) {
    int x1 = (int) Math.round(0.5 * size);
    int y1 = (int) Math.round(0.1 * size);
    int y2 = (int) Math.round(0.9 * size);
    g.drawLine(x1, y1, x1, y2);
  }

  public static void drawHorizontal(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.1 * size + y);
    int x2 = (int) Math.round(0.5 * size - x);
    int y2 = (int) Math.round(0.1 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }

  public static void drawVertical(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.1 * size + y);
    int x2 = (int) Math.round(0.2 * size - x);
    int y2 = (int) Math.round(0.3 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }

  public static void drawHead(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.15 * size);
    int y1 = (int) Math.round(0.3 * size);
    int r = (int) Math.round(0.1 * size);
    g.drawOval(x1, y1, r, r);
  }

  public static void drawBody(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.4 * size + y);
    int x2 = (int) Math.round(0.2 * size - x);
    int y2 = (int) Math.round(0.6 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }

  public static void drawRightHand(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.45 * size + y);
    int x2 = (int) Math.round(0.3 * size - x);
    int y2 = (int) Math.round(0.5 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }

  public static void drawLeftHand(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.45 * size + y);
    int x2 = (int) Math.round(0.1 * size - x);
    int y2 = (int) Math.round(0.5 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }

  public static void drawRightLeg(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.6 * size + y);
    int x2 = (int) Math.round(0.3 * size - x);
    int y2 = (int) Math.round(0.65 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }

  public static void drawLeftLeg(int size, int x, int y, Graphics g) {
    int x1 = (int) Math.round(0.2 * size + x);
    int y1 = (int) Math.round(0.6 * size + y);
    int x2 = (int) Math.round(0.1 * size - x);
    int y2 = (int) Math.round(0.65 * size - y);
    g.drawLine(x1, y1, x2, y2);
  }
}
