import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class reader extends Shape {
    public static String filepath;
    static int count = 0;

    public static void FileReader() {
        ArrayList<String> saveLine = new ArrayList<>();

        try {

            JFileChooser filechooser = new JFileChooser();
            filechooser.addChoosableFileFilter(new FileNameExtensionFilter("Text File", "txt"));
            filechooser.showSaveDialog(null);
            FileReader freader = new FileReader(String.valueOf(filechooser.getSelectedFile()));

            Scanner scanner = new Scanner(freader);
            while (scanner.hasNextLine()) {
                saveLine.add(scanner.nextLine());
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < saveLine.size(); i++) {
            StringReader(saveLine.get(i));
            count++;
        }

    }


    public static void StringReader(String str) {
        ArrayList<String> array = new ArrayList<>();
        ArrayList<String> regular = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            regular.add(null);
        }

        try {

            Collections.addAll(array, str.split(" "));


            for (int i = 0; i < array.size(); i++) {
                if (array.get(i).startsWith("type=")) {
                    regular.set(0, array.get(i).substring(5));
                }
                if (array.get(i).startsWith("name=")) {
                    regular.set(1, array.get(i).substring(5));
                }
                if (array.get(i).startsWith("color=")) {
                    regular.set(2, array.get(i).substring(6));
                }
                if (array.get(i).startsWith("position=")) {
                    regular.set(3, array.get(i).substring(9));
                }
                if (array.get(i).startsWith("radius=")) {
                    regular.set(4, array.get(i).substring(7));
                }
                if (array.get(i).startsWith("length=")) {
                    regular.set(5, array.get(i).substring(7));
                    regular.set(8, array.get(i).substring(7));
                }
                if (array.get(i).startsWith("radius1=")) {
                    regular.set(6, array.get(i).substring(8));
                }
                if (array.get(i).startsWith("radius2=")) {
                    regular.set(7, array.get(i).substring(8));
                }
                if (array.get(i).startsWith("height=")) {
                    regular.set(9, array.get(i).substring(7));
                }
            }
            Random randomGenerator = new Random();
            if (regular.get(0).length() == 0) {
                if (regular.get(4).length() != 0) {
                    regular.set(0, "circle");
                } else if (regular.get(9).length() != 0) {
                    regular.set(0, "rectangle");
                } else if (regular.get(6).length() != 0 || regular.get(7).length() != 0) {
                    regular.set(0, "oval");
                } else {
                    regular.set(0, "square");
                }
            }


            if (regular.get(1).equals("")) {
                if (regular.get(0).equals("circle")) {
                    regular.set(1, "circle" + randomGenerator.nextInt(100));
                } else if (regular.get(0).equals("rectangle")) {
                    regular.set(1, "rectangle" + randomGenerator.nextInt(100));
                } else if (regular.get(0).equals("square")) {
                    regular.set(1, "" + randomGenerator.nextInt(100));
                } else if (regular.get(0).equals("oval")) {
                    regular.set(1, "oval" + randomGenerator.nextInt(100));
                }
            }


            if (regular.get(2).equals("")) {
                regular.set(2, "black");
            }


            if (regular.get(3).equals("")) {
                regular.set(3, "(" + (randomGenerator.nextInt(600) + 50) + "," + (randomGenerator.nextInt(600) + 50) + ")");
            }


            if (regular.get(0).equals("circle")) {
                if (regular.get(4).length() == 0) {
                    regular.set(4, "" + (randomGenerator.nextInt(200) + 50));
                }
            }
            if (regular.get(0).equals("rectangle")) {
                if (regular.get(9).length() == 0) {
                    regular.set(9, "" + (randomGenerator.nextInt(200) + 50));
                }
                if (regular.get(8).length() == 0) {
                    regular.set(8, "" + (randomGenerator.nextInt(200) + 50));
                }
            }
            if (regular.get(0).equals("oval")) {
                if (regular.get(6).length() == 0) {
                    regular.set(6, "" + (randomGenerator.nextInt(200) + 50));
                }
                if (regular.get(7).length() == 0) {
                    regular.set(7, "" + (randomGenerator.nextInt(200) + 50));
                }
            }
            if (regular.get(0).equals("square")) {
                if (regular.get(5).length() == 0) {
                    regular.set(5, "" + (randomGenerator.nextInt(200) + 50));
                }
            }


            if (regular.get(0).equalsIgnoreCase("circle")) {

                shapes1.add(shapecount, new Circle());

                Circle circle = (Circle) shapes1.get(shapecount);

                shapes1.get(shapecount).setType(regular.get(0));

                shapes1.get(shapecount).setName(regular.get(1));

                shapes1.get(shapecount).setColor(regular.get(2));

                int x = Integer.parseInt(regular.get(3).substring(1, regular.get(3).indexOf(',')));

                shapes1.get(shapecount).setX(x);
                int y = Integer.parseInt(regular.get(3).substring(regular.get(3).indexOf(',') + 1, regular.get(3).indexOf(')')));

                shapes1.get(shapecount).setY(y);

                int radius = Integer.parseInt(regular.get(4));
                if (shapes1.get(shapecount) instanceof Circle) {
                    circle.setRadius(radius);
                }
                shapecount++;
            }
            if (regular.get(0).equalsIgnoreCase("square")) {

                shapes1.add(shapecount, new Square());

                Square square = (Square) shapes1.get(shapecount);
                shapes1.get(shapecount).setType(regular.get(0));

                shapes1.get(shapecount).setName(regular.get(1));
                shapes1.get(shapecount).setColor(regular.get(2));

                int x = Integer.parseInt(regular.get(3).substring(1, regular.get(3).indexOf(',')));

                shapes1.get(shapecount).setX(x);
                int y = Integer.parseInt(regular.get(3).substring(regular.get(3).indexOf(',') + 1, regular.get(3).indexOf(')')));

                shapes1.get(shapecount).setY(y);
                int length = Integer.parseInt(regular.get(5));
                square.setLength(length);

                shapecount++;
            }
            if (regular.get(0).equalsIgnoreCase("rectangle")) {

                shapes1.add(shapecount, new Rectangle());

                Rectangle rectangle = (Rectangle) shapes1.get(shapecount);
                shapes1.get(shapecount).setType(regular.get(0));

                shapes1.get(shapecount).setName(regular.get(1));

                shapes1.get(shapecount).setColor(regular.get(2));
                int x = Integer.parseInt(regular.get(3).substring(1, regular.get(3).indexOf(',')));

                shapes1.get(shapecount).setX(x);
                int y = Integer.parseInt(regular.get(3).substring(regular.get(3).indexOf(',') + 1, regular.get(3).indexOf(')')));

                shapes1.get(shapecount).setY(y);
                int length = Integer.parseInt(regular.get(8));
                rectangle.setLength(length);
                int height = Integer.parseInt(regular.get(9));
                rectangle.setHeight(height);
                shapecount++;
            }
            if (regular.get(0).equalsIgnoreCase("oval")) {

                shapes1.add(shapecount, new Oval());

                Oval oval = (Oval) shapes1.get(shapecount);

                shapes1.get(shapecount).setType(regular.get(0));

                shapes1.get(shapecount).setName(regular.get(1));

                shapes1.get(shapecount).setColor(regular.get(2));
                int x = Integer.parseInt(regular.get(3).substring(1, regular.get(3).indexOf(',')));

                shapes1.get(shapecount).setX(x);
                int y = Integer.parseInt(regular.get(3).substring(regular.get(3).indexOf(',') + 1, regular.get(3).indexOf(')')));

                shapes1.get(shapecount).setY(y);
                int radius1 = Integer.parseInt(regular.get(6));
                oval.setRadius1(radius1);
                int radius2 = Integer.parseInt(regular.get(7));
                oval.setRadius2(radius2);
                shapecount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public reader() {
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
}
