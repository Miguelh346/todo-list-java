
import java.util.*;

public class Main {

    private static List<String> tasks = new ArrayList<>();

    public static void main(String[] args) {
 
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome to your to do list!");
        System.out.println("What would you like to do?");
        System.out.println("Available commands: Add <Task>, list tasks, exit");


        while(true){

            System.out.println("\nWhat would like to do?: ");
            String input = scan.nextLine();

            if(input.equalsIgnoreCase("exit")){
                System.out.println("\nYou can do it! Goodbye for now!\n");
                break;
            }
            else if(input.toLowerCase().startsWith("add ")){
                addTask(input.substring(4));
            }
            else if(input.equalsIgnoreCase("list tasks")){
                System.out.println("\nYour curent task list:");
                showTasks();
            }
            else if(input.equalsIgnoreCase("delete")){
                if(!tasks.isEmpty())
                    removeTask(scan);
                else
                    System.out.println("No Tasks to delete. Try adding a task!");
            }

        
        
        }

        scan.close();
    }

    //read the file

    //add task
    private static void addTask(String task){
        if(task.isEmpty()){
            System.out.println("Remember to add the task name after the word \"add\" :)");
        }
        else{
            tasks.add(task);
            System.out.println("Added the Following task: "+task );
        }
        
    }

    //show tasks
    private static void showTasks(){

        if(tasks.isEmpty()){
            System.out.println("\nNo tasks yet! Let's get going!");
        }
        else{
            
            
            int i = 1;
            for(String taskName: tasks){
                
                System.out.println(i+": "+taskName);
                i++;
            }
        }

    }

    
    //delete task
    private static void removeTask(Scanner scan){

        System.out.println("\nCurrent Tasks");
        showTasks();
        
        System.out.println("Enter the number of the task to delete: ");
                
        String remove = scan.nextLine();

        int numRemove;       
        try {
                numRemove = Integer.parseInt(remove) -1;
        } catch (Exception e) {
                System.out.println("Invalid input received. Please try again");
                return;
        }
        
        
        
        if(numRemove < tasks.size() && numRemove >= 0){
            tasks.remove(numRemove);
            System.out.println("\nUpdated task list:");
            showTasks();
        }
        else
            System.out.println("Invalid number entered. Please try again.");
    }

    //save task list

    // 
}