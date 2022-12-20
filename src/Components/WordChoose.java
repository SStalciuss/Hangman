package Components;

import Interfaces.ButtonActions;
import Utils.MySQLHandler;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WordChoose extends JFrame {

  private JButton word = new JButton("Random words");
  private JButton themeWord = new JButton("Theme words");
  private Label label = new Label("Choose game mode");
  static String wordToPrint = "";
  static String answer = "";
  static String theme = "";
  static ButtonActions<String> actions;

  public WordChoose(ButtonActions<String> buttonActions) {
    actions = buttonActions;
    setLayout(new FlowLayout());
    setResizable(false);
    setTitle("Word choose");
    addElementsToPanel();
    setSize(new Dimension(240, 160));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void createWordButton() {
    word.setFont(new Font("Sans Serif", Font.BOLD, 14));
    word.setMargin(new Insets(0, 0, 0, 0));
    word.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          getWord();
        }
      }
    );
  }

  private void createThemeWordButton() {
    themeWord.setFont(new Font("Sans Serif", Font.BOLD, 14));
    themeWord.setMargin(new Insets(0, 0, 0, 0));
    themeWord.addActionListener(
      new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          setVisible(false);
          getThemeWord();
          JOptionPane.showMessageDialog(null, "Your theme is " + theme);
        }
      }
    );
  }

  private void addElementsToPanel() {
    createWordButton();
    createThemeWordButton();

    add(label);

    add(word);
    add(themeWord);
  }

  private static int getRandomNumber(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }

  private static void getWord() {
    int totalRows = MySQLHandler.getRowsCount();
    int wordId = getRandomNumber(1, totalRows);
    answer = MySQLHandler.getWord(wordId);
    wordToPrint = "_".repeat(answer.length());
    System.out.println("answer " + answer);
    System.out.println("wordToPrint " + wordToPrint);
    actions.onButtonClickHandler(answer);
  }

  private static void getThemeWord() {
    int totalRows = MySQLHandler.getRowsCount2();
    int wordId = getRandomNumber(1, totalRows);
    answer = MySQLHandler.getThemeWord(wordId);
    theme = MySQLHandler.getTheme(wordId);
    wordToPrint = "_".repeat(answer.length());
    System.out.println("answer " + answer);
    System.out.println("wordToPrint " + wordToPrint);
    actions.onButtonClickHandler(answer);
  }

  public static String getAnswer() {
    return answer;
  }

  public static String getWordToPrint() {
    return wordToPrint;
  }
}
