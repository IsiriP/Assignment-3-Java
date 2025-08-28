package product;

import java.util.*;

public class ProductImplement implements  ProductOperations{
    private Map<String, Product> productMap = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        if (productMap.containsKey(product.getId())) {
            System.out.println("Product with ID " + product.getId() + " already exists!");
            return;
        }
        productMap.put(product.getId(), product);
        System.out.println("Product added successfully!");
    }

    @Override
    public Product searchProduct(String productId) {
        return productMap.get(productId);
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void updateProduct(String productId, String newName, double newPrice, int newStock) {
        Product product = productMap.get(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        product.setName(newName);
        product.setPrice(newPrice);
        product.setStock(newStock);
        System.out.println("Product updated successfully!");
    }

    @Override
    public void deleteProduct(String productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    @Override
    public void addToCart(String productId, int quantity) {
        Product product = productMap.get(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }
        if (product.getStock() < quantity) {
            System.out.println("Not enough stock available!");
            return;
        }
        product.setStock(product.getStock() - quantity);
        System.out.println("Added to cart successfully! Remaining stock: " + product.getStock());
    }
}
