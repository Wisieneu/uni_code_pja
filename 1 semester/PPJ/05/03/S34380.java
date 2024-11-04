public class S34380 {
  public void method() {
    boolean shouldExecute = false;
    
    while (shouldExecute == true) { // ten kod najpierw sprawdza warunek, potem executuje body pętli
      System.out.println("DO NOT proceed if shouldExecute is false");
      // unsafe fn
    }

    do { // ten kod pomija pierwsze sprawdzenie warunku
      System.out.println("DO NOT proceed if shouldExecute is false");
      // unsafe fn
    } while (shouldExecute == true);
  }
}
