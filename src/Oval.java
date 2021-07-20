public class Oval extends Shape {

    private int radius1;
    private int radius2;

    public void setRadius1(int radius1) {
        this.radius1 = radius1;
    }

    public int getRadius1() {
        return radius1;
    }

    public void setRadius2(int radius2) {
        this.radius2 = radius2;
    }

    public int getRadius2() {
        return radius2;
    }

    @Override
    public String toString() {
        return "type :" + getType() + "\nname :" + getName() +
                "\ncolor :" + getColor() + "\nposition :(" + getX() + "," + getY() + ")"
                + "\nradius1 :" + getRadius1() + "\nradius 2: " + getRadius2() + "\n";
    }

}
