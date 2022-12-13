package Utils;

public class Validator {

  public static boolean validLetter(char letter, String targetWord) {
    return targetWord.toUpperCase().contains("" + letter);
  }

  public static String getWordToPrint(
    char letter,
    String currWord,
    String target
  ) {
    char[] currWordLetters = currWord.toUpperCase().toCharArray();
    char[] targetLetters = target.toUpperCase().toCharArray();
    for (int i = 0; i < targetLetters.length; i++) if (
      targetLetters[i] == letter
    ) {
      currWordLetters[i] = targetLetters[i];
    }
    return new String(currWordLetters);
  }

  public static boolean playerWon(String currWord) {
    return !currWord.contains("_");
  }
}
