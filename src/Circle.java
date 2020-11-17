
public class Circle extends Ellipse{

    public double calculateCircumference() {
        return 2 * Math.PI * this.param1;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(this.param1, 2);
    }
}
