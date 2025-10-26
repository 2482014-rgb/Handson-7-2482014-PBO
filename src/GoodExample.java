public class GoodExample {
    private String name;
    private int age;
    private double salary;
    private String email;

    public GoodExample(String name, int age, double salary, String email) {
        setName(name);
        setAge(age);
        setSalary(salary);
        setEmail(email);
    }

    // Getter
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getEmail() { return email; }

    // Setter dengan validasi
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Nama tidak boleh kosong!");
        } else {
            this.name = name;
        }
    }

    public void setAge(int age) {
        if (age < 17 || age > 65) {
            System.out.println("❌ Umur harus antara 17-65 tahun.");
        } else {
            this.age = age;
        }
    }

    public void setSalary(double salary) {
        if (salary <= 0) {
            System.out.println("❌ Gaji harus lebih besar dari 0.");
        } else {
            this.salary = salary;
        }
    }

    public void setEmail(String email) {
        if (!validateEmail(email)) {
            System.out.println("❌ Format email tidak valid.");
        } else {
            this.email = email;
        }
    }

    private boolean validateEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public boolean isRetirementAge() {
        return age >= 60;
    }

    public double calculateTax() {
        return salary * 0.1;
    }

    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        System.out.println("Email: " + email);
        System.out.println("Tax: " + calculateTax());
    }
}
