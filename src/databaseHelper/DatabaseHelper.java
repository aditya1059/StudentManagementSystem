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
            System.out.println("Problem in Loading MySql Driver "+e.getMessage());
        }
    }
        public static Connection getConnection() {
            try {
                System.out.println("Connecting to Database...");
                Connection c = DriverManager.getConnection(url, user, password);
                System.out.println("Database connected successfully");
                return c;
            }
            catch (SQLException e){
                System.out.println("Failed to create connection with Database "+e.getMessage());
            }
            return null;
        }
}
