package dev.jordanjoseph.taskmanager;

import dev.jordanjoseph.taskmanager.model.Task;
import dev.jordanjoseph.taskmanager.service.TaskServiceImpl;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== List All Tasks ===");
        for(Task task : taskServiceImpl.listTasks()) {
            System.out.println(task);
        }
        System.out.println("=====================");

        System.out.println("=== Create a Task ===");
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Due date (YYYY-MM-DD): ");
        LocalDate dueDate  = LocalDate.parse(scanner.nextLine());

        taskServiceImpl.createTask(title, description, dueDate);

        System.out.println("=====================");



    }
}