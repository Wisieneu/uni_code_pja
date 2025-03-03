public abstract class Pacjent {
    String nazwisko;
    String choroba;
    String leczenie;

    public Pacjent(String nazwisko, String choroba, String leczenie) {
        this.nazwisko = nazwisko;
        this.choroba = choroba;
        this.leczenie = leczenie;
    }

    public String nazwisko() {
        return this.nazwisko;
    }

    public String choroba() {
        return this.choroba;
    }

    public String leczenie() {
        return this.leczenie;
    }
}
