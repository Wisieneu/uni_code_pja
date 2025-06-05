public class S34380 {
  public void method() {
    int[][] tab = new int[10][10];
    for (int i = 0; i < tab.length; i++) {
      for (int j = 0; j < tab[i].length; j++) {
        tab[i][j] = (int) (Math.random() * 900) + 100;
      }
    }

    System.out.println("\n===================initial==================");
    for (int[] row : tab) {
      System.err.print("[ ");
      for (int el : row) {
        System.err.print(el + " ");
      }
      System.out.println(" ]");
    }

    for (int[] row : tab) {
      boolean isAscending = false;
      while (!isAscending) {
        for (int i = 0; i < row.length; i++) {
          for (int j = 0; j < i; j++) {
            if (row[j] > row[i]) {
              int temp = row[i];
              row[i] = row[j];
              row[j] = temp;
            }
          }
        }

        // walidacja
        boolean repeat = false;
        for (int i = 0; i < row.length; i++) {
          for (int j = 0; j < i; j++) {
            if (row[j] > row[i])
              repeat = true;

          }
        }
        if (repeat)
          continue;
        isAscending = true;
      }
    }

    System.out.println("\n===================sorted===================");
    for (int[] row : tab) {
      System.err.print("[ ");
      for (int el : row) {
        System.err.print(el + " ");
      }
      System.out.println(" ]");
    }
  }
}
