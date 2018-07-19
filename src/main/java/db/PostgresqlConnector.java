package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnector
{
    private static final String driver = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost/to_dos";
    private static final String user = "to_dos_admin";
    private static final String password = "todosadmin";

    private static Connection connection = null;

    private PostgresqlConnector() {

    }

    public static Connection getConnection() {
        if (connection == null)
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to the PostgreSQL server successfully.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Driver is missing: " + driver);
                System.out.println(e.getMessage());
            }

        return connection;
    }
}
