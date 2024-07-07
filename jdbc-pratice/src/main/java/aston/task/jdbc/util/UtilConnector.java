package aston.task.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilConnector {
    // реализуйте настройку соединения с БД

    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgres";
    static final String JDBC_DRIVER = "org.postgresql.Driver";

    public static Connection getConnectionToDB() {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
         }

        Connection connection = null;
        try {
            connection = DriverManager
                    .getConnection(DB_URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
        } else {
            System.out.println("Failed to make connection to database");
        }
        return connection;
    }
}
