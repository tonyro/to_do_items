package db;

import model.ToDoItem;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<ToDoItem> findAllToDoItemsByDay (LocalDate day) {
        String sql = "select to_do_id, description, notes, created_dt, updated_dt, alarm_dt, is_done from to_do_item where date_trunc('day', created_dt) = ?";
        List<ToDoItem> toDoItems = new ArrayList<>();
        ResultSet result;

        try {
            PreparedStatement statement = PostgresqlConnector.getConnection().prepareStatement(sql);
            statement.setObject(1, day);

            result = statement.executeQuery();

            while(result.next()) {
                ToDoItem toDoItem = new ToDoItem();
                toDoItem.setId(result.getInt("to_do_id"));
                toDoItem.setDescription(result.getString("description"));
                toDoItem.setNotes(result.getString("notes"));
                toDoItem.setCreatedDate(result.getDate("created_dt"));
                toDoItem.setUpdatedDate(result.getDate("updated_dt"));
                toDoItem.setAlarmDate(result.getDate("alarm_dt"));
                toDoItem.setDone(result.getBoolean("is_done"));

                if (toDoItem.isValid()) {
                    toDoItems.add(toDoItem);
                } else {
                    System.err.println("to_do_item was no valid");
                }
            }

            statement.close();

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return toDoItems;
    }

    public List<ToDoItem> findOpenToDoItemsByDay (Date day) {
        List<ToDoItem> toDoItems = new ArrayList<ToDoItem>();
        String sql = "select id, description, notes, created_dt, updated_dt, alarm_dt, is_done from to_do_item where ";

        return toDoItems;
    }

    public void insert(String description, String notes, LocalDateTime alarmDate) {
        String sql = "insert into to_do_item(description, notes, created_dt, updated_dt, alarm_dt, is_done) values(?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement statement = PostgresqlConnector.getConnection().prepareStatement(sql);
            statement.setString(1, description);
            statement.setString(2, notes);
            statement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            statement.setTimestamp(5, Timestamp.valueOf(alarmDate));
            statement.setBoolean(6, Boolean.FALSE);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
