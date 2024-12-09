public class Kwadrat {
    private int bok;

    public Kwadrat(int bok) {
        this.bok = bok;
    }

    public void show() {
        System.out.println("Pole kwadratu: " + (this.bok * this.bok));
        System.out.println("Pole szescianu: " + (Math.pow(this.bok, 3)));
    }
}