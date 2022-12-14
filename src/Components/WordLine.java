package Components;

import java.awt.*;
import javax.swing.*;

public class WordLine extends JPanel {

  public WordLine(String word) {
    this.setLayout(new GridBagLayout());
    printWord(word);
  }

  public void update(String word) {
    this.removeAll();
    printWord(word);
    this.updateUI();
  }

  private void printWord(String word) {
    for (char let : word.toCharArray()) {
      JLabel letter = new JLabel(let + " ");
      letter.setFont(new Font("Sans Serif", Font.BOLD, 40));
      this.add(letter);
    }
  }
}
