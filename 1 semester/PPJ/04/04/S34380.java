public class S34380 {

  public void method() {
    int a = 3;
    int b = 3;

    boolean wynik = !(a > b) && !(a < b); // pierwotnie, z zadania
    wynik = a == b;
    wynik = a <= b && a >= b; // alternatywnie

    System.out.println(wynik ? "warunek spełniony" : "warunek niespełniony");
  }
}
