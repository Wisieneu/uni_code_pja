import java.util.Random;

public class S34380 {

  public void method() {
    double[] tablica = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    Random losu = new Random();
    for (int i = 0; i < tablica.length; i++) {
      double next = losu.nextDouble(10);
      tablica[i] = next;
    }

    // wszystkie
    System.out.println("Zawartość całej tablicy:");
    String tablicaString = "";
    for (int i = 0; i < tablica.length; i++) {
      tablicaString += tablica[i] + " ";
    }
    System.out.println(tablicaString);

    // parzyste
    System.out.println("Elementy tablicy o indeksie parzystym:");
    tablicaString = "";
    for (int i = 0; i < tablica.length; i += 2) {
      tablicaString += tablica[i] + " ";
    }
    System.out.println(tablicaString);

    // elementy ktorych konwersja na int jest liczba nieparzysta
    System.out.println(
      "Elementy tablicy, których wartości przekonwertowane na int są nieparzyste:"
    );
    tablicaString = "";
    for (int i = 0; i < tablica.length; i++) {
      if (((int) tablica[i] % 2) == 1) tablicaString += tablica[i] + " ";
    }
    System.out.println(tablicaString);
  }
}
