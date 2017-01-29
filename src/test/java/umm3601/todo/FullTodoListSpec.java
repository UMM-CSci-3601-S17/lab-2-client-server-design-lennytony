package umm3601.todo;

import org.junit.Test;
import umm3601.todo.Todo;
import umm3601.todo.TodoController;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FullTodoListSpec {
    @Test
    public void totalTodoCount() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        assertEquals("Incorrect total number of todos", 300, allTodos.length);
    }

    @Test
    public void firstTodoInFullList() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo firstTodo = allTodos[0];
        String body = "In sunt ex non tempor cillum commodo amet incididunt anim qui commodo quis. Cillum non labore ex sint esse.";
        assertEquals("Incorrect id", "58895985a22c04e761776d54", firstTodo._id);
        assertEquals("Incorrect Owner", "Blanche", firstTodo.owner);
        assertEquals("Incorrect status", false, firstTodo.status);
        assertEquals("Incorrect body", body, firstTodo.body);
        assertEquals("Incorrect category", "software design", firstTodo.category);
    }
}
