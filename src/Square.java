
// file: Square
// Square Class 

package A3;

public class Square extends Rectangle{

    public double calculateCircumference() {
        return this.param1 * 4;
    }

    public double calculateArea() {
        return this.param1 * this.param1;
    }
}
