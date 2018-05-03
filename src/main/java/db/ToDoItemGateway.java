package db;

import java.sql.ResultSet;
import java.sql.Statement;

public class ToDoItemGateway
{
    private static final String SELECT_ITEMS_WITH_CONDITIONS_QUERY = "select to_do_id, description, notes, created_dt, updated_dt, alarm_dt, is_done from to_do_item {};";
    private static final String SELECT_COUNT_OF_ITEMS_QUERY = "select count(*) from to_do_item;";

    public void selectToDoItemsCount() {
        try {
            Statement statement = PostgresqlConnector.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(SELECT_COUNT_OF_ITEMS_QUERY);

            rs.next();
            System.out.println(rs.getInt(1));

        } catch (Exception e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
}
