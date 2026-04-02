
import java.security.MessageDigest;
import java.sql.*; // New import for database communication

public class RedundancyManager {

    // 1. Connection Details
	static final String DB_URL = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
    static final String USER = "system"; 
    static final String PASS = "123456"; // <--- CHANGE THIS

    // TASK 1: Identification (The Hash)
    public static String generateHash(String input) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes("UTF-8"));
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    // TASK 1: Validation and Appending
    public static void checkAndUpload(String content) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String hash = generateHash(content);

            // Step 1: Check for redundancy (Classification)
            String checkSQL = "SELECT count(*) FROM CloudData WHERE data_hash = ?";
            PreparedStatement pstmt = conn.prepareStatement(checkSQL);
            pstmt.setString(1, hash);
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                // Step 2: Redundancy identified
                System.out.println("ALERT: Redundant data detected. Blocked entry: " + content);
            } else {
                // Step 3: Append unique and verified data
                String insertSQL = "INSERT INTO CloudData (id, data_content, data_hash) VALUES (1, ?, ?)";
                // Note: We use a simple insert for testing
                PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO CloudData (id, data_content, data_hash) VALUES (1, ?, ?)");
                insertStmt.setString(1, content);
                insertStmt.setString(2, hash);
                insertStmt.executeUpdate();
                System.out.println("SUCCESS: Unique data verified and added to cloud.");
            }
        } catch (Exception e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Starting Data Redundancy Removal System ---");
        // Test with the same string twice to see the validation in action
        checkAndUpload("Project Alpha Data");
        checkAndUpload("Project Alpha Data"); 
    }
}