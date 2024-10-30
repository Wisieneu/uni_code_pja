public class S34380 {
  public void method() {
    boolean bool1 = true;
    int int1 = 122;
    double double1 = 6.6666;
    char char1 = 'e';

    // porównania, które są niemożliwe:
    // System.out.println(bool1 == int1); 
    // System.out.println(bool1 == char1);
    // System.out.println(bool1 == double1);

    System.out.println(int1 == char1);
    System.out.println(int1 == double1);
    System.out.println(char1 == double1);
  }
}
