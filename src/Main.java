import Components.*;
import Interfaces.ButtonActions;
import Utils.MySQLHandler;
import Utils.Validator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main extends JFrame {

  String answer = "";
  String wordToPrint = "";
  static int failCounter = 0;
  static int score = 0;
  static int guessTime;
  static int timeAtLastGuess = 0;

  public Main(String word) {
    answer = word;
    wordToPrint = "_".repeat(answer.length());
    DrawField drawfield = new DrawField();
    WordLine wordLine = new WordLine(wordToPrint);
    TimerField timerfield = new TimerField();
    Keyboard keyboard = new Keyboard(
      new ButtonActions<Character>() {
        public void onButtonClickHandler(Character letter) {
          if (timerfield.getTotalSeconds() == 0) timerfield.startTimer();
          if (Validator.validLetter(letter, answer)) {
            guessTime = timerfield.getTotalSeconds() - timeAtLastGuess;
            timeAtLastGuess = timerfield.getTotalSeconds();

            if (guessTime <= 5) score += 5; else if (guessTime <= 10) score +=
              4; else if (guessTime <= 15) score += 3; else if (
              guessTime <= 20
            ) score += 2; else score += 1;

            wordToPrint = Validator.getWordToPrint(letter, wordToPrint, answer);
            wordLine.update(wordToPrint);
          } else {
            failCounter++;
            drawfield.printDrawing(failCounter);
          }

          if (failCounter >= 10) {
            GameEnd.create(
              failCounter,
              getResetActions(),
              answer,
              Integer.toString(score)
            );
            setEnabled(false);
            timerfield.stopTimer();
          } else if (Validator.playerWon(wordToPrint)) {
            GameEnd.create(
              failCounter,
              getResetActions(),
              answer,
              Integer.toString(score)
            );
            timerfield.stopTimer();
            MySQLHandler.addScore(Integer.toString(score));
          }
        }
      }
    );
    setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;

    constraints.gridy = 0;
    constraints.weightx = constraints.weighty = 0.1;
    add(timerfield, constraints);

    constraints.gridy = 1;
    constraints.weightx = constraints.weighty = 0.5;
    add(drawfield, constraints);

    constraints.gridy = 2;
    constraints.weightx = constraints.weighty = 0.1;
    add(wordLine, constraints);

    constraints.gridy = 3;
    constraints.weightx = constraints.weighty = 0.3;
    add(keyboard, constraints);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setPreferredSize(new Dimension(1000, 800));
    pack();
    //5. Show it.
    setVisible(true);
  }

  public static void main(String[] args) {
    MySQLHandler.connect();
    new RegisterField(
      new WordChoose(
        new ButtonActions<String>() {
          @Override
          public void onButtonClickHandler(String param) {
            new Main(param);
          }
        }
      )
    );
  }

  private ButtonActions<ActionEvent> getResetActions() {
    return new ButtonActions<ActionEvent>() {
      @Override
      public void onButtonClickHandler(ActionEvent param) {
        removeAll();
        repaint();
        setEnabled(true);
        failCounter = 0;
        score = 0;
        timeAtLastGuess = 0;
        main(new String[1]);
      }
    };
  }
}
