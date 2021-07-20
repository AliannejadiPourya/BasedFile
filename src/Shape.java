import java.util.ArrayList;

public abstract class Shape {
    static Shape[] shapes = new Shape[100];
    static ArrayList<Shape> shapes1 = new ArrayList<>();
    static int shapecount = 0;
    private String name;
    private String type;
    private String color;
    private int x;
    private int y;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "type :" + getType() + "\nname :" + getName() + "\ncolor :" + getColor() + "position :(" + getX() + "," + getY() + ")";
    }


}
