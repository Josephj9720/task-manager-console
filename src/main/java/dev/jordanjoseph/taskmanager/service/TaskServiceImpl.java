package dev.jordanjoseph.taskmanager.service;

import dev.jordanjoseph.taskmanager.dao.TaskDAO;
import dev.jordanjoseph.taskmanager.model.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskServiceImpl implements TaskService {

    private final TaskDAO taskDAO;

    public TaskServiceImpl() {
        this.taskDAO = new TaskDAO();
    }

    @Override
    public void createTask(String title, String description, LocalDate dueDate) {
        Task task = new Task(title, description, dueDate);
        taskDAO.save(task);
        System.out.println("Task created successfully.");
    }

    @Override
    public List<Task> listTasks() {
        return taskDAO.findAll();
    }

    @Override
    public void markCompleted(int id) {

    }

    @Override
    public void deleteTask(int id) {

    }
}
