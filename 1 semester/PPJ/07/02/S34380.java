public class S34380 {
  public void method() {
    // deklaracja
    int arr[][] = new int[10][10];

    // losowe wartosci
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = (int) (Math.random() * 10) + 1;
      }
    }

    // licznik wystapien (indeks okresla wartosc liczby 0-10)
    int[] countArr = new int[11];

    for (int i = 0; i < arr.length; i++) {
      // przekatna nw-se
      int val1 = arr[i][i];

      // przekatna ne-sw
      int val2 = arr[arr.length - 1][i];

      countArr[val1]++;
      countArr[val2]++;
    }

    boolean isConditionMet = false;

    for (int i : countArr) {
      if (i >= 3)
        isConditionMet = true;
    }

    System.out.println(isConditionMet
        ? "Na przekatnych tablicy wystepuja co najmniej 3 takie same liczby"
        : "Na przekatnych tablicy nie wystepuja 3 takie same liczby");
  }
}
