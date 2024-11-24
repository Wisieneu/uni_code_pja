public class S34380 {
  public void method() {
    char[][] chars = new char['z' - 'a']['z' - 'a'];

    for (int i = 0; i < chars.length; i++) {
      char c = 'a';
      // tu co każdą iterację litera za zmienną c zmienia się nakolejną w alfabecie,
      // aż do 25, czyli 'y'
      for (int j = 0; j < chars.length; j++, c += 1) {
        chars[i][j] = c;
      }
    }
    // po zakończeniu ciała powyższej pętli, zmienna chars będzie 25 tablicami o
    // długości
    // 25 ze znakami alfabetu od 'a' do 'y'

    for (int i = 0, step = 1; i < chars.length; step = (step << 1) % chars[i].length, i++)
      System.out.println(chars[i][step]);
    // step << 1 mnoży wartość 1 razy 2 i bierze resztę z dzielenia przez 25
    // więc będzie to 1-2-4-8-16-7(bo 32%25=7) i tak 25 razy, bo mamy 25 tablic w
    // tablicy chars
    // czyli:
    // (drugi index)+1 litera alfabetu
    // chars[0][1] - 'b' - odczytujemy index 1 z tablicy o index 0
    // chars[1][2] - 'c' - odczytujemy index 2 z tablicy o index 1
    // chars[4][4] - 'e' - odczytujemy index 4 z tablicy o index 2
    // chars[3][8] - 'i' - odczytujemy index 8 z tablicy o index 3
    // chars[5][16] - 'r' itd
    // chars[6][7] - '' index 7 bo 32 % 25 = 7
    // chars[7][14] - 'o'
    // chars[7][3] - 'd'
    // chars[8][6] - 'g'
    // chars[9][12] - ''
    // chars[10][24] - ''
    // chars[11][23] - ''
    // chars[12][21] - ''
    // chars[13][17] - ''
    // chars[14][9] - ''
    // chars[15][18] - ''
    // chars[16][11] - ''
    // chars[17][22] - ''
    // chars[18][19] - ''
    // chars[19][13] - ''
    // chars[20][1] - 'b'
    // chars[21][2] - 'c'
    // chars[22][4] - 'e'
    // chars[23][8] - 'i'
    // chars[24][16] - 'r'
    // abcdefghijklmnoprstuvwxy
  }
}
