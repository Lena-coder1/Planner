/**
 * Planner
 * Group 10 Members: Divine, Krishna, Lena & Lynneth
 * This is a simple planner application that allows users to add, edit, and delete tasks.
 */
package planner;

import java.util.*;

public class Planner {

    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    public static void addTasks() {
        System.out.print("How many tasks would you like to enter: ");
        int numTasks;

        try {
            numTasks = scan.nextInt();
            scan.nextLine();
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Invalid number entered.");
            scan.nextLine();
            System.out.println();
            return;
        }

        if (numTasks > 0) {
            for (int i = 0; i < numTasks; i++) {
                System.out.print("Please enter task #" + (i + 1) + ": ");
                String newTask = scan.nextLine();
                tasks.add(newTask);
                System.out.println();
            }

            System.out.println("\nYour Task List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ".) " + tasks.get(i));
            }
            System.out.println("Tasks added successfully!"); // Moved the success message here
            System.out.println();
        } else {
            System.out.println("Number must be greater than 0. Try again.");
            System.out.println();
        }
    }

    public static void editTask() { // This module edits the task the user wants to change
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to edit.");
            System.out.println();
            return;
        }

        System.out.println("Your Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
        System.out.println();

        System.out.print("Please enter the task number you want to edit:");
        int selection = scan.nextInt();
        scan.nextLine();
        System.out.println();

        if (selection >= 1 && selection <= tasks.size()) {
            System.out.print("Edit task here:");
            String editedTask = scan.nextLine();
            tasks.set(selection - 1, editedTask);
            System.out.println();
        } else {
            System.out.println("Invalid number entered.");
            System.out.println();
        }

        System.out.println("Updated tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + "." + tasks.get(i));
        }
        System.out.println();
    }

    public static void deleteTask() // This module deletes the task the user wants to remove
    {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks to delete.");
            System.out.println();
            return;
        }

        System.out.println("Your Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
        System.out.println();

        System.out.print("Please enter the task number you want to delete: ");
        int selection = scan.nextInt();
        scan.nextLine();
        System.out.println();

        if (selection >= 1 && selection <= tasks.size()) {
            String removed = tasks.remove(selection - 1);
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Invalid number entered.");
        }
    }

    public static void mainMenu() { // This module displays the main menu and handles user input
        boolean exit = false;
        while (!exit) {
            System.out.println("\n----- Study Planner Menu -----");
            System.out.println("1. Add a task");
            System.out.println("2. Modify a task");
            System.out.println("3. Remove a completed task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addTasks();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    System.out.println("Thank you for using the study planner, goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) { // Runs the planner application using all the modules
        System.out.println("\nWelcome to the Planner!");
        mainMenu();
        scan.close();
    }
}
