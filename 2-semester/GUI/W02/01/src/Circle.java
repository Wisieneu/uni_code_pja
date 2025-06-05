public class Circle extends Figure {
    float radius;

    public Circle(float radius, String color) {
        super("circle", color);
        this.radius = radius;
        this.area = ((float) Math.PI) * radius * radius;
        this.perimeter = 2 * ((float) Math.PI) * radius;
    }
}
