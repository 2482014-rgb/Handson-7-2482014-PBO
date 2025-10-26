public class ConstructorPractice {
    public static void main(String[] args) {
        System.out.println("=== DEFAULT VS CUSTOM CONSTRUCTOR ===");

        // Latihan 1: Default constructor
        SimpleClass s1 = new SimpleClass();
        s1.showInfo();

        System.out.println("\n=== CONSTRUCTOR OVERLOADING ===");

        // Latihan 2: Constructor overloading
        Product p1 = new Product();
        Product p2 = new Product("P001", "Laptop", 12000000);
        Product p3 = new Product("P002", "Mouse", "Gaming Mouse", 250000, "Elektronik", 10, "TechSupplier");

        p1.displayProductInfo();
        p2.displayProductInfo();
        p3.displayProductInfo();

        System.out.println("\n=== KEYWORD THIS & CONSTRUCTOR CHAINING ===");

        // Latihan 3: Employee constructor chaining
        Employee e1 = new Employee();
        Employee e2 = new Employee("E001", "John", "Doe");
        Employee e3 = new Employee("E002", "Jane", "Smith", "IT", "Programmer", 7500000);

        e1.getEmployeeInfo();
        e2.getEmployeeInfo();
        e3.getEmployeeInfo();

        System.out.println("\n=== INITIALIZATION ORDER ===");
        InitializationDemo demo = new InitializationDemo();
    }
}
