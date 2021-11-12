import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static String userInput() {
        Scanner input = new Scanner(System.in);
        String userChoice = input.next();

        if (userChoice.matches(".*[a-zA-Z]+.*")) {
            return userChoice;
        } else {
            return "error";
        }
    }

    public static void main(String[] args) {
        String extraTopping;
        ArrayList<String> toppings = new ArrayList<>();
        double price;
        String size;
        System.out.println("welcome to [REDACTED] pizza! ");
        while (true) {
            System.out.println("please select your pizza size (small , medium , large)");
            size = userInput();
            if (size.equals("error")) {
                System.out.println("error, please input a valid data type");
            } else if (size.equals("small")) {
                price = 7.99;
                break;
            } else if (size.equals("medium")) {
                price = 10.99;
                break;
            } else if (size.equals("large")) {
                price = 13.99;
                break;
            }
        }

        while (true) {
            System.out.println("please select your first free topping");
            toppings.add(userInput());
            if (toppings.get(0).equals("error") || toppings.get(0).equals("no")) {
                System.out.println("error, please input a valid data type");
                toppings.remove(0);
            } else {
                break;
            }
        }

        while (true) {
            System.out.println("please select your second free topping");
            toppings.add(userInput());
            if (toppings.get(1).equals("error") || toppings.get(1).equals("no")) {
                System.out.println("error , please input a valid data type");
                toppings.remove(1);
            } else if (toppings.get(0).equals(toppings.get(1))) {
                System.out.println("you cannot have the same topping twice");
                toppings.remove(1);
            } else {
                break;
            }
        }
        while (true) {
            System.out.println("would you like any extra toppings? (each topping costs £1.25 extra) (enter \"no\" to cancel");
            extraTopping = userInput();
            if (extraTopping.equals("error")) {
                System.out.println("error,please input a valid data type");
            } else if (extraTopping.equals("no")) {
                break;
            } else if (toppings.contains(extraTopping)) {
                System.out.println("you cannot have the same topping twice");

            } else {
                toppings.add(extraTopping);
            }
        }
        price = price + (toppings.size() * 1.25);
        System.out.println("your pizza is complete!");
        System.out.println("your pizza is a " + size + " with toppings " + toppings);
        System.out.println("your pizza costs £" + price);

    }
}
