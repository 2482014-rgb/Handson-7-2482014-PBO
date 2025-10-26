public class DatabaseConnection {
    private static int maxConnections = 3;
    private static int activeConnections = 0;
    private static boolean isInitialized;

    private String connectionId;
    private boolean isConnected;
    private String database;

    static {
        isInitialized = true;
        System.out.println("DatabaseConnection pool initialized.");
    }

    private DatabaseConnection(String id, String db) {
        this.connectionId = id;
        this.database = db;
        this.isConnected = true;
    }

    public static DatabaseConnection getConnection() {
        if (activeConnections < maxConnections) {
            activeConnections++;
            return new DatabaseConnection("Conn-" + activeConnections, "MainDB");
        } else {
            System.out.println("Connection pool penuh!");
            return null;
        }
    }

    public static void closeAllConnections() {
        activeConnections = 0;
        System.out.println("Semua koneksi ditutup.");
    }

    public static int getActiveConnectionCount() {
        return activeConnections;
    }

    public void executeQuery(String query) {
        if (isConnected) {
            System.out.println("[" + connectionId + "] Eksekusi: " + query);
        } else {
            System.out.println("Koneksi tidak aktif!");
        }
    }

    public void disconnect() {
        if (isConnected) {
            isConnected = false;
            activeConnections--;
            System.out.println(connectionId + " telah diputus.");
        }
    }
}
