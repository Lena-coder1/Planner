/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planner;

import java.util.*;

public class Planner {

    /**
     * where the modules will go
     */  
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    // the module to add tasks
    public static void addTasks() {
        System.out.print("Would you like to add a task (YES/NO): ");
        String answer = scan.nextLine();

        if (answer.equalsIgnoreCase("YES")) {

            System.out.print("How many tasks would you like to enter: ");
            int numTasks;

            try {
                numTasks = scan.nextInt();
                scan.nextLine(); // Consume the newline character
            } catch (InputMismatchException e) {
                System.out.println("Invalid number entered.");
                scan.nextLine(); // Consume the invalid input
                return;
            }

            if (numTasks > 0) {
                for (int i = 0; i < numTasks; i++) {
                    System.out.print("Please enter task #" + (i + 1) + ": ");
                    String newTask = scan.nextLine();
                    tasks.add(newTask); // Add the new task to the main ArrayList
                }

                System.out.println("\nYour Task List:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println((i + 1) + ".) " + tasks.get(i));
                }
            } else {
                System.out.println("Number must be greater than 0. Try again.");
            }

        } else {
            System.out.println("Have a good day!");
        }
    }

    //edit tasks
    public static void editTask() {
        System.out.print("Please enter the task number you want to edit:");
        int selection = scan.nextInt();
        scan.nextLine();

        if (selection >=1 && selection <= tasks.size()) {
            System.out.print("Edit task here:");
            String editedTask = scan.nextLine();
            tasks.set(selection -1, editedTask);
        } else {
            System.out.println("Invalid number entered");
        }

        //show updated list
        System.out.println("Updated tasks:");
        for (int i=0; i < tasks.size(); i++){ 
            System.out.println(i+1 + "." + tasks.get(i));
        }
    }
    
    //this module deletes the task the user wants to delete 
    public static void deleteTask()
    {
        System.out.print("Please enter the task number you want to delete: ");
        int selection = scan.nextInt();
        
        if(selection >= 1 && selection <= tasks.size())
        {
            String removed = tasks.remove(selection-1);
            System.out.println("deleted: " + removed);
        }
        else
        {
            System.out.println("invalid number entered");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to the Planner!");
        addTasks();
        editTask();
        deleteTask();
        System.out.println("Thank you for using the Planner!");
        scan.close();
    }
}