public class S34380 {

  public void method() {
    int tab[];
    System.out.println(tab);
    // wyrzuca błąd składniowy przy kompilacji gdyż błędnie zaincjalizowano tablicę
    // poprawny sposób zainicjalizowania tablicy to:
    int[] tab2;
    // należy podać typ zmiennej, której instancje klasy będą zawarte w danej tablicy
    // eg. String[], double[]
    // zamiast nazwy zmiennej
  }
}
