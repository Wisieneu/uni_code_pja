import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main ( String [] args ) {
        Osoba kowalski = new Osoba("Jan", "Kowalski");
        Osoba nowak = new Osoba("Adam", "Nowak");
        Osoba krawczyk = new Osoba("Bartosz", "Krawczyk");
        Osoba heniek = new Osoba("Kierownik", "Heniek");
        Samochod skoda1 = new Samochod("WA00001", Samochod.Marka.SKODA);
        Samochod skoda2 = new Samochod("SC36010", Samochod.Marka.SKODA);
        Samochod mazda1 = new Samochod("WA01234", Samochod.Marka.MAZDA);
        Samochod mazda2 = new Samochod("DW01ASD", Samochod.Marka.MAZDA);
        Samochod bmw = new Samochod("WA12690", Samochod.Marka.BMW);
        Samochod volvo = new Samochod("KR60606", Samochod.Marka.VOLVO);

        /*
         * Jan Kowalski -> SKODA WA00001 , BMW WA12690
         * Adam Nowak -> MAZDA DW01ASD
         * Bartosz Krawczyk -> VOLVO KR60606 , MAZDA WA01234 , SKODA SC36010
         * Kierownik Heniek -> [Brak samochodów]
         *
         * Samochody , których numery rejestracyjne zaczynają się na WA:
         * SKODA WA00001
         * BMW WA12690
         * MAZDA WA01234
         * */

        HashMap<Samochod, Osoba> mapaSamochodow = new HashMap<>();
        mapaSamochodow.put(skoda1, kowalski);
        mapaSamochodow.put(mazda2, nowak);
        mapaSamochodow.put(volvo, krawczyk);
        mapaSamochodow.put(bmw, kowalski);
        mapaSamochodow.put(mazda1, krawczyk);
        mapaSamochodow.put(skoda2, krawczyk);

        for (Osoba os : mapaSamochodow.values()) {
            int count = 0;
            for (Map.Entry<Samochod, Osoba> entry : mapaSamochodow.entrySet()) {
                if (entry.getValue() == os) count++;
            }
            System.out.println(os.imie + " posiada " + count + " pojazdy");
        }
    }
}
