package util;

import com.sun.jdi.IntegerValue;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }


    public String getString() {
        return scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return getString();
    }

    public boolean yesNo() {
        String booleanInput = scanner.next();
        scanner.nextLine();
        return booleanInput.equalsIgnoreCase("y") || booleanInput.equalsIgnoreCase("yes");
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        return yesNo();
    }

    public int getInt(int min, int max, String prompt) {
        System.out.format(prompt);
//        int userInt = scanner.nextInt();
        try {
            int userInt = Integer.valueOf(getString());
            if (userInt >= min && userInt <= max) {
                return userInt;
            } else {
                System.out.println("This is not a valid integer.");
                return getInt(min, max, prompt);
            }
        } catch (NumberFormatException e) {
            System.out.println("This is not an integer. Try again.");
            return getInt(min, max, prompt);
        }
    }

    public int getInt(int min, int max) {
        System.out.format("Enter a number between %f and %f: ", min, max);
        try {
//            double userDouble = scanner.nextDouble();
            int userInt = Integer.valueOf(getString());
            if (userInt >= min && userInt <= max) {
                return userInt;
            } else {
                System.out.println("This is not a valid integer.");
                return getInt(min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println("This is not an integer. Try again.");
            return getInt(min, max);
        }
    }

    public int getInt() {
//        return scanner.nextInt();
        try {
            return Integer.valueOf(getString());
        } catch (Exception e) {
            System.out.println("Invalid input");
            return getInt();
        }
    }

    public double getDouble(double min, double max, String prompt) {
        System.out.format(prompt);
//        double userDouble = scanner.nextDouble();
        try {
            double userDouble = Double.valueOf(getString());
            if (userDouble >= min && userDouble <= max) {
                return userDouble;
            } else {
                System.out.println("This is not a valid integer within the range.");
                return getDouble(min, max, prompt);
            }
        } catch (NumberFormatException e) {
            System.out.println("This is not an integer. Try again.");
            return getDouble(min, max, prompt);
        }
    }

    public double getDouble(double min, double max) {
        System.out.format("Enter a number between %f and %f: ", min, max);
        try {
//            double userDouble = scanner.nextDouble();
            double userDouble = Double.valueOf(getString());
            if (userDouble >= min && userDouble <= max) {
                return userDouble;
            } else {
                System.out.println("This is not a valid integer.");
                return getDouble(min, max);
            }
        } catch (NumberFormatException e) {
            System.out.println("This is not an integer. Try again.");
            return getDouble(min, max);
        }
    }

    public double getDouble() {
        try {
            return Double.valueOf(getString());
        } catch (Exception e) {
            System.out.println("Invalid input");
            return getDouble();
        }
    }

    public int getBinary() {
        int userInt = 0;
//        return scanner.nextInt();
        String s = getString();
        try {
            userInt = Integer.valueOf(s, 2);
        } catch (Exception e) {
            System.out.println("Invalid Binary input");
            return getBinary();
        }
        return userInt;
    }

    public int getHex() {
        int userInt = 0;
//        return scanner.nextInt();
        String s = getString();
        try {
            userInt = Integer.valueOf(s, 2);
        } catch (Exception e) {
            System.out.println("Invalid Hex input");
            return getHex();
        }
        return userInt;
    }
}
