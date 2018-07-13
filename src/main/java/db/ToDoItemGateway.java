package db;

import java.sql.ResultSet;
import java.sql.Statement;

public class ToDoItemGateway
{
    public void findAll() {
        String sql = "select * from to_do_item;";

        try {
            Statement statement = PostgresqlConnector.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            rs.next();
            System.out.println(rs.getInt(1));

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
