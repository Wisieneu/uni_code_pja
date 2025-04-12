public class Person {
    String nazwaFirmy;
    String imie;
    String nazwisko;

    // Konstruktor z argumentami
    public Person(String nazwaFirmy, String imie, String nazwisko) {
        this.nazwaFirmy = nazwaFirmy;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    // Metoda toString do reprezentacji obiektu jako tekst
    @Override
    public String toString() {
        return this.imie + " " + this.nazwisko;
    }
}
