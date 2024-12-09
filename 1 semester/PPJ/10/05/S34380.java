public class S34380 {
    public class Pojazd {
        private String color;
    }

    public class PojazdKolowy extends Pojazd {
        private int iloscOsi;
    }    

    public class CiagnikSiodlowy extends PojazdKolowy {
        private float masa; // w tonach
    
        public void rozpocznijJazde() {
            if ((this.masa / super.iloscOsi) > 11 ) 
                System.out.println("Jazda niebezpieczna, odmowa uruchomienia silnika");  
            else System.out.println("Jazda rozpoczeta");
        }
    }
}
