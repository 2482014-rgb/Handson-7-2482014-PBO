public class Product {
    String productId;
    String name;
    String description;
    double price;
    String category;
    int inStock;
    String supplier;

    // Constructor 1: Full parameter
    public Product(String productId, String name, String description, double price, String category, int inStock, String supplier) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.inStock = inStock;
        this.supplier = supplier;
    }

    // Constructor 2: Essential only
    public Product(String productId, String name, double price) {
        this(productId, name, "No description", price, "Uncategorized", 0, "Unknown");
    }

    // Constructor 3: Copy constructor
    public Product(Product other) {
        this(other.productId, other.name, other.description, other.price, other.category, other.inStock, other.supplier);
    }

    // Constructor 4: Default constructor
    public Product() {
        this("Unknown", "Unknown Product", "No description", 0.0, "Uncategorized", 0, "Unknown");
    }

    public void displayProductInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: Rp" + price);
        System.out.println("Category: " + category);
        System.out.println("Stock: " + inStock);
        System.out.println("Supplier: " + supplier);
        System.out.println("-----------------------------");
    }
}

