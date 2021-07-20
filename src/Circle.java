public class Circle extends Shape {
    private int radius;


    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "type :" + getType() + "\nname :" + getName() +
                "\ncolor :" + getColor() + "\nposition :(" + getX() + "," + getY() + ")"
                + "\nradius :" + getRadius() + "\n";
    }
}
