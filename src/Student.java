public class Student {
    private static String universityName;
    private static int totalStudents = 0;

    private String studentId;
    private String name;
    private String major;
    private double gpa;

    public Student(String studentId, String name, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        totalStudents++;
    }

    // Static methods
    public static int getTotalStudents() {
        return totalStudents;
    }

    public static void setUniversityName(String name) {
        universityName = name;
    }

    public static String getUniversityName() {
        return universityName;
    }

    // Instance methods
    public void updateGPA(double newGPA) {
        this.gpa = newGPA;
    }

    public void displayStudentInfo() {
        System.out.println("[" + studentId + "] " + name + " - " + major);
        System.out.println("Universitas: " + universityName);
        System.out.println("GPA: " + gpa);
        System.out.println("Honor: " + (isHonorStudent() ? "Ya" : "Tidak"));
        System.out.println();
    }

    public boolean isHonorStudent() {
        return gpa >= 3.5;
    }
}
