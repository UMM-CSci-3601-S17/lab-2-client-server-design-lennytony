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

        // Filter contains if defined
        if(queryParams.containsKey("contains")) {
            String contains = queryParams.get("contains")[0];
            filteredTodos = filterTodosByContains(filteredTodos, contains);
        }

        if(queryParams.containsKey("owner")) {
            // Get the value of the query
            String owner = queryParams.get("owner")[0];
            filteredTodos = filterTodosByOwner(filteredTodos, owner);
        }

        if(queryParams.containsKey("category")) {
            // Get the value of the query
            String category = queryParams.get("category")[0];
            filteredTodos = filterTodosByCategory(filteredTodos, category);
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
        // If the user provides an invalid value, it would be initialized to 'false'
        boolean convertedStatus = status.equals("complete") ? true : false;
        return Arrays.stream(filteredTodos).filter(x -> x.status == convertedStatus).toArray(Todo[]::new);
    }

    public Todo[] filterTodosByContains(Todo[] filteredTodos, String contain) {
        return Arrays.stream(filteredTodos).filter(x -> x.body.contains(contain)).toArray(Todo[]::new);
    }

    public Todo[] filterTodosByOwner(Todo[] filteredTodos, String owner) {
        return Arrays.stream(filteredTodos).filter(x -> x.owner.equals(owner)).toArray(Todo[]::new);
    }

    public Todo[] filterTodosByCategory(Todo[] filteredTodos, String category) {
        return Arrays.stream(filteredTodos).filter(x -> x.category.equals(category)).toArray(Todo[]::new);
    }

    public Todo getTodo(String id) {
        return Arrays.stream(todos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }
}
