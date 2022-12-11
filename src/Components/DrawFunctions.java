package Components;
import java.awt.*;
import javax.swing.*;

public class DrawFunctions extends JPanel{

    public static void drawBasic (int x, Graphics g)
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.9 * x);
        int x2 = (int) Math.round(0.8 * x);
        int y2 = (int) Math.round(0.9 * x);
        g.drawLine(x1, y1, x2, y2);
    }
    public static void drawStick (int x, Graphics g)
    {
        int x1 = (int) Math.round(0.5 * x);
        int y1 = (int) Math.round(0.1 * x);
        int x2 = (int) Math.round(0.5 * x);
        int y2 = (int) Math.round(0.9 * x);
        g.drawLine(x1, y1, x2, y2);
    }
    public static void drawHorizontal(int x, Graphics g)
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.1 * x);
        int x2 = (int) Math.round(0.5 * x);
        int y2 = (int) Math.round(0.1 * x);
        g.drawLine(x1, y1, x2, y2);
    }
    public static void drawVertical(int x, Graphics g)
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.1 * x);
        int x2 = (int) Math.round(0.2 * x);
        int y2 = (int) Math.round(0.3 * x);
        g.drawLine(x1, y1, x2, y2);
    }
    public static void drawHead(int x, Graphics g)
    {
        int x1 = (int) Math.round(0.15 * x);
        int y1 = (int) Math.round(0.3 * x);
        int r = (int) Math.round(0.1 * x);
        g.drawOval(x1, y1, r, r);
    }
    public static void drawBody(int x, Graphics g) 
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.4 * x);
        int x2 = (int) Math.round(0.2 * x);
        int y2 = (int) Math.round(0.6 * x);
        g.drawLine(x1, y1, x2, y2);
    }  
    public static void drawRightHand(int x, Graphics g)
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.45 * x);
        int x2 = (int) Math.round(0.3 * x);
        int y2 = (int) Math.round(0.5 * x);
        g.drawLine(x1, y1, x2, y2);
    } 
    public static void drawLeftHand(int x, Graphics g)
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.45 * x);
        int x2 = (int) Math.round(0.1 * x);
        int y2 = (int) Math.round(0.5 * x);
        g.drawLine(x1, y1, x2, y2);
    }  
    public static void drawRightLeg(int x, Graphics g) 
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.6 * x);
        int x2 = (int) Math.round(0.3 * x);
        int y2 = (int) Math.round(0.65 * x);
        g.drawLine(x1, y1, x2, y2);        
    } 
    public static void drawLeftLeg(int x, Graphics g) 
    {
        int x1 = (int) Math.round(0.2 * x);
        int y1 = (int) Math.round(0.6 * x);
        int x2 = (int) Math.round(0.1 * x);
        int y2 = (int) Math.round(0.65 * x);
        g.drawLine(x1, y1, x2, y2);
    } 
}

