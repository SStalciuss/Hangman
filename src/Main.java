import Components.*;
import Interfaces.ButtonActions;
import Utils.MySQLHandler;
import Utils.Validator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main {

  static JFrame frame = new JFrame("Hangman");
  static String wordToPrint = "";
  static String answer = "";
  static int failCounter = 0;
  static int clickCounter = 0;
  static int score = 0;
  static int guessTime;
  static int timeAtLastGuess = 0;

  public static void main(String[] args) {
    MySQLHandler.connect();
    getWord();

    DrawField drawfield = new DrawField();
    WordLine wordLine = new WordLine(wordToPrint);
    TimerField timerfield = new TimerField();
    Keyboard keyboard = new Keyboard(
      new ButtonActions<Character>() {
        public void onButtonClickHandler(Character letter) {
          clickCounter++;

          if(clickCounter==1)timerfield.startTimer();
          if (Validator.validLetter(letter, answer)) {
            guessTime = timerfield.getTotalSeconds() - timeAtLastGuess;
            timeAtLastGuess = timerfield.getTotalSeconds();

            if(guessTime<=5)score+=5; else
            if(guessTime<=10)score+=4; else
            if(guessTime<=15)score+=3; else
            if(guessTime<=20)score+=2; else score+=1; 

            wordToPrint = Validator.getWordToPrint(letter, wordToPrint, answer);
            wordLine.update(wordToPrint);
          } else {
            failCounter++;
            drawfield.printDrawing(failCounter);
          }

          if (failCounter >= 10) {
            GameEnd.create(failCounter, getResetActions(), answer, Integer.toString(score));
            frame.setEnabled(false);
            timerfield.stopTimer();
          } else if (Validator.playerWon(wordToPrint)){
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
    frame.setLayout(new GridBagLayout());
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;

    constraints.gridy = 0;
    constraints.weightx = constraints.weighty = 0.1;
    frame.add(timerfield, constraints);

    constraints.gridy = 1;
    constraints.weightx = constraints.weighty = 0.5;
    frame.add(drawfield, constraints);

    constraints.gridy = 2;
    constraints.weightx = constraints.weighty = 0.1;
    frame.add(wordLine, constraints);

    constraints.gridy = 3;
    constraints.weightx = constraints.weighty = 0.3;
    frame.add(keyboard, constraints);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setPreferredSize(new Dimension(1000, 800));
    frame.pack();

    //5. Show it.
    frame.setVisible(true);
    new RegisterField(frame);
  }

  private static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  private static ButtonActions<ActionEvent> getResetActions() {
    return new ButtonActions<ActionEvent>() {
      @Override
      public void onButtonClickHandler(ActionEvent param) {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.setEnabled(true);
        failCounter = 0;
        clickCounter = 0;
        score = 0;
        timeAtLastGuess = 0;
        main(new String[1]);
      }
    };
  }

  private static void getWord() {
    int totalRows = MySQLHandler.getRowsCount();
    int wordId = getRandomNumber(1, totalRows);
    answer = MySQLHandler.getWord(wordId);
    wordToPrint = "_".repeat(answer.length());
    System.out.println("answer " + answer);
    System.out.println("wordToPrint " + wordToPrint);
  }
}
