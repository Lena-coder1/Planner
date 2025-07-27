/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package planner;

/**
 *
 * @author Divine, Krishna, Lena & Lynneth
 */
import java.util.*;
public class Planner {

    /**
     * where the modules will go
     */  
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);

    //edit tasks
    public static void editTask() {
        System.out.print("Please enter the taks number you want to edit:");
        int selection = scan.nextInt();
        scan.nextLine();

        if (selection >=1 && selection <= tasks.size()) {
            System.out.print("Edit task here:");
            String editedTask = scan.nextLine();
            tasks.set(selection -1, editedTask);
        } else {
            System.out.println("invalied number entered");
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
        // TODO code application logic here
        
        //dummy values
        tasks.add("finihsh project");
        tasks.add("wash the dishes");
        tasks.add("walk the dog");
        tasks.add("read the bible");
        
        //this code is just to test the delete function:
        for(int i =0;i<tasks.size();i++)
        {
            System.out.println(i+1+"."+tasks.get(i));
        }
        
        editTask();

        deleteTask();
        
        System.out.println("remaining tasks: ");
        for(int i =0;i<tasks.size();i++)
        {
            System.out.println(i+1+"."+tasks.get(i));
        }
        
    }
    
}
