import Components.*;
import Utils.Validator;
import java.awt.*;
import javax.swing.*;

class Main {

  static JFrame frame = new JFrame("Hangman");
  static String wordToPrint = "_____";
  static String answer = "labas";
  static int failCounter = 0;

  public static void main(String[] args) {
    frame.setLayout(new GridBagLayout());
    GridBagConstraints constrains = new GridBagConstraints();

    constrains.gridwidth = constrains.gridheight = 1;
    constrains.anchor = GridBagConstraints.NORTHWEST;
    constrains.fill = GridBagConstraints.BOTH;

    DrawField drawfield = new DrawField();
    WordLine wordLine = new WordLine(wordToPrint);
    Keyboard keyboard = new Keyboard(
      new KeyboardActions() {
        public void onButtonClickHandler(char letter) {
          // wordToPrint += letter;
          System.out.println(wordToPrint);
          if (Validator.validLetter(letter, answer)) {
            wordToPrint = Validator.getWordToPrint(letter, wordToPrint, answer);
            System.out.println(wordToPrint);
            wordLine.update(wordToPrint);
          } else {
            failCounter++;
            System.out.println(failCounter);
            drawfield.printDrawing(failCounter);
          }
        }
      }
    );
    constrains.gridx = constrains.gridy = 0;
    constrains.weightx = constrains.weighty = 60;
    frame.add(drawfield, constrains);

    constrains.gridy = 1;
    constrains.weightx = constrains.weighty = 10;
    frame.add(wordLine, constrains);

    constrains.gridy = 2;
    constrains.weightx = constrains.weighty = 30;
    frame.add(keyboard, constrains);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(1000, 800));
    frame.pack();

    //5. Show it.
    frame.setVisible(true);
  }
}
