import java.io.Serializable;
import java.util.Date;

public class Osoba implements Serializable {
    String imie;
    String nazwisko;
    // etc

    public Osoba(String imie, String nazwisko, String PESEL, Date dataUrodzenia, String adresZamieszkania) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return "pan " + this.imie + " " + this.nazwisko;
    }
}
