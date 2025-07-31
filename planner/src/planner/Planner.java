/**
 * Planner
 * Group 10 Members: Divine, Krishna, Lena & Lynneth
 * This is a simple planner application that allows users to add, edit, and delete tasks.
 */
package planner;

import java.util.*;

public class Planner {

    static ArrayList<String> tasks = new ArrayList<>(); // This ArrayList stores the tasks
    static Scanner scan = new Scanner(System.in);

    public static void addTasks() { // This module adds tasks to the planner
        System.out.print("How many tasks would you like to enter: ");
        int numTasks; // Holds the number of tasks to be added

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
            for (int i = 0; i < numTasks; i++) { // Loop to add the specified number of tasks
                System.out.print("Please enter task #" + (i + 1) + ": ");
                String newTask = scan.nextLine();
                tasks.add(newTask);
                System.out.println();
            }

            System.out.println("\nYour Task List:"); // Display the tasks after adding them
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ".) " + tasks.get(i));
            }
            System.out.println("Tasks added successfully!"); // Confirmation message
            System.out.println();
        } else {
            System.out.println("Number must be greater than 0. Try again."); // Error message for invalid input
            System.out.println();
        }
    }

    public static void editTask() { // This module edits the task the user wants to change
        if (tasks.isEmpty()) { // Check if there are any tasks to edit
            System.out.println("There are no tasks to edit.");
            System.out.println();
            return;
        }

        System.out.println("Your Task List:"); // Display the current tasks
        for (int i = 0; i < tasks.size(); i++) { // Loop through the tasks and print them
            System.out.println((i + 1) + "." + tasks.get(i));
        }
        System.out.println();

        System.out.print("Please enter the task number you want to edit:"); // Prompt user for the task number to edit
        int selection = scan.nextInt(); 
        scan.nextLine();
        System.out.println();

        if (selection >= 1 && selection <= tasks.size()) { // Check if the selection is valid
            System.out.print("Edit task here:"); // Prompt user to change the task
            String editedTask = scan.nextLine(); 
            tasks.set(selection - 1, editedTask);
            System.out.println();
        } else { // If the selection is invalid, print an error message
            System.out.println("Invalid number entered.");
            System.out.println();
        }

        System.out.println("Updated tasks:"); // Display the updated task list
        for (int i = 0; i < tasks.size(); i++) { // Loop through the tasks and print them
            System.out.println(i + 1 + "." + tasks.get(i));
        }
        System.out.println();
    }

    public static void deleteTask() // This module deletes the task the user wants to remove
    {
        if (tasks.isEmpty()) { // Check if there are any tasks to delete
            System.out.println("There are no tasks to delete.");
            System.out.println();
            return;
        }

        System.out.println("Your Task List:"); // Display the current tasks
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
        System.out.println();

        System.out.print("Please enter the task number you want to delete: "); // Prompt user for the task number to delete
        int selection = scan.nextInt();
        scan.nextLine();
        System.out.println();

        if (selection >= 1 && selection <= tasks.size()) { // Check if the selection is valid
            String removed = tasks.remove(selection - 1);
            System.out.println("Deleted: " + removed);
        } else { // If the selection is invalid, print an error message
            System.out.println("Invalid number entered.");
        }
    }

    public static void mainMenu() { // This module displays the main menu and handles user input
        boolean exit = false;
        while (!exit) { // Loop until the user chooses to exit
            System.out.println("\n----- Study Planner Menu -----");
            System.out.println("1. Add a task");
            System.out.println("2. Modify a task");
            System.out.println("3. Remove a completed task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try { // Read user input for the menu choice
                choice = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) { // Handle invalid inputs that are not options
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
                continue;
            }

            switch (choice) { // Switch case to handle the user's choice
                case 1: // Add a task
                    addTasks();
                    break;
                case 2: // Edit a task
                    editTask();
                    break;
                case 3: // Remove a completed task
                    deleteTask();
                    break;
                case 4: // Exit the application
                    System.out.println("Thank you for using the study planner, goodbye!");
                    exit = true;
                    break;
                default: // Handle invalid menu choices
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void main(String[] args) { // Runs the planner application using all the modules
        System.out.println("\nWelcome to the Planner!"); // Welcome message
        mainMenu(); // Call the main menu to start the application
        scan.close(); 
    }
}
