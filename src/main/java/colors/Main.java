package colors;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Create a new Colors object
        Colors colors = new Colors();

        // Get the colors
        Color c1 = colors.getColor("red");
        Color c2 = colors.getColor("blue");
        Color c3 = colors.getColor("green");
        Color c4 = colors.getColor("brightYellow");


        // Print out the colors
        System.out.println("Color 1: " + c1);
        System.out.println("Color 2: " + c2);
        System.out.println("Color 3: " + c3);
        System.out.println("Color 4: " + c4);

    }
}