package dev.jordanjoseph.taskmanager;

import dev.jordanjoseph.taskmanager.model.Task;
import dev.jordanjoseph.taskmanager.service.TaskServiceImpl;
import dev.jordanjoseph.taskmanager.util.TaskSeeder;

import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TaskServiceImpl taskServiceImpl = new TaskServiceImpl();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        System.out.print("==========================================");
        System.out.print(" Task Manager Application ");
        System.out.println("==========================================");

        while(choice != 0) {
            System.out.print("=================================================");
            System.out.print(" List Tasks ");
            System.out.println("=================================================");

            for(Task task : taskServiceImpl.listTasks()) {
                System.out.println(task);
            }

            while(choice < 0 || choice > 3) {

                System.out.print("=================================================");
                System.out.print(" Operations ");
                System.out.println("=================================================");

                System.out.println("[1] Create a Task");
                System.out.println("[2] Mark a Task as Completed");
                System.out.println("[3] Delete a Task");
                System.out.println("\n[0] Exit");

                System.out.print("=================================================");
                System.out.print("============");
                System.out.println("=================================================");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Please input a whole number!");
                    System.out.println("Please use the specified options.");
                }
            }

            switch(choice) {
                case 1:
                    System.out.print("================================================");
                    System.out.print(" Create  Task ");
                    System.out.println("================================================");
                    try {
                        System.out.print("Task Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Task Description: ");
                        String description = scanner.nextLine();
                        System.out.print("Due Date - YYYY-MM-DD: ");
                        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                        taskServiceImpl.createTask(title, description, dueDate);

                    } catch (Exception e) {
                        System.out.println("An error occurred during Task Creation. Try again.");
                    }

                    choice = -1;
                    break;

                case 2:
                    System.out.print("==========================================");
                    System.out.print(" Mark a Task as Completed ");
                    System.out.println("==========================================");
                    System.out.print("Task Id: ");
                    long toCompletedId;
                    while(true) {
                        try {
                            toCompletedId = Long.parseLong(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Please input a whole number!");
                        }
                    }
                    taskServiceImpl.markCompleted(toCompletedId);
                    choice = -1;
                    break;

                case 3:
                    System.out.print("=======================================================");
                    System.out.print(" Delete  Task ");
                    System.out.println("=======================================================");
                    System.out.print("Task Id: ");
                    long toDeleteId;
                    while(true) {
                        try {
                            toDeleteId = Long.parseLong(scanner.nextLine());
                            break;
                        } catch (Exception e) {
                            System.out.println("Please input a whole number!");
                        }
                    }
                    taskServiceImpl.deleteTask(toDeleteId);
                    choice = -1;
                    break;

                default:
                    break;
            }

        }

    }

    public void selectOperation(int choice) {

    }

}