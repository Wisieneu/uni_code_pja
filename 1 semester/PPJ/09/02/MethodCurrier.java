public class MethodCurrier {
  static void setValue(int arg) {
    System.out.println("Wartość argumentu przed zmianą: " + arg);
    arg++;
    System.out.println("Wartość argumentu po zmianie: " + arg);
  }

  static void setValue(float arg) {
    System.out.println("Wartość argumentu przed zmianą: " + arg);
    arg++;
    System.out.println("Wartość argumentu po zmianie: " + arg);
  }

  static void setValue(Number arg) {
    int val = arg.val;
    System.out.println("Wartość argumentu przed zmianą: " + val);
    val = val + 1;
    System.out.println("Wartość argumentu po zmianie: " + val);
  }

  public static void main(String[] args) {
    setValue(12);
    setValue(3.14f);
    Number arg = new Number(5);
    setValue(arg);
    // wywołane metody zmieniają wartość arugmentu im podanego w ciele tej metody
    // nie zmienią wartości pola klasy Number
  }
}
