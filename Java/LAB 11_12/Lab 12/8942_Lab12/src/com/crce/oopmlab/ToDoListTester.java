/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import com.crce.oopmlab.helper.Helper;
/**
 * To Do List Tester class
 * @author Gini Chacko
 *
 */
public class ToDoListTester
{
	/**
	 * Main method
	 * @param args
	 */
    public static void main(String[] args)
    {
        ToDoListTester tester = new ToDoListTester();
        tester.testAll();
    }
    /**
	 * Test All method containing all the methods to be tested
	 */
    public void testAll()
    {
        testCreateTask();
        testDisplayToDoList();
        
        testRenameTask();
        testDisplayToDoList();
        
        testMarkAsDone();
        testDisplayToDoList();
        
        testRemoveTask();
        testDisplayToDoList();
        
        testAssignDeadline();
        testDisplayToDoList();
        
        testAssignTask();
        testDisplayToDoList();       
    }
    
    /**
	 * Tester method to Create Task
	 */
    public void testCreateTask()
    {
        System.out.println(" ADDING ELEMENTS TO THE LIST ");
        ToDoList toDoList = new ToDoList();
        toDoList.createTask();
        toDoList.createTask();
        toDoList.createTask();
    }
    
    /**
	 * Tester method to Display to do list
	 */
    public void testDisplayToDoList()
    {
        ToDoList toDoList = new ToDoList();
        toDoList.display();    
    }
  
    /**
	 * Tester method to Rename a task
	 */
    public void testRenameTask()
    {
        String taskName = "task1";
        Task t = Helper.inputTask(" PLEASE ENTER THE UPDATED INFORMATION ");
        t.setTaskName(taskName);
        
        System.out.println(ToDoList.toDoList);
    }
    
    /**
	 * Tester method to Mark as done a task
	 */
    public void testMarkAsDone()
    {
        String taskName = "task2";
        ToDoList toDoList = new ToDoList();
        toDoList.markAsDone(taskName);
    }
    
    /**
	 * Tester method to Remove Task
	 */
    public void testRemoveTask()
    {
        String taskName = "task3";
        ToDoList toDoList = new ToDoList();
        toDoList.removeTask(taskName);        
    }
    
    /**
	 * Tester method to Assign Deadline
	 */
    public void testAssignDeadline()
    {
        String deadline = "02/12/2022";
        String taskName = "task1";
        ToDoList toDoList = new ToDoList();
        toDoList.assignDeadline(deadline, taskName);
        
        deadline = "18/04/2022";
        taskName = "task2";
        toDoList.assignDeadline(deadline, taskName);
        
        deadline = "17/10/2022";
        taskName = "task3";
        toDoList.assignDeadline(deadline, taskName);
    }
    
    /**
	 * Tester method to Assign Task
	 */
    public void testAssignTask()
    {
        String employee = "emp5";
        String taskName = "task1";
        ToDoList toDoList = new ToDoList();
        toDoList.assignTask(employee, taskName);
    } 
    
    
}
