public class S34380 {

  public void method() {
    int wrt = 22;
    for (int n = 0; n <= 9; ++n) {
      double wynik = 1 / Math.pow(2, n);
      System.out.println("\nWynik wyrazu nr " + n + ":");
      System.out.println(wynik * wrt);
    }
  }
}
