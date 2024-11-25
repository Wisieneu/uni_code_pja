public class Test {
  static void method2(int length, char startChar) {
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

  public static void main(String[] args) {
    method2(5, 'o');
    System.out.println();
    method2(10, 'x');
    System.out.println();
    method2(9, 'o');
    System.out.println();
    method2(9, 'o');
  }
}