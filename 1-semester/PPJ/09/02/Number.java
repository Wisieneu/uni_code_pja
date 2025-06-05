public class Number {
    protected int val;

    public Number(int newVal) {
        setValue(newVal);
    }

    public void setValue(int newVal) {
        this.val = newVal;
    }

    public void showValue() {
        System.out.println(val);
    }
}
