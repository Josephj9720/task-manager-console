package dev.jordanjoseph.taskmanager;

import dev.jordanjoseph.taskmanager.model.Task;
import dev.jordanjoseph.taskmanager.service.TaskServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskTest {
    private static TaskServiceImpl taskService;

    @BeforeAll
    static void setUp() {
        taskService = new TaskServiceImpl();
    }

    @Test
    void testCreateTest() {
        for(int i = 0; i < 5; i++) {
            taskService.createTask("Test Task " + i, "testing", LocalDate.now());
        }
    }

    @Test
    void testMarkCompleted() {
        taskService.markCompleted(2L);
    }

    @Test
    void testDeleteTask() {
        taskService.deleteTask(1L);
    }

    @Test
    void testListTasks() {
        List<Task> tasks = taskService.listTasks();
        for(Task task : tasks) {
            assertNotNull(task);
        }
    }




}

