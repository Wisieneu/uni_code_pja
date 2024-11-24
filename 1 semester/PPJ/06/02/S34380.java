import java.util.Random;

public class S34380 {

  public void method() {
    int[] tablica = {};
    Random losu = new Random();
    for (int i = 0; i < 10; i++) {
      int next = losu.nextInt(2);
      tablica[i] = next;
    }
    for (int i = 0; i < tablica.length; i++) System.out.println(tablica[i]);
  }
}
