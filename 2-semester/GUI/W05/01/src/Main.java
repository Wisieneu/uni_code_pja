public class Main {
    public static void main(String[] args) {

        System.out.println(silnia(3));
        System.out.println(silnia(19));
        System.out.println(silnia(12));
        System.out.println(silnia(5));
        System.out.println(silnia(6));
        System.out.println(silnia(7));
        System.out.println(silnia(1));
        System.out.println(silnia(9));

    }

    public static int silnia(int liczba) {
        if (liczba == 1) return 1;
        else return liczba * silnia(--liczba);
    }
}
