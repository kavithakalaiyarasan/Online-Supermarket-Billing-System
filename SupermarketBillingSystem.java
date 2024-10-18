package SupermarketSystem;

import java.util.ArrayList;
import java.util.HashMap;

class SupermarketBillingSystem {
    HashMap<Integer, Product> productList = new HashMap<>();
    ArrayList<CartItem> cart = new ArrayList<>();
    int productIdCounter = 106; 

    public SupermarketBillingSystem() {
        productList.put(101, new Product("Apple(1kg)",100 ));
        productList.put(102, new Product("Banana(1kg)", 50));
        productList.put(103, new Product("Nivea soft moisurasor", 40));
        productList.put(104, new Product("Rice(1kg)", 150));
        productList.put(105, new Product("Bread", 35));
    }

    // Customer functionalities
    public void displayProducts() {
        System.out.println("Available Products:");
        for (Integer productId : productList.keySet()) {
            Product product = productList.get(productId);
            System.out.println(productId + ": " + product.name + " - Rs." + product.price);
        }
    }

    public void addToCart(int productId, int quantity) {
        if (productList.containsKey(productId)) {
            cart.add(new CartItem(productList.get(productId), quantity));
            System.out.println(quantity + " " + productList.get(productId).name + "(s) added to cart.");
        } else {
            System.out.println("Invalid Product ID.");
        }
    }

    public void removeFromCart(int productId) {
        boolean found = false;
        for (CartItem item : cart) {
            if (item.product.equals(productList.get(productId))) {
                cart.remove(item);
                System.out.println(item.product.name + " removed from cart.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found in the cart.");
        }
    }

    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            double totalAmount = 0;
            System.out.println("\n--- Cart Contents ---");
            for (CartItem item : cart) {
                System.out.println(item.product.name + " x " + item.quantity + " = Rs." + item.getTotalPrice());
                totalAmount += item.getTotalPrice();
            }
            System.out.println("Total Cart Value: Rs." + totalAmount);
        }
    }

    public void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty. Add some products to place an order.");
        } else {
            System.out.println("Order placed successfully! Here's your bill:");
            generateBill();
            cart.clear();
        }
    }

    public void generateBill() {
        double totalAmount = 0;
        System.out.println("\n--- Your Bill ---");
        for (CartItem item : cart) {
            System.out.println(item.product.name + " x " + item.quantity + " = Rs." + item.getTotalPrice());
            totalAmount += item.getTotalPrice();
        }
        System.out.println("Total Amount: Rs." + totalAmount);
    }

    // Admin functionalities
    public void addProduct(String name, double price) {
        productList.put(productIdCounter, new Product(name, price));
        System.out.println(name + " has been added with Product ID " + productIdCounter + ".");
        productIdCounter++;
    }

    public void removeProduct(int productId) {
        if (productList.containsKey(productId)) {
            Product removedProduct = productList.remove(productId);
            System.out.println(removedProduct.name + " has been removed from the product list.");
        } else {
            System.out.println("Product ID not found.");
        }
    }
}

