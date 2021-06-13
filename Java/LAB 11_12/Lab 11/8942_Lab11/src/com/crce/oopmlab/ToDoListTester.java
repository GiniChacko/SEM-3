/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package com.crce.oopmlab;

import com.crce.oopmlabhelper.Helper;

/**
 * To Do List Tester class
 * @author Gini Chacko
 *
 */
public class ToDoListTester {
	/**
	 * Main mathod
	 * @param args
	 */
	public static void main(String[] args) {
		
		ToDoListTester tester = new ToDoListTester();
		tester.testAll();
	}
	
	/**
	 * Test All method containing all the methods to be tested
	 */
	public void testAll() {
		
		testCreateTask();
		testDisplayToDoList();
		
		testRenameTask();
		testDisplayToDoList();
		
		testMarkAsDone();
		testDisplayToDoList();
		
		testRemoveTask();
		testDisplayToDoList();
		
		testAssignedDeadline();
		testDisplayToDoList();
		
		testAssignTask();
		testDisplayToDoList();
	}
	
	/**
	 * Tester method to Create Task
	 */
	public void testCreateTask() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Adding elements to the list");
		ToDoList toDoList = new ToDoList();
		toDoList.createTask();
		toDoList.createTask();
		toDoList.createTask();
	}
	
	/**
	 * Tester method to Display to do list
	 */
	public void testDisplayToDoList() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();	
		
		ToDoList toDoList = new ToDoList();
		toDoList.display();
	}
	
	/**
	 * Tester method to Rename a task
	 */
	public void testRenameTask() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		
		String taskName = "task1";
		Task t = Helper.inputTask("Please Enter Upadates");
		ToDoList toDoList = new ToDoList();
		toDoList.renameTask(taskName, t);
		
		System.out.println(ToDoList.toDoList);
	}
	
	/**
	 * Tester method to Mark as done a task
	 */
	public void testMarkAsDone() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		
		String taskName = "task2";
		ToDoList toDoList = new ToDoList();
		toDoList.markAsDone(taskName);
	}
	
	/**
	 * Tester method to Remove Task
	 */
	public void testRemoveTask() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		
		String taskName = "task3";
		ToDoList toDoList = new ToDoList();
		toDoList.removeTask(taskName);
	}
	
	/**
	 * Tester method to Assign Deadline
	 */
	public void testAssignedDeadline() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		
		String deadline = "12/12/2022";
		String taskName = "task1";
		ToDoList toDoList = new ToDoList();
		toDoList.assignDeadline(deadline, taskName);
	}
	
	/**
	 * Tester method to Assign Task
	 */
	public void testAssignTask() {
		
		System.out.println("------------------------------------------------------------------------------------");
		System.out.println();
		
		String employee = "Hema";
		String taskName = "task1";
		ToDoList toDoList = new ToDoList();
		toDoList.assignTask(employee, taskName);
	}
	
}
