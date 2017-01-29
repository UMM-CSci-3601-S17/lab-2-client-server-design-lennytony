package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class TodoController {
    private Todo[] todos;

    public TodoController() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        todos = gson.fromJson(reader, Todo[].class);
    }

    // List users
    public Todo[] listTodos(Map<String, String[]> queryParams) {
        Todo[] filteredTodos = todos;

        // Filter status if defined
        if(queryParams.containsKey("status")) {
            // Get the string value - complete or incomplete
            String status = queryParams.get("status")[0];
            filteredTodos = filterTodosByStatus(filteredTodos, status);
        }

        // Filter limit if defined
        if(queryParams.containsKey("limit")) {
            // Get the value of the query
            int limit = Integer.parseInt(queryParams.get("limit")[0]);
            filteredTodos = limitTodos(filteredTodos, limit);
        }

        return filteredTodos;
    }

    public Todo[] limitTodos(Todo[] filteredTodos, int limit) {
        return Arrays.copyOf(filteredTodos, limit);
    }

    public Todo[] filterTodosByStatus(Todo[] filteredTodos, String status) {
        return null;
    }

    public Todo[] filterTodosByContains(Todo[] filteredTodos, String contain) {
        return null;
    }

    // Filter users by age
//    public Todo[] filterUsersByAge(Todo[] filteredUsers, int age) {
//        return Arrays.stream(filteredUsers).filter(x -> x.age == age).toArray(User[]::new);
//    }

    // Get a single user
//    public Todo getUser(String id) {
//        return Arrays.stream(users).filter(x -> x._id.equals(id)).findFirst().orElse(null);
//    }
}
