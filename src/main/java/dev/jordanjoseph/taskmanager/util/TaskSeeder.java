package dev.jordanjoseph.taskmanager.util;

import dev.jordanjoseph.taskmanager.dao.TaskDAO;
import dev.jordanjoseph.taskmanager.model.Task;

import java.time.LocalDate;
import java.util.List;

public class TaskSeeder {

    private TaskDAO taskDAO;

    public TaskSeeder() { this.taskDAO = new TaskDAO(); }

    private void clearDB() {
        List<Task> tasks = taskDAO.findAll();
        for(Task task : tasks) {
            taskDAO.delete(task);
        }
    }

    private void create(int numberOfTasks) {
        for(int i = 1; i <= numberOfTasks; i++) {
            Task task = new Task("task " + i, "This is sample task #" + i, LocalDate.now());
            taskDAO.save(task);
        }
    }

    public void run() {
        clearDB();
        create(10);
    }

    public void run(int numberOfTasks) {
        clearDB();
        create(numberOfTasks);
    }

}
