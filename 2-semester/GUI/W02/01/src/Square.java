public class Square extends Figure {
    float side;

    public Square(float side, String color) {
        super("square", color);
        this.side = side;
        this.area = side * side;
        this.perimeter = 4 * side;
    }
}
