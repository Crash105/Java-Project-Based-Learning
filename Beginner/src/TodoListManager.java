import java.util.ArrayList;

public class TodoListManager<T> {
    private ArrayList<T> tasks;

    public TodoListManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(T task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void removeTask(int index) throws TaskNotFoundException {
        if (index < 1 || index > tasks.size()) {
            throw new TaskNotFoundException("Invalid task number.");

        }
        System.out.println("Task removed: " + tasks.get(index - 1));
        tasks.remove(index - 1);
    }

    public void completeTask(int index) throws TaskNotFoundException {
        if (index < 1 || index > tasks.size()) {
            throw new TaskNotFoundException("Invalid task number.");

        }
        System.out.println("Task Complete: " + tasks.get(index - 1));
        tasks.remove(index - 1);
    }
}