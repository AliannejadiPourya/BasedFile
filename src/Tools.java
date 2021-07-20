import javax.swing.*;
import java.util.Scanner;

public class Tools {//a class to provide tools for options in Main menu
    Scanner sc = new Scanner(System.in);

    public void printInfo() {//prints all the shapes in order
        for (int i = 0; i < Shape.shapecount; i++) {
            System.out.print((i + 1) + ": ");
            printInfo(i);
        }
    }

    public void printInfo(int shapecount) {//prints the selected shape
        System.out.format("%s", Shape.shapes1.get(shapecount));
        System.out.println();
    }

    public void printList() {
        for (int i = 0; i < Shape.shapecount; i++) {
            System.out.print((i+1) + ".");
            System.out.println(Shape.shapes1.get(i).getName());
        }
    }

    public void search(String Name) {//alternative and unused search method
        for (int i = 0; i < Shape.shapecount; i++) {
            if (Shape.shapes1.get(i).getName().equals(Name)) {
                System.out.println("shapecount =" + i);
            }
        }
    }

    public String SearchName(String Name) {//if search is successfull will return the name
        for (int i = 0; i < Shape.shapecount; i++) {
            if (Shape.shapes1.get(i).getName().equals(Name)) {
                return Name;
            }
        }
        return null;
    }

    public void SelectName() {//an method for selecting an Shape and editing just the shape
        System.out.println("Please Enter the name of the Shape:");
        String Name = sc.nextLine();
        if (SearchName(Name) != null) {
            boolean quit = false;
            int choice = 0;
            printInstructions2();

            while (!quit) {
                System.out.println("Please enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 0:
                        printInstructions2();
                        break;
                    case 1:
                        editColor(Name);
                        break;
                    case 2:
                        editSize(Name);
                        break;
                    case 3:
                        editPosition(Name);
                        break;
                    case 4:
                        remove(Name);
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("The input is not in the options!");
                        break;
                }
            }

        } else System.out.println("The Shape was not found!");
    }


