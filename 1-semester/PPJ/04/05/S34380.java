public class S34380 {

  public void method() {
    int a = 3;
    int b = 3;
    int c = 3;

    String outputMsg = (a == b && b == c && c == a)
      ? "są takie same"
      : "nie są takie same";

    System.out.println(outputMsg);
  }
}
