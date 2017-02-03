package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

//Adipisicing

public class SortTodosTest {
    @Test
    public void sortTodosByConstaints() throws IOException {
        TodoController todoController = new TodoController();
        Todo[] allTodos = todoController.listTodos(new HashMap<>());
        Todo[] todosSortedByOwner = todoController.sortTodos(allTodos, "owner");
        assertEquals("Incorrect ordering if constaint is owner (first element wrong)", "588959856f0b82ee93cd93eb",todosSortedByOwner[0]._id);
        assertEquals("Incorrect ordering if constaint is owner (last element wrong)", "5889598507bf610948f8fb64",todosSortedByOwner[299]._id);
        Todo[] todosSortedByBody = todoController.sortTodos(allTodos, "body");
        assertEquals("Incorrect ordering if constaint is body (first element wrong)", "58895985d0d57d81513889dc",todosSortedByBody[0]._id);
        assertEquals("Incorrect ordering if constaint is body (last element wrong)", "588959851c339989d49f0f42",todosSortedByBody[299]._id);
        Todo[] todosSortedByStatus = todoController.sortTodos(allTodos, "status");
        assertEquals("Incorrect ordering if constaint is status (first element wrong)", "58895985a22c04e761776d54",todosSortedByStatus[0]._id);
        assertEquals("Incorrect ordering if constaint is status (last element wrong)", "58895985a69d6afde00af172",todosSortedByStatus[299]._id);
        Todo[] todosSortedByCategory = todoController.sortTodos(allTodos, "category");
        assertEquals("Incorrect ordering if constaint is category (first element wrong)", "5889598555fbbad472586a56",todosSortedByCategory[0]._id);
        assertEquals("Incorrect ordering if constaint is category (last element wrong)", "5889598507bf610948f8fb64",todosSortedByCategory[299]._id);
    }

    @Test
    public void sortTodosWithTodoSort() throws IOException {
        TodoController todoController = new TodoController();
        Map<String, String[]> queryParams = new HashMap<>();
        queryParams.put("orderBy", new String[] {"owner"});
        Todo[] todosSortedByOwner = todoController.listTodos(queryParams);
        assertEquals("Incorrect ordering if constaint is owner (first element wrong)", "588959856f0b82ee93cd93eb",todosSortedByOwner[0]._id);
        assertEquals("Incorrect ordering if constaint is owner (last element wrong)", "5889598507bf610948f8fb64",todosSortedByOwner[299]._id);

        queryParams.put("orderBy", new String[] {"body"});
        Todo[] todosSortedByBody = todoController.listTodos(queryParams);
        assertEquals("Incorrect ordering if constaint is body (first element wrong)", "58895985d0d57d81513889dc",todosSortedByBody[0]._id);
        assertEquals("Incorrect ordering if constaint is body (last element wrong)", "588959851c339989d49f0f42",todosSortedByBody[299]._id);

        queryParams.put("orderBy", new String[] {"status"});
        Todo[] todosSortedByStatus = todoController.listTodos(queryParams);
        assertEquals("Incorrect ordering if constaint is status (first element wrong)", "58895985a22c04e761776d54",todosSortedByStatus[0]._id);
        assertEquals("Incorrect ordering if constaint is status (last element wrong)", "58895985a69d6afde00af172",todosSortedByStatus[299]._id);

        queryParams.put("orderBy", new String[] {"category"});
        Todo[] todosSortedByCategory = todoController.listTodos(queryParams);
        assertEquals("Incorrect ordering if constaint is catagory (first element wrong)", "5889598555fbbad472586a56",todosSortedByCategory[0]._id);
        assertEquals("Incorrect ordering if constaint is catagory (last element wrong)", "5889598507bf610948f8fb64",todosSortedByCategory[299]._id);
    }
}
