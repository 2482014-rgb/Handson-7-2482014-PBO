public class Counter {
    private static int globalCount = 0;
    private static final String APP_NAME;

    private int instanceCount;
    private String counterName;

    // Static initialization block
    static {
        APP_NAME = "CounterApp v1.0";
        System.out.println("Static Block: APP_NAME initialized!");
    }

    // Constructor
    public Counter(String name) {
        this.counterName = name;
        this.instanceCount = 1;
        globalCount++;
    }

    // Static methods
    public static int getGlobalCount() {
        return globalCount;
    }

    public static void resetGlobalCount() {
        globalCount = 0;
    }

    public static void displayAppInfo() {
        System.out.println("App Name: " + APP_NAME);
        System.out.println("Global Count saat ini: " + globalCount);
    }

    // Instance methods
    public int getInstanceCount() {
        return instanceCount;
    }

    public void incrementInstance() {
        instanceCount++;
    }

    public void displayCounterInfo() {
        System.out.println(counterName + " - Instance Count: " + instanceCount);
    }
}
