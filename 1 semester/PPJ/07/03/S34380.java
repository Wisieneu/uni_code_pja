public class S34380 {
  public void method() {
    char[][] tab = {
        { 'S', 'a', 'm', 's', 'u', 'n', 'g' },
        { 'N', 'o', 'k', 'i', 'a' },
        { 'A', 'p', 'p', 'l', 'e' },
        { 'B', 'l', 'a', 'c', 'k', 'B', 'e', 'r', 'r', 'y' },
        { 'A', 'l', 'c', 'a', 't', 'e', 'l' },
        { 'S', 'o', 'n', 'y' },
        { 'J', 'o', 'l', 'l', 'a' }
    };

    /*
     * dwie takie same litery
     */

    // 4 warunki dla kazdego ze slow
    boolean[][] conditions = new boolean[4][tab.length];

    for (int i = 0; i < tab.length; i++) {
      char[] checkedWord = tab[i];
      for (int j = 0; j < checkedWord.length; j++) {
        char checkedChar = Character.toLowerCase(checkedWord[j]);
        for (int k = 0; k < j; k++) {
          if (Character.toLowerCase(checkedWord[k]) == checkedChar)
            conditions[0][i] = true;
        }
      }
    }

    System.out.println("\n1: Dwie takie same litery:");
    for (int i = 0; i < conditions[0].length; i++) {
      System.out.println(
          "Slowo nr "
              + (i + 1)
              + (conditions[0][i] ? " ma dwie takie same litery" : " nie ma dwoch takich samych liter"));
    }

    /*
     * suma znakow w slowie wieksza niz 255
     */
    for (int i = 0; i < tab.length; i++) {
      char[] checkedWord = tab[i];
      int count = 0;
      for (char checkedLetter : checkedWord) {
        count += (int) checkedLetter;
      }
      if (count > 255)
        conditions[1][i] = true;
    }

    System.out.println("\n2: Suma znakow wieksza niz 255:");
    for (int i = 0; i < conditions[0].length; i++) {
      System.out.println(
          "Slowo nr "
              + (i + 1)
              + (conditions[1][i] ? " ma sume liter wieksza niz 255" : " nie ma sumy liter wiekszej niz 255"));
    }

    /*
     * zawieranie znaku 'i'
     */
    for (int i = 0; i < tab.length; i++) {
      char[] checkedWord = tab[i];
      for (char checkedLetter : checkedWord) {
        if (Character.toLowerCase(checkedLetter) == 'i')
          conditions[2][i] = true;

      }
    }

    System.out.println("\n3: Zawieranie znaku 'i':");
    for (int i = 0; i < conditions[0].length; i++) {
      System.out.println(
          "Slowo nr "
              + (i + 1)
              + (conditions[2][i] ? " zawiera znak 'i'" : " nie zawiera znaku 'i'"));
    }

    /*
     * zawieranie dwoch takich samych znakow
     */
    for (int i = 0; i < tab.length; i++) {
      char[] checkedWord = tab[i];
      for (int j = 0; j < checkedWord.length; j++) {
        char checkedChar = checkedWord[j];
        for (int k = 0; k < j; k++) {
          if (checkedWord[k] == checkedChar)
            conditions[3][i] = true;
        }
      }
    }

    System.out.println("\n4: Dwa takie same znaki:");
    for (int i = 0; i < conditions[0].length; i++) {
      System.out.println(
          "Slowo nr "
              + (i + 1)
              + (conditions[3][i] ? " ma dwa takie same znaki" : " nie ma dwoch takich samych znakow"));
    }

    System.out.println("\nSlowa spelniajace przynajmniej 3 warunki:");
    for (int wordIndex = 0; wordIndex < conditions[0].length; wordIndex++) {
      int conditionsMetCount = 0;
      for (boolean[] condition : conditions) {
        if (condition[wordIndex])
          conditionsMetCount++;
      }
      if (conditionsMetCount >= 3) {
        for (char letter : tab[wordIndex]) {
          System.out.print(letter);
        }
        System.out.print("\n");
      }
    }
  }
}