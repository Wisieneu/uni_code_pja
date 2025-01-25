public class S34380 {
    public class Pojazd {
        String color;

        Pojazd(String color) {
            this.color = color;
        }
    }

    public class PojazdKolowy extends Pojazd {
        private int iloscOsi;

        PojazdKolowy(String color, int iloscOsi) {
            super(color);
            this.iloscOsi = iloscOsi;
        }
    }

    public class CiagnikSiodlowy extends PojazdKolowy {
        int masa; // w tonach

        CiagnikSiodlowy(String color, int iloscOsi, int masa) {
            super(color, iloscOsi);
            this.masa = masa;
        }

        public void rozpocznijJazde() throws Exception {
            int nacisk = this.masa / super.iloscOsi;
            if (nacisk > 11_000)
                throw new Exception("Jazda niebezpieczna, odmowa uruchomienia silnika");
        }
    }

}
