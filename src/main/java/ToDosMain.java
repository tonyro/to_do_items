import db.ToDoItemGateway;

public class ToDosMain
{
    public static void main(String[] args) {
        ToDoItemGateway toDoItemGateway = new ToDoItemGateway();
        toDoItemGateway.selectToDoItemsCount();
    }
}
