
// file: Rectangle
// Rectangle Class

package A3;

public class Rectangle implements Shape {
    protected String name;
    protected double param1;
    protected double param2;
    protected String name_p1;
    protected String name_p2;

    @Override
    public void setName(String n) {
        this.name = n;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setParam1(double p1) {
        this.param1 = p1;
    }

    @Override
    public void setParam2(double p2) {
        this.param2 = p2;
    }

    @Override
    public double getParam1() {
        return this.param1;
    }

    @Override
    public double getParam2() {
        return this.param2;
    }

    @Override
    public void setName_p1(String n1) {
        this.name_p1 = n1;
    }

    @Override
    public void setName_p2(String n2) {
        this.name_p2 = n2;
    }

    @Override
    public String getName_p1() {
        return this.name_p1;
    }

    @Override
    public String getName_p2() {
        return this.name_p2;
    }

    @Override
    public double calculateCircumference() {
        return (this.param1 + this.param2) * 2;
    }

    @Override
    public double calculateArea() {
        return this.param1 * this.param2;
    }
}
