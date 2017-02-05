package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByCategory {
    @Test
    public void filterTodosByCategory() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] filterSoftDTodos = todoController.filterTodosByCategory(allTodos, "software design");
        assertEquals("Incorrect number todos for software design", 74, filterSoftDTodos.length);
        Todo[] filterMcPheeTodos = todoController.filterTodosByCategory(allTodos, "McPhee");
        assertEquals("Incorrect number of McPhees", 0, filterMcPheeTodos.length);
    }

    @Test
    public void listTodosWithCategoryFilter() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("category", new String[] {"software design"});
        Todo[] filterSoftDTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number todos for software design", 74, filterSoftDTodos.length);
        queryParams.put("category", new String[] {"McPhee"});
        Todo[] filterMcPheeTodos = todoController.listTodos(queryParams);
        assertEquals("Incorrect number of McPhees", 0, filterMcPheeTodos.length);
    }
}
