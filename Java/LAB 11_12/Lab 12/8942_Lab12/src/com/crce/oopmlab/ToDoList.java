/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import com.crce.oopmlab.helper.Helper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
/**
 * To Do List class
 * @author Gini Chacko
 *
 */
public class ToDoList
{
	/**
	 * private instance variable, not accessible from outside the class
	 */
    private String topic;
    
    static ArrayList<Task> toDoList = new ArrayList<Task>();

    public static ArrayList<Task> getTodoList() 
    {
        return toDoList;
    }
    /**
	 * Getter for instance variable topic
	 * @return the topic
	 */
    public String getTopic()
    {
        return topic;
    }

    /**
	 * Setter for instance variable topic
	 * @param topic
	 */
    public void setTopic(String topic)
    {
        this.topic = topic;
    }
    
    /**
	 * Method to create task
	 */
    public void createTask()
    {
        //System.out.println(" Inside createTask() ");
        Task task = Helper.inputTask(" =====================================ENTER THE TASK DETAILS===================================== ");
        
        toDoList.add(task);        
    }
    
    /**
	 * Method to add task
	 */
    public void addTask(Task task)
    {
        //System.out.println(" Inside addTask() ");
        toDoList.add(task);
        display();        
    }
    
    /**
	 * Method to rename a task
	 * @param taskName
	 * @param myTask
	 */
    public void renameTask(String taskName, Task myTask)
    {
        System.out.println(" Inside renameTask()");
        System.out.println(taskName+myTask);       
        Task t = new Task();
        int count = 0;
        for (Task task : toDoList)
        {
            if(task.getTaskName().equals(taskName))
            {
                t.setTaskName(myTask.getTaskName());
                t.setEmployee(myTask.getEmployee());
                t.setDone(myTask.isDone());
                t.setDeadline(myTask.getDeadline());
                
                toDoList.set(count, t); //Set the task at that particular position
            }
            count++;
        }
        System.out.println(" TASK UPDATED SUCCESSFULLY!!! ");
    }
    
    /**
	 * Method to remove a task
	 * @param removeTask
	 */
    public void removeTask(String removeTask)
    {
    	
    	System.out.println("Removing an existing Task");
    	int count = 0;
    	Task deleteTask = null;
    	for(Task t : toDoList) {
    		if(t.getTaskName().equals(removeTask)) {
    			
    			break;
    		}
    		
    		count++;
    	}
    	deleteTask = toDoList.remove(count);
    	
    	if(deleteTask != null) {
    		System.out.println("Task deleted successfully");
    	}
    	else {
    		System.out.println("Task not found");
    	}
        display();
    }
    
    /**
	 * Method to mark as done a task
	 * @param taskName
	 */  
    public void markAsDone(String taskName)
    {
        
        int count=0;
        for(Task task : toDoList)
        {
            if(task.getTaskName().equals(taskName))
            {
                task.setDone(true);
                toDoList.set(count,task);
            }
            
            count++;
        }
        System.out.println(" TASK COMPLETED!!! ");
        display();
    }
         
    /**
   	 * Method to assign deadline
   	 * @param deadline
   	 * @param taskName
   	 */
    public void assignDeadline(String deadline, String taskName)
    {
        //System.out.println("\nassignDeadline"+deadline);
        Task t = new Task();
        int count = 0;
        for(Task task : toDoList)
        {
            if(task.getTaskName().equals(taskName))
            {
                t = task;
                try
                {
                    task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(deadline));
                }
                catch(ParseException ex)
                {
                    ex.printStackTrace();
                }
                toDoList.set(count, task);                
            }
            count++;
        }
        System.out.println(" TASK DEADLINE ASSIGNED SUCCESSFULLY! ");
        display();
    }
    
    /**
     * Method to modify deadline
     * @param deadline
     * @param taskName
     */
    public void modifyDeadline(String deadline, String taskName)
    {
        //System.out.println("Inside modifyDeadline()");
        Task t = new Task();
        int count = 0;
        for(Task task : toDoList)
        {
            if(task.getTaskName().equals(taskName))
            {
                t = task;
                try
                {
                    task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(deadline));
                }
                catch(ParseException e)
                {
                    e.printStackTrace();
                }
                toDoList.set(count, task);
            }
            count++;
        }
        System.out.println(" TASK DEADLINE HAS BEEN MODIFIED SUCCESSFULLY! ");
        System.out.println(toDoList);
    }
    
    /**
	 * Method to display
	 */
    public void display()
    {
        for(Task task : toDoList)
        {
            System.out.println(" The Task "+ task.getTaskName()+" is assigned to "+task.getEmployee()+"\n Dealine is "+task.getDeadline()+" having staus as "+task.isDone());
            System.out.println("");
        }
    }
    
    /**
	 * Method to assign task
	 * @param employee
	 * @param taskName
	 */
    public void assignTask(String employee, String taskName)
    {
        int count=0;
        for(Task task : toDoList)
        {
            if(task.getTaskName().equals(taskName))
            {
                task.setEmployee(employee);
                toDoList.set(count, task);
            }
            count++;
            
        }
        System.out.println(" TASK ASSIGNED TO EMPLOYEE SUCCESSFULLY! ");
        display();
        
    }
    
    
    
}
