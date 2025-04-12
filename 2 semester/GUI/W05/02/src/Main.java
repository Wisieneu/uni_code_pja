public class Main {
    public static void main(String[] args) {
        System.out.println(dodajRekurencyjnie(1));
        System.out.println(dodajRekurencyjnie(2));
        System.out.println(dodajRekurencyjnie(5));
        System.out.println(dodajRekurencyjnie(6));
        System.out.println(dodajRekurencyjnie(12));
        System.out.println(dodajRekurencyjnie(123));
        System.out.println(dodajRekurencyjnie(85));
        System.out.println(dodajRekurencyjnie(99));
        System.out.println(dodajRekurencyjnie(17));
        System.out.println(dodajRekurencyjnie(12));
    }

    public static int dodajRekurencyjnie(int liczba){
        if (liczba == 1) return 1;
        else return liczba + dodajRekurencyjnie(--liczba);
    }
}
