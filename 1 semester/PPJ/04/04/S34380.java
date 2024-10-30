public class S34380 {
  public void method() {
    int a = 3;
    int b = 3;
    
    if (!(a>b) && !(a<b)){
      System.out.println("condition met");
    }

    // alternatywnie
    if (a==b) {
      System.out.println("condition met");
    }
  }
}