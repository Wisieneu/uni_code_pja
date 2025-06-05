public class Samochod {
    static enum Marka {
        SKODA,
        MAZDA,
        BMW,
        VOLVO
    }

    Marka marka;
    String nrRej;

    public Samochod(String nrRej, Marka marka) {
        this.nrRej = nrRej;
        this.marka = marka;
    }
}
