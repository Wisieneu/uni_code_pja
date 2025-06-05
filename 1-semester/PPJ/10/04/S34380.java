public class S34380 {
    public class Osoba {
        private String imie;

        public Osoba(String imie) {
          this.imie = imie;
        }

        public String wyswietl() {
          return ("Imie: " + this.imie);
        }
    }  

    public class Spawacz extends Osoba {
        private int stazPracy;

        public Spawacz(String imie, int stazPracy) {
           super(imie);
           this.stazPracy = stazPracy;
        }

        public String wyswietl() {
          return ("Imie: " + super.imie + ", staz pracy: " + this.stazPracy);
        }
    }
}
