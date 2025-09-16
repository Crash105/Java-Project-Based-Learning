package com.example.todolistmanager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoListManager<String> toDoListManager = new TodoListManager<>(); // Managing String tasks
        String command;

        do {
            System.out.println("\nEnter a command (add/view/remove/complete/save/load/exit):");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    try {
                        System.out.println("Enter the task:");
                        String taskDescription = scanner.nextLine();
                        System.out.println("Enter the priority (1-High, 2-Medium, 3-Low):");
                        int priority = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        if (priority < 1 || priority > 3) {
                            throw new IllegalArgumentException("Priority must be between 1 and 3.");
                        }
                        System.out.println("Enter the Category (1-Work, 2-Personal");
                        int category = scanner.nextInt();
                        scanner.nextLine();
                        if (category < 1 || category > 2) {
                            throw new IllegalArgumentException("Category must be between 1 or 2.");
                        }
                        System.out.println("Enter the deadline (YYYY-MM-DD):");
                        String deadlineInput = scanner.nextLine();
                        LocalDate deadline = LocalDate.parse(deadlineInput);
                        toDoListManager.addTask(taskDescription, priority, category, deadline);
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("❌ Invalid input! Please enter a number for priority and category.");
                        scanner.nextLine(); // Clear the invalid input from the scanner
                    } catch (IllegalArgumentException e) {
                        System.out.println("❌ Invalid argument: " + e.getMessage());
                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("❌ Invalid date format! Please use YYYY-MM-DD.");
                    } catch (Exception e) { // A general catch block for any other unexpected errors
                        System.out.println("An unexpected error occurred: " + e.getMessage());
                    }


                    break;
                case "view":
                    toDoListManager.viewTasks();
                    break;
                case "remove":
                    System.out.println("Enter the task number to remove:");
                    int removeTaskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toDoListManager.removeTask(removeTaskNumber);
                    break;
                case "complete":
                    System.out.println("Enter the task number to complete:");
                    int completeTaskNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    toDoListManager.completeTask(completeTaskNumber);
                    break;
                case "save":
                    System.out.println("Enter the filename to save tasks:");
                    String saveFilename = scanner.nextLine();
                    toDoListManager.saveTasksToFile(saveFilename);
                    break;
                case "load":
                    System.out.println("Enter the filename to load tasks:");
                    String loadFilename = scanner.nextLine();
                    toDoListManager.loadTasksFromFile(loadFilename);
                    break;
                case "exit":
                    System.out.println("Thank you for using the To-Do List Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid command. Here are the available commands:");
                    System.out.println("add - Add a new task");
                    System.out.println("view - View all tasks");
                    System.out.println("remove - Remove a task");
                    System.out.println("complete - Mark a task as complete");
                    System.out.println("save - Save tasks to a file");
                    System.out.println("load - Load tasks from a file");
                    System.out.println("exit - Exit the application");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}