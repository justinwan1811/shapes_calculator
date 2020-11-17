// CMPT 275 Assignment 3
// Author: Chin Ho Wan 301308171
// file: Circle
// Circle Class (extends Ellipse Class)

package A3;

public class Circle extends Ellipse{

    public double calculateCircumference() {
        return 2 * Math.PI * this.param1;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(this.param1, 2);
    }
}
