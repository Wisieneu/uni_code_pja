public class S34380 {
  public void method() {
    int M = 9;
    int D = 23;

    switch (M) {
      case 1:
        System.out.println("Zima");
        break;
      case 2:
        System.out.println("Zima");
        break;
      case 3:
        if (D>=1 && D<=20) { // do 20 marca
          System.out.println("Zima");
        } else if (D>=21 && D<=31) {
          System.out.println("Wiosna");
        }
        break;
      case 4:
        System.out.println("Wiosna");
        break;
      case 5:
        System.out.println("Wiosna");
        break;
      case 6:
        if (D>=1 && D<=20) { // do 20 czerwca
          System.out.println("Wiosna");
        } else if (D>=21 && D<=30) {
          System.out.println("Lato");
        }
        break;
      case 7:
        System.out.println("Lato");
        break;
      case 8:
        System.out.println("Lato");
        break;
      case 9:
        if (D>=1 && D<=22) { // do 22 września
          System.out.println("Lato");
        } else if (D>=23 && D<=31) {
          System.out.println("Jesień");
        }
        break;
      case 10:
        System.out.println("Jesień");
        break;
      case 11:
        System.out.println("Jesień");
        break;
      case 12:
        if (D>=1 && D<=21) { // do 21 grudnia
          System.out.println("Jesień");
        } else if (D>=22 && D<=31) {
          System.out.println("Zima");
        }
        break;
    }
  }
}