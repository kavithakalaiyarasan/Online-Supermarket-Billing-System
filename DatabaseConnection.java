package SupermarketSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/supermarketbilling"; // Update with your DB name
    private static final String USER = "root"; // Update with your DB username
    private static final String PASSWORD = "1226"; // Update with your DB password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
