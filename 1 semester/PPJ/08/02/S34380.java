public class S34380 {
  static void modifyValue(int arg) {
    System.out.println("wewnatrz modifyValue przed zmiana: " + arg);
    arg = arg % 5;
    System.out.println("wewnatrz modifyValue po zmianie: " + arg);
  }

  public void method() {
    int wrt = 5;
    System.out.println("wewnatrz main przed zmiana: " + wrt);
    modifyValue(wrt);
    System.out.println("wewnatrz main po zmianie: " + wrt);
  }

}
