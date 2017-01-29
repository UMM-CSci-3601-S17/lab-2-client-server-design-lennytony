package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class GetTodoByID {

    @Test
    public void getRoberta() throws IOException {
        TodoController todoController = new TodoController();
        Todo todo = todoController.getTodo("588959855a0ac85fcd7c16bb");
        assertEquals("Incorrect name", "Roberta", todo.owner);
    }

    @Test
    public void getNull() throws IOException {
        TodoController todoController = new TodoController();
        Todo todo = todoController.getTodo("588935f5556f992bf8f37c01");
        assertNull("expected null", todo);
    }
}
