package com.example.todolistmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

    public ArrayList<T> getTasks() {

        return tasks;
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

    public void removeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            System.out.println("Task removed: " + tasks.get(index - 1));
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void completeTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            System.out.println("Task completed: " + tasks.get(index - 1));
            tasks.remove(index - 1);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void saveTasksToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (T task : tasks) {
                writer.write(task.toString() + "\n");
            }
            System.out.println("Tasks saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasksFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String task;
            while ((task = reader.readLine()) != null) {
                addTask((T) task); // Add each task to the list

            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }
}