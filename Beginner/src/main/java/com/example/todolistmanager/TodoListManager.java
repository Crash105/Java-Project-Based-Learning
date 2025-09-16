package com.example.todolistmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TodoListManager<T> {
    private ArrayList<Task> tasks;

    public TodoListManager() {

        tasks = new ArrayList<>();
    }

    public void addTask(String description, int priority, int category, LocalDate deadline) {
        Task newTask = new Task(description, priority, category, deadline);
        tasks.add(newTask);
        System.out.println("Task added: " + description + ", Priority: [" + priority + "], Category: " + category + ", Deadline: " + deadline + ", Tasks Size: " + tasks.size());
    }

    public ArrayList<Task> getTasks() {

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
            for (Task task : tasks) {
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
                String[] parts = task.split(",");

                int priority = Integer.parseInt(parts[0]);
                String description = parts[1];
                int category = Integer.parseInt(parts[2]);
                LocalDate deadline = LocalDate.parse(parts[3]);
                addTask(description, priority, category, deadline);
                 // Add each task to the list

            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
    }

}