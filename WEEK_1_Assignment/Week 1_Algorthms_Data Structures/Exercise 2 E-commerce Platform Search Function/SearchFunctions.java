class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class SearchFunctions {

    public static Product linearSearch(Product[] products, String target) {
        for (Product product : products) {
            if (product.productName.equals(target)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {
        int left = 0;
        int right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productName.equals(target)) {
                return products[mid];
            } else if (products[mid].productName.compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Tablet", "Electronics")
        };

        // Sort products for binary search
        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        System.out.println(linearSearch(products, "Smartphone"));
        System.out.println(binarySearch(products, "Smartphone"));
    }
}
