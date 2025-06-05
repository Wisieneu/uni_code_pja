public class S34380 {
  static void method(int length, char startChar) {
    if (startChar != 'o' && startChar != 'x') {
      throw new IllegalArgumentException("startChar must be 'o' or 'x'");
    }

    char secondChar = startChar == 'o' ? 'x' : 'o';

    for (int i = 0; i < length; i++) {
      System.out.println();
      for (int j = 0; j < length; j++) {
        System.out.print((j + i) % 2 == 0 ? startChar : secondChar);
      }
    }
  }
}
