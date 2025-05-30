package dev.jordanjoseph.taskmanager.service;

import dev.jordanjoseph.taskmanager.model.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    void createTask(String title, String description, LocalDate dueDate);
    List<Task> listTasks();
    void markCompleted(int id);
    void deleteTask(int id);
}
