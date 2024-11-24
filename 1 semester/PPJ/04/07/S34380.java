public class S34380 {

  public void method() {
    float x = 0.6f;
    System.out.println("Liczba należy do następujących przedziałów:");
    if (x >= 0) {
      System.out.println("A");
    }
    if (x <= 1) {
      System.out.println("B");
    }
    if (x >= 0 && x <= 1) {
      System.out.println("C");
    }
  }
}
