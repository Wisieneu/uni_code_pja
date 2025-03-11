public abstract class Figure implements FigureInterface {
    String color;
    String name;
    float area;
    float perimeter;

    public Figure(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public float perimeter() {
        return this.perimeter;
    }

    public float area() {
        return this.area;
    }

    @Override
    public String toString() {
        return "a " + this.color + " " + this.name + " with an area of " + this.area + " and a perimeter of " + this.perimeter;
    }
}
