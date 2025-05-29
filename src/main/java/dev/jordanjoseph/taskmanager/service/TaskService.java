package dev.jordanjoseph.taskmanager.service;

import dev.jordanjoseph.taskmanager.dao.TaskDAO;
import dev.jordanjoseph.taskmanager.model.Task;

import java.time.LocalDate;

public class TaskService {

    private final TaskDAO taskDAO;

    public TaskService() {
        this.taskDAO = new TaskDAO();
    }

    public void createTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(title, description, dueDate);
        taskDAO.createTask(task);
        System.out.println("Task created successfully.");
    }

}
