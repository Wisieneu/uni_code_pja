public class Main {
    public static void main(String[] args) {
        Cplx num1 = new Cplx(2.371e12, 3.66e15);
        Cplx num2 = new Cplx(3.3123e12, 4.11e15);
        Cplx num3 = new Cplx(4.39847e55, 2.312e15);

        Cplx num4 = num1.add(num2);
        Cplx num5 = num2.add(num3);
        Cplx num6 = num3.add(num1);

        num1.show();
        num2.show();
        num3.show();
        num4.show();
        num5.show();
        num6.show();
    }
}
