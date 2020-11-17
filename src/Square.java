// CMPT 275 Assignment 3
// Author: Chin Ho Wan 301308171
// file: Square
// Square Class (extends Rectangle Class)

package A3;

public class Square extends Rectangle{

    public double calculateCircumference() {
        return this.param1 * 4;
    }

    public double calculateArea() {
        return this.param1 * this.param1;
    }
}
