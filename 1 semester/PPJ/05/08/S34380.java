public class S34380 {
  public void method() {
    // 0 polnoc 1 wschod 2 poludnie 3 zachod
    int kierunek = 0;

    while (true) {
      String kierStr = "";
      switch (kierunek) {
        case 0:
          kierStr = "North";
          break;
        case 1:
          kierStr = "East";
          break;
        case 2:
          kierStr = "South";
          break;  
        case 3:
          kierStr = "West";          
      }
      System.out.println("\nObecny kierunek: " + kierStr);
      System.out.println("Wprowadz A lub D aby sie obrocic");
      java.util.Scanner in = new java.util.Scanner(System.in);
      char c = in.next().charAt(0);
      if (c == 'a' || c == 'A') {
        kierunek = kierunek == 0 ? 3 : kierunek - 1;
      } else if (c == 'd' || c == 'D') {
        kierunek = kierunek == 3 ? 0 : kierunek + 1;
      } else {
        System.err.println("Nieprawidlowy przycisk: " + c);
      }
    }
  }
}
