public class S34380 {

  public void method() {
    int wrt = -1;
    boolean isWithin;

    if (
      ((wrt > -15 && wrt <= -10) ||
        (wrt > -5 && wrt < 0) ||
        (wrt > 5 && wrt < 10)) && // zbiór A
      (wrt <= -13 || (wrt > -8 && wrt <= -3)) && // zbiór B
      (wrt >= -4) // zbiór C
    ) {
      isWithin = true;
    } else {
      isWithin = false;
    }
    System.out.println(
      isWithin
        ? "Liczba znajduje się w części wspólnej zbiorów"
        : "Liczba nie znajduje się w części wspólnej zbiorów"
    );
  }
}
