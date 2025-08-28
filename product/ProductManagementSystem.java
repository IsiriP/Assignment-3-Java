package product;

import java.util.*;

public class ProductManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductOperations service = new ProductImplement();

        while (true) {
            System.out.println("\n--- Product Management Menu ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Get All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Add to Cart");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Product ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();
                        System.out.print("Enter Stock: ");
                        int stock = sc.nextInt();
                        service.addProduct(new Product(id, name, price, stock));
                        break;

                    case 2:
                        System.out.print("Enter Product ID to search: ");
                        String searchId = sc.nextLine();
                        Product found = service.searchProduct(searchId);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;

                    case 3:
                        List<Product> products = service.getAllProducts();
                        if (products.isEmpty()) {
                            System.out.println("No products available.");
                        } else {
                            System.out.println("--- All Products ---");
                            for (Product p : products) {
                                System.out.println(p);
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter Product ID to update: ");
                        String updateId = sc.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = sc.nextLine();
                        System.out.print("Enter new price: ");
                        double newPrice = sc.nextDouble();
                        System.out.print("Enter new stock: ");
                        int newStock = sc.nextInt();
                        service.updateProduct(updateId, newName, newPrice, newStock);
                        break;

                    case 5:
                        System.out.print("Enter Product ID to delete: ");
                        String deleteId = sc.nextLine();
                        service.deleteProduct(deleteId);
                        break;

                    case 6:
                        System.out.print("Enter Product ID to add to cart: ");
                        String cartId = sc.nextLine();
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        service.addToCart(cartId, qty);
                        break;

                    case 7:
                        System.out.println("Exiting... Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter correct values.");
                sc.nextLine(); // clear invalid input
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
