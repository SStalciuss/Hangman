package Components;

import java.awt.*;
import javax.swing.*;

public class WordLine extends JPanel {

  public WordLine(String word) {
    printWord(word);
  }

  public void update(String word) {
    this.removeAll();
    printWord(word);
  }

  private void printWord(String word) {
    this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    this.setBorder(BorderFactory.createLineBorder(Color.RED, 3));
    this.setAlignmentX(Component.CENTER_ALIGNMENT);
    // this.setLayout(new GridLayout(1,0));

    JLabel letter = new JLabel(word);
    letter.setFont(new Font("Sans Serif", Font.BOLD, 24));

    this.add(letter);
  }
}
