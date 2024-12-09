public class Walec {
    private double promien;
    private double wysokosc;

    public Walec(int promien, int wysokosc) {
        this.promien = promien;
        this.wysokosc = wysokosc;
    }

    public void show() {
        double polePodstawy = Math.PI * Math.pow(this.promien, 2);
        System.out.println("Pole powierzchni podstawy: " + polePodstawy);

        double objetosc = polePodstawy * this.wysokosc;
        System.out.println("Objetosc walca: " + objetosc);
    }
}
