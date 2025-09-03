package com.example.todolistmanager;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TodoListManagerTest {
    private TodoListManager<String> manager;

    @Before
    public void setUp() {
        manager = new TodoListManager<>();
    }

    @Test
    public void testAddTask() {
        manager.addTask("Task 1");
        assertEquals(1, manager.getTasks().size()); // Check if task is added
    }

    @Test
    public void testRemoveTask() {
        manager.addTask("Task 1");
        manager.removeTask(1);
        assertEquals(0, manager.getTasks().size()); // Check if task is removed
    }

    @Test
    public void testCompleteTask() {
        manager.addTask("Task 1");
        manager.completeTask(1);
        assertEquals(0, manager.getTasks().size()); // Check if task is completed and removed
    }
}