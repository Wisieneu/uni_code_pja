public class S34380 {

  public void method() {
    int[] tab1 = { 1, 2, 3, 4, 5 };
    int[] tab2 = { 6, 7, 8, 9, 10 };
    int[] tab3 = { 11, 12, 13, 14, 15 };

    int[][] tabMerged = { tab1, tab2, tab3 };

    for (int i = 0; i < tabMerged.length; i++) {
      System.out.print("Tablica nr 1: ");
      for (int j : tabMerged[i]) {
        System.out.print(j + ", ");
      }
      System.out.println();
    }
  }
}
