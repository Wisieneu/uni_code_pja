public class S34380 {
  public void method() {
    char[] tab = {'a', 'b', 'c', 'd', 'e'};
    char[] output = {'x', 'x', 'x', 'x', 'x'};
    for (int i=0; i < tab.length; i++) {
      output[i] = tab[(tab.length-1) - i];
    }
  }
}
