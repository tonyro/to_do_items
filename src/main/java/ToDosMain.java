import db.ToDoItemGateway;

import java.time.LocalDate;
import java.util.Date;

public class ToDosMain
{
    public static void main(String[] args) {
        ToDoItemGateway toDoItemGateway = new ToDoItemGateway();
        LocalDate day = LocalDate.of(2018, 7, 19);

//        toDoItemGateway.insert("To do this", "Need to do this", new Date());
//        toDoItemGateway.insert("To do that", "Need to do that", new Date());
//        toDoItemGateway.insert("To do all", "Need to do all", new Date());
//
//
        toDoItemGateway.findAllToDoItemsByDay(day);

    }
}
