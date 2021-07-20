import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MyPanel extends JPanel {
    ArrayList<String> array = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Color[] color = {Color.BLACK, Color.WHITE, Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW, new Color(150, 75, 0), Color.gray};


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int num = 0;num < Shape.shapecount;num++){
            if (reader.shapes1.get(num) instanceof Circle) {
                Circle circle = (Circle) reader.shapes1.get(num);
                if (reader.shapes1.get(num).getColor().equalsIgnoreCase("black")) {
                    g.setColor(color[0]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("white")) {
                    g.setColor(color[1]);

                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("red")) {
                    g.setColor(color[2]);

                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("blue")) {
                    g.setColor(color[3]);

                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("green")) {
                    g.setColor(color[4]);

                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("yellow")) {
                    g.setColor(color[5]);

                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("brown")) {
                    g.setColor(color[6]);

                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("gray")) {
                    g.setColor(color[7]);

                }
                g.fillOval(reader.shapes1.get(num).getX(), reader.shapes1.get(num).getY(), circle.getRadius(), circle.getRadius());
            }
            if (reader.shapes1.get(num) instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) reader.shapes1.get(num);
                if (reader.shapes1.get(num).getColor().equalsIgnoreCase("black")) {
                    g.setColor(color[0]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("white")) {
                    g.setColor(color[1]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("red")) {
                    g.setColor(color[2]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("blue")) {
                    g.setColor(color[3]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("green")) {
                    g.setColor(color[4]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("yellow")) {
                    g.setColor(color[5]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("brown")) {
                    g.setColor(color[6]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("gray")) {
                    g.setColor(color[7]);
                }
                g.fillRect(reader.shapes1.get(num).getX(), reader.shapes1.get(num).getY(), rectangle.getLength(), rectangle.getHeight());
            }
            if (reader.shapes1.get(num) instanceof Square) {
                Square square = (Square) reader.shapes1.get(num);
                if (reader.shapes1.get(num).getColor().equalsIgnoreCase("black")) {
                    g.setColor(color[0]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("white")) {
                    g.setColor(color[1]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("red")) {
                    g.setColor(color[2]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("blue")) {
                    g.setColor(color[3]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("green")) {
                    g.setColor(color[4]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("yellow")) {
                    g.setColor(color[5]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("brown")) {
                    g.setColor(color[6]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("gray")) {
                    g.setColor(color[7]);
                }
                g.fillRect(reader.shapes1.get(num).getX(), reader.shapes1.get(num).getY(), square.getLength(), square.getLength());
            }
            if (reader.shapes1.get(num) instanceof Oval) {
                Oval oval = (Oval) reader.shapes1.get(num);
                if (reader.shapes1.get(num).getColor().equalsIgnoreCase("black")) {
                    g.setColor(color[0]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("white")) {
                    g.setColor(color[1]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("red")) {
                    g.setColor(color[2]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("blue")) {
                    g.setColor(color[3]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("green")) {
                    g.setColor(color[4]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("yellow")) {
                    g.setColor(color[5]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("brown")) {
                    g.setColor(color[6]);
                } else if (reader.shapes1.get(num).getColor().equalsIgnoreCase("gray")) {
                    g.setColor(color[7]);
                }
                g.fillOval(reader.shapes1.get(num).getX(), reader.shapes1.get(num).getY(), oval.getRadius1(), oval.getRadius2());
        }

        }

    }
}
