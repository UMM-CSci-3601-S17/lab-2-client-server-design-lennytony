package umm3601.todo;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class LimitTodosBySpec {
    @Test
    public void filterUsersByAge() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] limit3Todos = todoController.limitTodos(allTodos, 3);
        assertEquals("Incorrect number of todos", 3, limit3Todos.length);
        Todo[] limit7Todos = todoController.limitTodos(allTodos, 7);
        assertEquals("Incorrect number of todos", 7, limit7Todos.length);
    }

    @Test
    public void listUsersWithAgeFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("limit", new String[] {"3"});
        Todo[] limitThreeTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos", 3, limitThreeTodos.length);
        queryParams.put("limit", new String[] {"7"});
        Todo[] litmit7Users = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of todos", 7, litmit7Users.length);
    }

}