    public void edit() {//the main launcher

        // the user can play a song of their liking as long as its format is .wav

/*        String filepath = "OMORI_OST_005_By_Your_Side._7GIWV__qx4M_140.wav";//filepath for music

        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath, false);//starting the song*/

        boolean quit = false;
        int choice = 0;
        printInstructions();

        while (!quit) {//basic menu
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    printList();
                    break;
                case 2:
                    SelectName();
                    break;
                case 3:
                    editColor();
                    break;
                case 4:
                    editSize();
                    break;
                case 5:
                    editPosition();
                    break;
                case 6:
                    remove();
                    break;
                case 7:
                    printInfo();
                    break;
                case 8:
                    draw();
                    break;
                case 9:
                    quit = true;
                    break;
                default://if user enters invalid choice then the following will be printed
                    System.out.println("This is not a valid choice!");
                    break;
            }
        }
    }

    JFrame app = new JFrame();

    public void draw() { //shows the window of shapes
        boolean visible = true;
        app.setSize(1000, 1000);
        app.add(new MyPanel());
        app.setVisible(visible);
    }

    public void printInstructions() { // main menu instructions
        System.out.println("\t        Welcome!");
        System.out.println("Press ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the names of the shapes.");
        System.out.println("\t 2 - To Select Shape by searching its name.");
        System.out.println("\t 3 - To change the color of a shape.");
        System.out.println("\t 4 - To edit the size of a shape.");
        System.out.println("\t 5 - To edit the position of a shape.");
        System.out.println("\t 6 - To remove a shape.");
        System.out.println("\t 7 - To print the available shapes with details.");
        System.out.println("\t 8 - To draw.");
        System.out.println("\t 9 - To exit.");
    }

    public void printInstructions2() {// shape menu instructions
        System.out.println("Press ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To change the color of the shape.");
        System.out.println("\t 2 - To edit the size of the shape.");
        System.out.println("\t 3 - To edit the position of the shape.");
        System.out.println("\t 4 - To remove the shape.");
        System.out.println("\t 5 - To exit.");
    }

    public void editColor() {//the name says it all
        System.out.println("1-Choosing by the Shape Number\n2-Choosing by Name");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                printInfo();
                boolean userInputCorrect = false;
                int num;
                do {
                    System.out.println("Enter the Shape Number:");
                    num = sc.nextInt();
                    userInputCorrect = num <= Shape.shapecount && num > 0;
                    if (!userInputCorrect) {
                        System.out.println("Error Please re-enter.");//will get input until correct
                    }
                } while (!userInputCorrect);

                System.out.println("Available Colors: Black-White-Red-Blue-Green-Yellow-Brown-Gray");
                System.out.println("Enter new Color:");
                String newColor = sc.nextLine();
                Shape.shapes1.get(num - 1).setColor(newColor);
                break;
            case 2:
                System.out.println("Enter the Name of the Shape:");
                String Name = sc.nextLine();
                boolean flag = true;
                for (int i = 0; i < Shape.shapecount; i++) {
                    if (Shape.shapes1.get(i).equals(Name)) {
                        System.out.println("Enter new Color");
                        newColor = sc.nextLine();
                        Shape.shapes1.get(i).setColor(newColor);
                        flag = false;
                    }
                }
                if (flag) {
                    System.out.println("The shape was not found!");
                }
                break;
        }
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        draw();
    }

    public void editColor(String Name) {
        int input = 2;
        switch (input) {
            case 2:
                for (int i = 0; i < Shape.shapecount; i++) {
                    if (Shape.shapes1.get(i).getName().equals(Name)) {
                        System.out.println("Enter new Color");
                        String  newColor = sc.nextLine();
                        Shape.shapes1.get(i).setColor(newColor);

                    }
                }
                break;
        }
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        draw();
    }

    public void editSize() {
        System.out.println("1-Choosing by the Shape Number\n2-Choosing by Name");
        int choise = sc.nextInt();
        sc.nextLine();
        boolean flag = true;
        switch (choise) {
            case 1:
                printInfo();
                boolean userInputCorrect = false;
                int n;
                do {
                    System.out.println("Enter the Shape Number");
                    n = sc.nextInt();
                    userInputCorrect = n <= Shape.shapecount && n > 0;
                    if (!userInputCorrect) {
                        System.out.println("Error Please re-enter.");//will get input until correct
                    }
                } while (!userInputCorrect);
                System.out.println("Enter new Size");
                if (Shape.shapes1.get(n - 1) instanceof Circle) {
                    flag = false;
                    System.out.println("Enter new Radius");
                    int newRadius = sc.nextInt();
                    sc.nextLine();
                    Circle circle = (Circle) Shape.shapes1.get(n - 1);
                    circle.setRadius(newRadius);
                } else if (Shape.shapes1.get(n - 1) instanceof Rectangle) {
                    flag = false;
                    System.out.println("Enter new length");
                    int newLength = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new height");
                    int newHeight = sc.nextInt();
                    sc.nextLine();
                    Rectangle rectangle = (Rectangle) Shape.shapes1.get(n - 1);
                    rectangle.setLength(newLength);
                    rectangle.setHeight(newHeight);
                } else if (Shape.shapes1.get(n - 1) instanceof Square) {
                    flag = false;
                    System.out.println("Enter new length");
                    int newLength = sc.nextInt();
                    sc.nextLine();
                    Square square = (Square) Shape.shapes1.get(n - 1);
                    square.setLength(newLength);
                } else if (Shape.shapes1.get(n - 1) instanceof Oval) {
                    flag = false;
                    System.out.println("Enter new Radius1");
                    int newRadius1 = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new radius2");
                    int newRadis2 = sc.nextInt();
                    sc.nextLine();
                    Oval oval = (Oval) Shape.shapes1.get(n - 1);
                    oval.setRadius1(newRadius1);
                    oval.setRadius2(newRadis2);
                }
                if (flag) {
                    System.out.println("The shape was not found!");
                }
                break;
            case 2:
                System.out.println("Enter the Name of shape");
                String Name = sc.nextLine();
                boolean index = true;
                for (int i = 0; i < Shape.shapecount; i++) {
                    if (Shape.shapes1.get(i).equals(Name)) {
                        index = false;
                        System.out.println("Enter new Size");
                        if (Shape.shapes1.get(i) instanceof Circle) {
                            System.out.println("Enter new Radius");
                            int newRadius = sc.nextInt();
                            sc.nextLine();
                            Circle circle = (Circle) Shape.shapes1.get(i);
                            circle.setRadius(newRadius);
                        } else if (Shape.shapes1.get(i) instanceof Rectangle) {
                            System.out.println("Enter new length");
                            int newLength = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new height");
                            int newHeight = sc.nextInt();
                            sc.nextLine();
                            Rectangle rectangle = (Rectangle) Shape.shapes1.get(i);
                            rectangle.setLength(newLength);
                            rectangle.setHeight(newHeight);
                        } else if (Shape.shapes1.get(i) instanceof Square) {
                            System.out.println("Enter new length");
                            int newLength = sc.nextInt();
                            sc.nextLine();
                            Square square = (Square) Shape.shapes1.get(i);
                            square.setLength(newLength);
                        } else if (Shape.shapes1.get(i) instanceof Oval) {
                            System.out.println("Enter new Radius1");
                            int newRadius1 = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new radius2");
                            int newRadis2 = sc.nextInt();
                            sc.nextLine();
                            Oval oval = (Oval) Shape.shapes1.get(i);
                            oval.setRadius1(newRadius1);
                            oval.setRadius2(newRadis2);
                        }
                    }
                }
                if (index) {
                    System.out.println("The Shape was not found!");
                }
                break;
        }
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        draw();
    }

    public void editSize(String Name) {
        int choice = 2;
        boolean flag = true;
        switch (choice) {
            case 2:
                boolean index = true;
                for (int i = 0; i < Shape.shapecount; i++) {
                    if (Shape.shapes1.get(i).getName().equals(Name)) {
                        index = false;
                        System.out.println("Enter new Size");
                        if (Shape.shapes1.get(i) instanceof Circle) {
                            System.out.println("Enter new Radius");
                            int newRadius = sc.nextInt();
                            sc.nextLine();
                            Circle circle = (Circle) Shape.shapes1.get(i);
                            circle.setRadius(newRadius);
                        } else if (Shape.shapes1.get(i) instanceof Rectangle) {
                            System.out.println("Enter new length");
                            int newLength = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new height");
                            int newHeight = sc.nextInt();
                            sc.nextLine();
                            Rectangle rectangle = (Rectangle) Shape.shapes1.get(i);
                            rectangle.setLength(newLength);
                            rectangle.setHeight(newHeight);
                        } else if (Shape.shapes1.get(i) instanceof Square) {
                            System.out.println("Enter new length");
                            int newLength = sc.nextInt();
                            sc.nextLine();
                            Square square = (Square) Shape.shapes1.get(i);
                            square.setLength(newLength);
                        } else if (Shape.shapes1.get(i) instanceof Oval) {
                            System.out.println("Enter new Radius1");
                            int newRadius1 = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new radius2");
                            int newRadis2 = sc.nextInt();
                            sc.nextLine();
                            Oval oval = (Oval) Shape.shapes1.get(i);
                            oval.setRadius1(newRadius1);
                            oval.setRadius2(newRadis2);
                        }
                    }
                }
                if (index) {
                    System.out.println("The Shape was not found!");
                }
                break;
        }
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        draw();
    }

    public void editPosition() {
        System.out.println("1-Choosing by the Shape Number\n2-Choosing by Name");
        int choise = sc.nextInt();
        sc.nextLine();
        switch (choise) {
            case 1:
                printInfo();
                boolean userInputCorrect = false;
                int n;
                do {
                    System.out.println("Enter the Shape Number");
                    n = sc.nextInt();
                    userInputCorrect = n <= Shape.shapecount && n > 0;
                    if (!userInputCorrect) {
                        System.out.println("Error Please re-enter.");//will get input until correct
                    }
                } while (!userInputCorrect);
                System.out.println("Enter new Position");
                System.out.println("Enter new X");
                int x = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter new Y");
                int y = sc.nextInt();
                sc.nextLine();
                Shape.shapes1.get(n - 1).setX(x);
                Shape.shapes1.get(n - 1).setY(y);
                break;
            case 2:
                System.out.println("Enter the Name of the Shape");
                String Name = sc.nextLine();
                boolean index = true;
                for (int i = 0; i < Shape.shapecount; i++) {
                    if (Shape.shapes1.get(i).equals(Name)) {
                        index = false;
                        System.out.println("Enter new Position");
                        System.out.println("Enter new X");
                        x = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Y");
                        y = sc.nextInt();
                        sc.nextLine();
                        Shape.shapes1.get(i).setX(x);
                        Shape.shapes1.get(i).setY(y);
                    }
                }
                if (index) {
                    System.out.println("The Shape was not found!");
                }
                break;
        }
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        draw();
    }

    public void editPosition(String Name) {
        int choise = 2;
        switch (choise) {
            case 2:
                boolean index = true;
                for (int i = 0; i < Shape.shapecount; i++) {
                    if (Shape.shapes1.get(i).getName().equals(Name)) {
                        index = false;
                        System.out.println("Enter new Position");
                        System.out.println("Enter new X");
                        int x = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Y");
                        int y = sc.nextInt();
                        sc.nextLine();
                        Shape.shapes1.get(i).setX(x);
                        Shape.shapes1.get(i).setY(y);
                    }
                }
                if (index) {
                    System.out.println("The Shape was not found!");
                }
                break;
        }
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        draw();
    }

    public void remove() {
        System.out.println("1 - Choosing by Shape Number\n2 - Choosing by Name");
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            printInfo();
            boolean userInputCorrect = false;
            int num;
            do {
                System.out.println("Enter the Shape Number");
                num = sc.nextInt();
                userInputCorrect = num <= Shape.shapecount && num > 0;
                if (!userInputCorrect) {
                    System.out.println("Error Please re-enter.");//will get input until correct
                }
            } while (!userInputCorrect);

            Shape.shapes1.remove(num - 1);
            Shape.shapecount--;
            System.out.println("Shape deleted!");
        } else if (choice == 2) {
            System.out.println("Please enter the Shape Name:");
            String input = sc.nextLine();
            boolean flag = false;
            for (int i = 0; i < Shape.shapecount; i++) {
                if (Shape.shapes1.get(i).getName().equals(input)) {
                    Shape.shapes1.remove(i);
                    Shape.shapecount--;
                    flag = true;
                    System.out.println("The shape was removed!");
                }
            }
            if (!flag) {
                System.out.println("The Shape was not found!");
            }
        }
    }

    public void remove(String input) {

        int choice = 2;
        if (choice == 2) {
            boolean flag = false;
            for (int i = 0; i < Shape.shapecount; i++) {
                if (Shape.shapes1.get(i).getName().equals(input)) {
                    Shape.shapes1.remove(i);
                    Shape.shapecount--;
                    flag = true;
                    System.out.println("The shape was removed!");
                }
            }
            if (!flag) {
                System.out.println("The Shape was not found!");
            }
        }
    }
}
