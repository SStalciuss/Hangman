package Components;

import Interfaces.ButtonActions;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.w3c.dom.events.Event;

public class GameEnd {

  public static void create(
    int counter,
    ButtonActions<ActionEvent> endActions
  ) {
    JFrame gameEnd = new JFrame("Game end");
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    JLabel label = new JLabel("Game over");
    JLabel label1 = new JLabel("you won!");
    JLabel label2 = new JLabel("you lost!");
    JButton buttonRestart = new JButton("Restart");
    JButton buttonExit = new JButton("Exit");
    buttonRestart.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          endActions.onButtonClickHandler(e);
          gameEnd.setVisible(false);
        }
      }
    );
    buttonExit.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          System.exit(0);
        }
      }
    );
    panel.add(label);
    if (counter >= 10) panel.add(label2); else panel.add(label1);
    panel.add(buttonRestart);
    panel.add(buttonExit);
    gameEnd.add(panel);
    gameEnd.setSize(200, 100);
    gameEnd.setLocationRelativeTo(null);
    gameEnd.dispatchEvent(new WindowEvent(gameEnd, WindowEvent.WINDOW_CLOSING));
    gameEnd.setVisible(true);
  }
}
