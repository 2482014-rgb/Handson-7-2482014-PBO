import java.time.LocalDate;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private LocalDate joinDate;
    private MembershipType membershipType;
    private boolean isActive;

    // static
    private static int totalMembers = 0;
    public static final int MAX_BOOKS_ALLOWED = 5; // default, library may override

    // Constructor
    public Member(String memberId, String name, String email, String phone, String address, MembershipType membershipType) {
        if (memberId == null || memberId.trim().isEmpty()) throw new IllegalArgumentException("memberId invalid");
        if (!LibraryUtils.isValidEmail(email)) throw new IllegalArgumentException("email invalid");
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.joinDate = LocalDate.now();
        this.membershipType = membershipType == null ? MembershipType.PUBLIC : membershipType;
        this.isActive = true;
        totalMembers++;
    }

    // Getters & setters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public void setName(String name) { if (name != null && !name.trim().isEmpty()) this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { if (LibraryUtils.isValidEmail(email)) this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public LocalDate getJoinDate() { return joinDate; }
    public MembershipType getMembershipType() { return membershipType; }
    public void upgradeMembership(MembershipType newType) {
        if (newType != null) this.membershipType = newType;
    }
    public boolean isActive() { return isActive; }
    public void deactivate() { this.isActive = false; }
    public void activate() { this.isActive = true; }

    // Business methods
    public boolean canBorrowMore(int currentBorrowed, int libraryMaxPerMember) {
        int allowed = libraryMaxPerMember > 0 ? libraryMaxPerMember : MAX_BOOKS_ALLOWED;
        return (currentBorrowed < allowed) && isActive;
    }

    public int calculateMembershipDuration() {
        return LocalDate.now().getYear() - joinDate.getYear();
    }

    public static int getTotalMembers() { return totalMembers; }

    public void displayMemberInfo() {
        System.out.println("[" + memberId + "] " + name + " | " + email + " | Type: " + membershipType + " | Active: " + isActive);
    }
}
