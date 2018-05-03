package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnector
{
    private static final String url = "jdbc:postgresql://localhost/to_dos";
    private static final String user = "to_do_user";
    private static final String password = "to_do_user";

    private static Connection connection = null;

    private PostgresqlConnector() {

    }

    public static Connection getConnection() {
        if (connection == null)
            try {
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        return connection;
    }
}
