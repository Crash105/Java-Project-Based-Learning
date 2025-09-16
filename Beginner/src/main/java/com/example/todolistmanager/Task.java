package com.example.todolistmanager;

import java.time.LocalDate;

public class Task {
    private String description;
    private int priority;
    private int category;
    private LocalDate deadline;


    public Task(String description, int priority, int category, LocalDate deadline) {
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.deadline = deadline;

    }

    public String geDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public int getCategory() {
        return category;
    }
    public LocalDate getDate() {
        return deadline;
    }


    @Override
    public String toString() {
        return priority + "," + description + "," + category + "," + deadline;
    }
}