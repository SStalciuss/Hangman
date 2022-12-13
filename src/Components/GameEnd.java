package Components;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameEnd {

  public static void create(int counter) {
    JFrame gameEnd = new JFrame("Game end");
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    JLabel label = new JLabel("Game over");
    JLabel label1 = new JLabel("you won!");
    JLabel label2 = new JLabel("you lost!");
    JButton buttonRestart = new JButton();
    JButton buttonExit = new JButton();
    buttonRestart.setText("Restart");
    buttonExit.setText("Exit");
    panel.add(label);
    if (counter >= 10) panel.add(label2); else panel.add(label1);
    panel.add(buttonRestart);
    panel.add(buttonExit);
    gameEnd.add(panel);
    gameEnd.setSize(200, 100);
    gameEnd.setLocationRelativeTo(null);
    gameEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameEnd.setVisible(true);
  }
}
