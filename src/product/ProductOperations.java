package product;

import java.util.List;

public interface ProductOperations {
    void addProduct(Product product);
    Product searchProduct(String productId);
    List<Product> getAllProducts();
    void updateProduct(String productId, String newName, double newPrice, int newStock);
    void deleteProduct(String productId);
    void addToCart(String productId, int quantity);
}
