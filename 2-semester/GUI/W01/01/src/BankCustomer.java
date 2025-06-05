public class BankCustomer {
    Person person;
    private Float balance;

    static float interestRate = 0.02f;

    public BankCustomer(Person person) {
        this.person = person;
        this.person.bankAccount = this;
        this.balance = 0.0f;
    }

    public BankCustomer getAccount() {
        return this;
    }

    public float getBalance() {
        return this.balance;
    }

    public float deposit(float amountDeposited) {
        if (amountDeposited <= 0)
            throw new Error("Invalid deposit amount");
        this.balance = this.balance + amountDeposited;
        return this.balance;
    }

    public float withdraw(float amountWithdrawn) {
        if (amountWithdrawn <= 0)
            throw new Error("Invalid withdraw amount");
        if (amountWithdrawn > this.balance)
            throw new Error("Insufficient balance");
        this.balance = this.balance - amountWithdrawn;
        return this.balance;
    }

    public void transfer(BankCustomer recipient, float amountTransferred) {
        if (amountTransferred > this.balance)
            throw new Error("Insufficient balance");
        this.balance = this.balance - amountTransferred;
        recipient.balance = recipient.balance + amountTransferred;
    }

    public void addInterest() {
        this.balance = this.balance + this.balance * interestRate;
    }

    static void setInterestRate(float newInterestRate) {
        if (newInterestRate > 1 || newInterestRate < 0)
            throw new Error("Invalid interest rate input");
        interestRate = newInterestRate;
    }

    @Override
    public String toString() {
        return this.person.name + " bank account balance : " + this.getAccount().getBalance();
    }
}
