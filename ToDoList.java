import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoList {
	
	private Queue toDoList;
	
	public ToDoList() {
		
		toDoList = new Queue();
	}
	
	private void addTaskToList() {
		String appointment;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the name of task to add: ");
		appointment = in.nextLine();
		toDoList.enqueue(appointment);
	}
	
	private void removeTaskFromList() {
		if(toDoList.isEmpty()) {
			System.out.println("No tasks to undo!");
		}
		else {
			System.out.println("Check off " + toDoList.checkFirst() + " as completed? (Y/N)");
			Scanner in = new Scanner(System.in);
			String userResponse = in.nextLine();
			if(userResponse.equalsIgnoreCase("y")) {
				toDoList.dequeue();
				if(!toDoList.isEmpty()) {
					System.out.println("Next task: " + toDoList.checkFirst());
				}
			}
		}
	}
	
	private void checkNextTask() {
		if(toDoList.isEmpty()) {
			System.out.println("No tasks have been added!");
		}
		else {
			System.out.println("Next task: " + toDoList.checkFirst());
		}
	}
	
	private void menuLoop() {
		 boolean done = false;
		 while(!done) {
			 int userChoice = 0;
		     Scanner in = new Scanner(System.in);
		     boolean invalidNumber = false;
		     do {
		    	 try {
		    		 if(invalidNumber) {
		    			 System.out.println("Please enter a number between 1 and 3");
		    		 }
		    		 System.out.println();
		    		 System.out.println("Welcome to your To Do List!");
		 			 System.out.println("Please select one of the following options:");
		 			 System.out.println("1. Add a task to your To Do List");
		 			 System.out.println("2. Mark a task as completed, and remove it from "
		 								+ "your To Do List");
		 			 System.out.println("3. Check the next task on your To Do List");
		 			 System.out.println("4. Exit");
		    	     userChoice = in.nextInt();
		    	     if(userChoice < 1 || userChoice > 4) {
		    	    	 invalidNumber = true;
		    	     }
		    	 } catch (InputMismatchException e) {
		    		 System.out.println("Please enter a number between 1 and 4");
		    	 }
		    	 in.nextLine();
		     } while(userChoice < 1 || userChoice > 4);
		     
				switch(userChoice) {
			 	case 1: addTaskToList();
			 			break;
			 	case 2: removeTaskFromList();
			 			break;
			 	case 3: checkNextTask();
			 			break;
			 	case 4: done = true;
			 			break;
				}
		 } 	
	}
	
	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		toDoList.menuLoop();
	}
}
