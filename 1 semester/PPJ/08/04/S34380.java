public class S34380 {
  static int[] processArray(int[] arr1, int[] arr2, int arg) {
    if (arg > 0) {
      double lenDouble = arr1.length - arr2.length;
      int[] longerArgArr = arr1.length > arr2.length ? arr1 : arr2;
      int shorterArrLen = arr1.length > arr2.length ? arr2.length : arr1.length;
      int len = (int) Math.abs(lenDouble);
      int[] arr = new int[len];
      for (int i = 0; i < len; i++) {
        arr[i] = longerArgArr[shorterArrLen + i];
      }
      return arr;
    } else if (arg < 0) {
      int len = arr1.length > arr2.length ? arr2.length : arr1.length;
      int[] arr = new int[len];
      for (int i = 0; i < len; i++) {
        arr[i] = arr1[i] + arr2[i];
      }
      return arr;
    } else {
      return null;
    }
  }

  public void method() {
    int[] arr1 = { 1, 3, 6, 7, 3, 9, 11 };
    int[] arr2 = { -3, 9, 11, 35 };

    int[] result1 = processArray(arr1, arr2, 11);
    int[] result2 = processArray(arr1, arr2, -34);
    int[] result3 = processArray(arr1, arr2, 0);
  }
}
