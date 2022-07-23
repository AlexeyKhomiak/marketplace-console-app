import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void printMenu(String[] options){
        System.out.println("\nOptions:");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) {
        String[] options = {
                "1 - Show all users",
                "2 - Show all products",
                "3 - Buy product",
                "4 - Show all products by user id",
                "5 - Show all users by product id",
                "6 - Exit"
        };
        Scanner scanner = new Scanner(System.in);
        Marketplace marketplace = new Marketplace();
        String option = "";
        while (!option.equals("6")) {

            printMenu(options);
            option = scanner.next();

            if (option.equals("1")) {
                System.out.println("Users: ");
                for (User user: marketplace.getAllUsers()) {
                    System.out.println(user.getFullInfo());
                }
            }

            if (option.equals("2")) {
                System.out.println("Products: ");
                for (Product product : marketplace.getAllProducts()) {
                    System.out.println(product.getFullInfo());
                }
            }

            if (option.equals("3")) {
                try {
                    System.out.print("To buy a product, enter the user Id: ");
                    int userId = Integer.parseInt(scanner.next());
                    System.out.print("Enter product id: ");
                    int prodId = Integer.parseInt(scanner.next());
                    System.out.println(marketplace.buyProduct(userId, prodId));
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid format please enter a number");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            if (option.equals("4")) {
                try {
                    System.out.print("Enter user id: ");
                    int answer = Integer.parseInt(scanner.next());

                    System.out.println("List of products by user " + answer+": ");
                    for (Product product : marketplace.getProductsByUserId(answer)) {
                        System.out.println(product.getFullInfo());
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid format please enter a number");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            if (option.equals("5")) {
                try {
                    System.out.print("Enter product id: ");
                    int answer = Integer.parseInt(scanner.next());

                    System.out.println("List of users by product id:");
                    for (User user : marketplace.getUsersByProductId(answer)) {
                        System.out.println(user.getFullName());
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid format please enter a number");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        scanner.close();
        System.out.println("\nGoodbye!");
    }
}
