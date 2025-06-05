public class S34380 {
  static int countOccurences(char arg) {
    char[] tab = {
        'a', 'l', 'a',
        ' ',
        'm', 'a',
        ' ',
        'k', 'o', 't', 'a'
    };

    int count = 0;
    for (char c : tab) {
      if (c == arg)
        count++;
    }
    return count;
  }

  public void method() {
    System.out.println("ilosc wystapien 'a' w tablicy: " + countOccurences('a'));
    System.out.println("ilosc wystapien 'b' w tablicy: " + countOccurences('b'));
    System.out.println("ilosc wystapien 'm' w tablicy: " + countOccurences('m'));
    System.out.println("ilosc wystapien 'd' w tablicy: " + countOccurences('d'));
  }
}