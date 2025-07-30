/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planner;
import java.util.Scanner;

/**
 *
 * @author lenam
 */
public class addTask {
    // the module to add task
    public static void addTasks() {
        Scanner input = new Scanner(System.in);

        System.out.print("Would you like to add a task (YES/NO): ");
        String answer = input.nextLine();

        if (answer.equalsIgnoreCase("YES")) {

            System.out.print("How my any tasks would you like to enter: ");
            int numTasks;

            try {
                numTasks = input.nextInt();
                input.nextLine(); 
            } catch (Exception e) {
                System.out.println("Invalid number entered.");
                return;
            }

            if (numTasks > 0) {
                // Create array after knowing how many tasks
                String[] tasks = new String[numTasks];

                for (int i = 0; i < numTasks; i++) {
                    System.out.print("Please enter task #" + (i + 1) + ": ");
                    tasks[i] = input.nextLine();
                }

                // Print all tasks
                System.out.println("\nYour Task List:");
                for (int i = 0; i < numTasks; i++) {
                    System.out.println((i + 1) + ".) " + tasks[i]);
                }
            } else {
                System.out.println("Number must be greater than 0. Try again.");
            }

        } else {
            System.out.println("Have a good day!");
        }
    }

    
    public static void main(String[] args) {
       
 
        addTasks(); // calling the method
    
        
        
    }

}
