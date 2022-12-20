package Components;

import Interfaces.ButtonActions;
import Components.ScoreBoard;
import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameEnd {

  public static void create(
    int counter,
    ButtonActions<ActionEvent> endActions,
    String answer,
    String score
  ) {
    JFrame gameEnd = new JFrame("Game end");
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    JLabel label = new JLabel("Game over!");
    JLabel label1 = new JLabel("You won!");
    JLabel label2 = new JLabel("You lost!");
    JLabel label3 = new JLabel("The word was " + answer);
    JLabel label4 = new JLabel("You got " + score + " points!  ");
    JLabel label5 = new JLabel("You got 0 points!  ");
    JButton buttonRestart = new JButton("Restart");
    JButton buttonExit = new JButton("Exit");
    JButton buttonScoreboard = new JButton ("Show Scoreboard");

    buttonScoreboard.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          new ScoreBoard(gameEnd);
        }
      }
    );

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
    panel.add(label3);
    if (counter >= 10) panel.add(label5); else panel.add(label4);
    panel.add(buttonRestart);
    panel.add(buttonExit);
    panel.add(buttonScoreboard);
    gameEnd.add(panel);
    gameEnd.setSize(200, 170);
    gameEnd.setLocationRelativeTo(null);
    gameEnd.dispatchEvent(new WindowEvent(gameEnd, WindowEvent.WINDOW_CLOSING));
    gameEnd.setVisible(true);
  }
}
