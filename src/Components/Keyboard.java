package Components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Keyboard extends JPanel {

  private char[][] buttonsList = {
    { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P' },
    { 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L' },
    { 'Z', 'X', 'C', 'V', 'B', 'N', 'M' },
  };
  private JButton[][] buttons;

  public Keyboard(ButtonActions<Character> actions) {
    this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
    createButtons(actions);
    addButtonsToPanel();
  }

  private void createButtons(ButtonActions<Character> actions) {
    buttons = new JButton[buttonsList.length][20];
    for (int i = 0; i < buttonsList.length; i++) {
      for (int j = 0; j < buttonsList[i].length; j++) {
        char let = buttonsList[i][j];
        buttons[i][j] = new JButton("" + let);
        buttons[i][j].setFont(new Font("Sans Serif", Font.BOLD, 24));
        buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
        buttons[i][j].addActionListener(
            new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                actions.onButtonClickHandler(let);
                Object obj = e.getSource();
                if (obj instanceof JButton) {
                  JButton button = (JButton) obj;
                  button.setEnabled(false);
                }
              }
            }
          );
      }
    }
  }

  private void addButtonsToPanel() {
    this.setLayout(new GridLayout(3, 1, 0, 0));
    for (JButton[] buttonsRow : buttons) {
      JPanel row = new JPanel();
      row.setLayout(new GridLayout(1, 0));
      row.setBorder(BorderFactory.createLineBorder(Color.GREEN));
      for (JButton button : buttonsRow) {
        if (button != null) {
          row.add(button);
        }
      }
      this.add(row);
    }
  }
}
