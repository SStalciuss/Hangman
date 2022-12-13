import Components.*;
import Utils.MySQLHandler;
import Utils.Validator;
import java.awt.*;
import javax.swing.*;

class Main {

  static JFrame login = new JFrame("Login");
  static JFrame register = new JFrame("Register");
  static JFrame frame = new JFrame("Hangman");
  static String wordToPrint = "_____";
  static String answer = "labas";
  static int failCounter = 0;

  public static void main(String[] args) {
    MySQLHandler.conection();
    
    LoginField loginfield = new LoginField(new LoginActions());
    login.add(loginfield);
    login.setPreferredSize(new Dimension(300, 200));
    login.pack();
    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    RegisterField registerfield = new RegisterField(new LoginActions(){
      public void onButtonClickHandler(String name) {
        if (name == "Have an account?") {
          login.setVisible(true);
          register.setVisible(false);
        }
      }
    });
    register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    register.add(registerfield);
    register.setPreferredSize(new Dimension(300, 200));
    register.pack();
    register.setVisible(true);
    
    frame.setLayout(new GridBagLayout());
    GridBagConstraints constrains = new GridBagConstraints();

    constrains.fill = GridBagConstraints.BOTH;

    DrawField drawfield = new DrawField();
    WordLine wordLine = new WordLine(wordToPrint);
    Keyboard keyboard = new Keyboard(
      new KeyboardActions() {
        public void onButtonClickHandler(char letter) {
          if (Validator.validLetter(letter, answer)) {
            wordToPrint = Validator.getWordToPrint(letter, wordToPrint, answer);
            wordLine.update(wordToPrint);
          } else {
            failCounter++;
            drawfield.printDrawing(failCounter);
          }

          if (failCounter >= 10) {
            frame.setEnabled(false);
          }
        }
      }
    );
    constrains.gridy = 0;
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
