public class AccessModifierDemo {
    private String privateField = "Private";
    protected String protectedField = "Protected";
    String defaultField = "Default";
    public String publicField = "Public";

    private void privateMethod() {
        System.out.println("Private method called");
    }

    protected void protectedMethod() {
        System.out.println("Protected method called");
    }

    void defaultMethod() {
        System.out.println("Default method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    // Test semua akses dari dalam class ini
    public void testAccess() {
        System.out.println(privateField);
        System.out.println(protectedField);
        System.out.println(defaultField);
        System.out.println(publicField);

        privateMethod();
        protectedMethod();
        defaultMethod();
        publicMethod();
    }
}

