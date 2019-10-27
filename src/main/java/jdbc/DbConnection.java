package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private final static String DB_URL = "jdbc:mysql://localhost:3306/girrafe";
    private final static String USER_NAME = "root";
    private final static String USER_PASS = "myPass";

    static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER_NAME, USER_PASS);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
