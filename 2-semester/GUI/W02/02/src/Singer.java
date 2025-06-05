public abstract class Singer {
    private int startingNumber;
    private static int counter;
    String name;

    static {
        counter = 1;
    }

    public Singer(String name) {
        this.name = name;
        this.startingNumber = counter++;
    }

    abstract void sing();

    @Override
    public String toString() {
        return " Singer no. " + this.startingNumber + ": " + this.name;
    }
}
