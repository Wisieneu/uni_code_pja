public class S34380 {
    public void method() {
        Owoc[] tab = new Owoc[100];
        double wagaOwocow = 0;
        for (int i = 0; wagaOwocow < 5000; i++) {
            Owoc nowyOwoc = Drzewo.zerwijOwoc();
            tab[i] = nowyOwoc;
            wagaOwocow += nowyOwoc.masa;
        }

        int[] licznik = new int[3];
        for (Owoc owoc : tab) {
            if (owoc instanceof Owoc)
                System.out.println(owoc.nazwa + " o wadze " + owoc.masa + "g");

            if (owoc instanceof Jablko)
                licznik[0]++;
            else if (owoc instanceof Pomarancza)
                licznik[1]++;
            else if (owoc instanceof Gruszka)
                licznik[2]++;
        }

        System.out.println("Ilosc jablek: " + licznik[0]);
        System.out.println("Ilosc pomaranczy: " + licznik[1]);
        System.out.println("Ilosc gruszek: " + licznik[2]);
    }
}

class Owoc {
    String nazwa;
    double masa;
}

class Jablko extends Owoc {
    public Jablko() {
        this.nazwa = "jablko";
        this.masa = 100 + (Math.random() * 150);
    }
}

class Pomarancza extends Owoc {
    public Pomarancza() {
        this.nazwa = "pomarancza";
        this.masa = 100 + (Math.random() * 150);
    }
}

class Gruszka extends Owoc {
    public Gruszka() {
        this.nazwa = "gruszka";
        this.masa = 100 + (Math.random() * 150);
    }
}

class Drzewo {
    static Owoc zerwijOwoc() {
        double i = Math.random() * 3;
        if (i < 1)
            return new Jablko();
        else if (i < 2)
            return new Pomarancza();
        else
            return new Gruszka();
    }
}