import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}

class InventoryManagementSystem {
    private Map<Integer, Product> products;

    public InventoryManagementSystem() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.productId, product);
    }

    public void updateProduct(int productId, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.quantity = quantity;
            product.price = price;
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        Product product1 = new Product(1, "Laptop", 10, 1500);
        Product product2 = new Product(2, "Smartphone", 20, 500);

        inventory.addProduct(product1);
        inventory.addProduct(product2);
        inventory.updateProduct(1, 15, 1450);
        inventory.deleteProduct(2);
    }
}
