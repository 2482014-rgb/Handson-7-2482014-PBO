public class StaticVsInstancePractice {
    public static void main(String[] args) {
        /*
         * PRAKTIK HANDS-ON: Static vs Instance
         */

        // ===== STATIC VARIABLES DEMO =====
        System.out.println("=== STATIC VARIABLES DEMO ===");

        Counter c1 = new Counter("Counter 1");
        Counter c2 = new Counter("Counter 2");
        Counter c3 = new Counter("Counter 3");

        c1.displayCounterInfo();
        c2.displayCounterInfo();
        c3.displayCounterInfo();

        System.out.println("Global Count: " + Counter.getGlobalCount());

        // ===== STATIC METHODS DEMO =====
        System.out.println("\n=== STATIC METHODS DEMO ===");
        double area = MathUtils.calculateCircleArea(5);
        System.out.println("Area lingkaran r=5: " + area);

        boolean prime = MathUtils.isPrime(7);
        System.out.println("Apakah 7 bilangan prima? " + prime);

        // ===== STATIC VS INSTANCE COMPARISON =====
        System.out.println("\n=== STATIC VS INSTANCE COMPARISON ===");
        c1.incrementInstance();
        c1.displayCounterInfo();
        System.out.println("Global Count: " + Counter.getGlobalCount());

        // ===== STATIC INITIALIZATION =====
        System.out.println("\n=== STATIC INITIALIZATION ===");
        Counter.displayAppInfo();

        // ===== BEST PRACTICES =====
        System.out.println("\n=== BEST PRACTICES ===");
        Student.setUniversityName("Universitas Indonesia");
        Student s1 = new Student("S001", "Budi", "Informatika", 3.8);
        Student s2 = new Student("S002", "Siti", "Matematika", 3.5);

        s1.displayStudentInfo();
        s2.displayStudentInfo();
        System.out.println("Total Students: " + Student.getTotalStudents());
    }
}
