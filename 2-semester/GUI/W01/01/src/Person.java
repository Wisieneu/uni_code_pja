public class Person {
    String name;
    BankCustomer bankAccount;

    public Person(String name){
        this.name = name;
    }

    public BankCustomer getAccount() {
        return this.bankAccount;
    }

    @Override
    public String toString() {
        if (this.bankAccount == null)
            return this.name + " does not have a bank account";
        return this.name + " bank account balance : " + this.getAccount().getBalance();
    }
}
