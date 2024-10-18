package SupermarketSystem;

import java.util.Scanner;

public class Supermarket {
    public static void main(String[] args) {
        SupermarketBillingSystem system = new SupermarketBillingSystem();
        Scanner scanner = new Scanner(System.in);
        int roleChoice;

        System.out.println("Welcome to the Supermarket System");
        System.out.println("1. Customer");
        System.out.println("2. Admin");
        System.out.print("Please select your role: ");
        roleChoice = scanner.nextInt();

        if (roleChoice == 1) {
            
            int customerChoice;
            do {
                System.out.println("\nCustomer Menu");
                System.out.println("1. Display Products");
                System.out.println("2. Add to Cart");
                System.out.println("3. Remove from Cart");
                System.out.println("4. View Cart");
                System.out.println("5. Place Order");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                customerChoice = scanner.nextInt();

                switch (customerChoice) {
                    case 1:
                        system.displayProducts();
                        break;
                    case 2:
                        System.out.print("Enter Product ID to add to cart: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int quantity = scanner.nextInt();
                        system.addToCart(productId, quantity);
                        break;
                    case 3:
                        System.out.print("Enter Product ID to remove from cart: ");
                        productId = scanner.nextInt();
                        system.removeFromCart(productId);
                        break;
                    case 4:
                        system.viewCart();  
                        break;
                    case 5:
                        system.placeOrder();
                        break;
                    case 6:
                        System.out.println("Exiting... Thank you for shopping with us!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (customerChoice != 6);

        } else if (roleChoice == 2) {
            
            int adminChoice;
            do {
                System.out.println("\nAdmin Panel");
                System.out.println("1. Add Product");
                System.out.println("2. Remove Product");
                System.out.println("3. Display Products");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                adminChoice = scanner.nextInt();
                scanner.nextLine();  

                switch (adminChoice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        system.addProduct(name, price);
                        break;
                    case 2:
                        System.out.print("Enter Product ID to remove: ");
                        int productId = scanner.nextInt();
                        system.removeProduct(productId);
                        break;
                    case 3:
                        system.displayProducts();
                        break;
                    case 4:
                        System.out.println("Exiting Admin Panel.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (adminChoice != 4);
        } else {
            System.out.println("Invalid role selected. Exiting system.");
        }

        scanner.close();
    }
}
