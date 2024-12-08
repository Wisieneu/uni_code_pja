public class Cplx {
    private double rzeczywista;
    private double urojona;

    Cplx(double rzeczywista, double urojona) {
        this.rzeczywista = rzeczywista;
        this.urojona = urojona;
    }

    public Cplx add(Cplx arg) {
        double newRzeczywista = this.rzeczywista + arg.rzeczywista;
        double newUrojona = this.urojona + arg.urojona;
        Cplx result = new Cplx(newRzeczywista, newUrojona);
        return result;
    }

    public Cplx sub(Cplx arg) {
        double newRzeczywista = this.rzeczywista - arg.rzeczywista;
        double newUrojona = this.urojona - arg.urojona;
        Cplx result = new Cplx(newRzeczywista, newUrojona);
        return result;
    }

    public Cplx mul(Cplx arg) {
        double a = this.rzeczywista, b = this.urojona,
                c = arg.rzeczywista, d = arg.urojona;

        double newRzeczywista = (a * c) - (b * d);
        double newUrojona = (a * c) + (b * d);

        Cplx result = new Cplx(newRzeczywista, newUrojona);
        return result;
    }

    public void inc() {
        this.rzeczywista++;
    }

    public void show() {
        System.out.println(this.rzeczywista + " + " + this.urojona + "i");
    }
}
