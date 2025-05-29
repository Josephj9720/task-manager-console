package dev.jordanjoseph.taskmanager;

import dev.jordanjoseph.taskmanager.service.TaskService;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TaskService taskService = new TaskService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create a Task ===");
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Due date (YYYY-MM-DD): ");
        LocalDate dueDate  = LocalDate.parse(scanner.nextLine());

        taskService.createTask(title, description, dueDate);

    }
}