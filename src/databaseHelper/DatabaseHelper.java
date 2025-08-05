package databaseHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
        private static final String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        private static final String user = "JDBC";
        private static final String password = "@123";

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }
}
