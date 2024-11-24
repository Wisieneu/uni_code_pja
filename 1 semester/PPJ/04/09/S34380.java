public class S34380 {

  public void method() {
    // sprawdzam czy liczba wrt znajduje się tylko w jednym z podanych przedziałów
    int wrt = 5;

    // definicja zawartości w danych zbiorach
    boolean zbior_a = wrt > -15 && wrt < -10;
    boolean zbior_b = wrt <= -13;

    if (
      (zbior_a && !zbior_b) || // jest w zbiorze "a" oraz nie ma w zbiorze "b"
      (zbior_b && !zbior_a) // jest w zbiorze "b" oraz nie ma w zbiorze "a"
    ) {
      System.out.println("warunek spełniony");
    } else {
      System.out.println("warunek niespełniony");
    }
  }
}
