public class Main {
    public static void main(String[] args) {
        Person janP = new Person("Jan"),
                alaP = new Person("Ala");
        BankCustomer jan = new BankCustomer(janP);
        BankCustomer ala = new BankCustomer(alaP);
        jan.getAccount().deposit(1000);
        ala.getAccount().deposit(2000);
        jan.getAccount().transfer(ala.getAccount(), 500);
        ala.getAccount().withdraw(1000);
        System.out.println(jan);
        System.out.println(ala);
        BankCustomer.setInterestRate(0.045f);
        jan.getAccount().addInterest();
        ala.getAccount().addInterest();
        System.out.println(jan);
        System.out.println(ala);
    }
}
