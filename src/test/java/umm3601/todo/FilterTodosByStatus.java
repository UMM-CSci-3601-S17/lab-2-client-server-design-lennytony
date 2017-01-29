package umm3601.todo;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatus {
    @Test
    public void filterTodosByStatus() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] filterCompleteTodos = todoController.filterTodosByStatus(allTodos, "complete");
        assertEquals("Incorrect number of complete todos", 143, filterCompleteTodos.length);
        Todo[] filterIncompleteTodos = todoController.filterTodosByStatus(allTodos, "incomplete");
        assertEquals("Incorrect number of incomplete todos", 157, filterIncompleteTodos.length);
    }

    @Test
    public void listTodosWithStatusFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("status", new String[] {"complete"});
        Todo[] filterCompleteTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of complete todos", 143, filterCompleteTodos.length);
        queryParams.put("status", new String[] {"incomplete"});
        Todo[] filterIncompleteTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of incomplete todos", 157, filterIncompleteTodos.length);
    }
}
