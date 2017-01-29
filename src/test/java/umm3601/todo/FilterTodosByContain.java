package umm3601.todo;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByContain {
    @Test
    public void filterTodosByContains() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] filterBananaTodos = todoController.filterTodosByContains(allTodos, "banana");
        assertEquals("Incorrect number bananas in the bodies of todos", 0, filterBananaTodos.length);
        Todo[] filterConsecteturTodos = todoController.filterTodosByContains(allTodos, "consectetur");
        assertEquals("Incorrect number of consectetur in the bodies todos", 85, filterConsecteturTodos.length);
    }

    @Test
    public void listTodosWithContainsFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("contains", new String[] {"banana"});
        Todo[] filterBananaTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number bananas in the bodies of todos", 0, filterBananaTodos.length);
        queryParams.put("contains", new String[] {"consectetur"});
        Todo[] filterConsecteturTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of consectetur in the bodies todos", 85, filterConsecteturTodos.length);
    }
}
