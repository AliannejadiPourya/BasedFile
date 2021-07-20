public class Rectangle extends Shape {

    private int length;
    private int height;

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "type :" + getType() + "\nname :" + getName() +
                "\ncolor :" + getColor() + "\nposition :(" + getX() + "," + getY() + ")"
                + "\nlength :" + getLength() + "\nheight :" + getHeight() + "\n";
    }

}
