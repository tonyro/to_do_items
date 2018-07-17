package db;

import java.sql.*;
import java.util.Date;

public class ToDoItemGateway {
    //TODO: improve catching of exceptions
    //TODO: add logging

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
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void insert(String description, String notes, Date alarmDate) {
        String sql = "insert into to_do_item(description, notes, created_dt, updated_dt, alarm_dt, is_done) values(?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement statement = PostgresqlConnector.getConnection().prepareStatement(sql);
            statement.setString(1, description);
            statement.setString(2, notes);
            statement.setTimestamp(3, new Timestamp(new Date().getTime()));
            statement.setTimestamp(4, new Timestamp(new Date().getTime()));
            statement.setTimestamp(5, new Timestamp(alarmDate.getTime()));
            statement.setBoolean(6, Boolean.FALSE);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
