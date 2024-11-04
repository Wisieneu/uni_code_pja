public class S34380 {
  public void method() {
    for (int i = -1500; i <= 1500; ++i) {
      if (i % 3 == 0 && i % 2 == 0) System.out.println(i);
    }
  }
}
