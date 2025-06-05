public class S34380 {

  public void method() {
    int wysokosc = 8;
    for (int i = 1; i <= wysokosc; ++i) {
      String stars = "";
      for (int star = 1; star <= i; ++star) {
        stars += "*";
      }
      System.out.println(stars);
    }
  }
}
