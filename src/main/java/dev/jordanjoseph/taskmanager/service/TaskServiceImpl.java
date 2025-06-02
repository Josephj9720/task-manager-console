package dev.jordanjoseph.taskmanager.service;

import dev.jordanjoseph.taskmanager.dao.TaskDAO;
import dev.jordanjoseph.taskmanager.model.Task;
import dev.jordanjoseph.taskmanager.util.LoggerUtil;

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
    public void markCompleted(Long id) {
        Task task = taskDAO.findById(id);
        if(task != null) {
            task.setCompleted(true);
            taskDAO.update(task);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("The task was not found. Cancelling operation.");
            LoggerUtil.logger.info("Task was not found. Operation: markCompleted");
        }

    }

    @Override
    public void deleteTask(Long id) {
        Task task = taskDAO.findById(id);
        if(task != null) {
            taskDAO.delete(task);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("The task was not found. Cancelling operation.");
            LoggerUtil.logger.info("Task was not found. Operation: deleteTask");
        }

    }
}
