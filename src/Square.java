public class Square extends Shape {
    private int length;

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        return "type :" + getType() + " "
                + "\nname :" + getName() +
                "\ncolor :" + getColor() + "\nposition :(" + getX() + "," + getY() + ")"
                + "\nlength :" + getLength() + "\n";
    }


}
