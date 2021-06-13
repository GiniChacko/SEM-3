/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.crce.oopmlabhelper.Helper;

/**
 * To Do List class
 * @author Gini Chacko
 *
 */
public class ToDoList {
	/**
	 * private instance variable, not accessible from outside the class
	 */
	private String topic;

	static ArrayList<Task> toDoList = new ArrayList<Task>();

	/**
	 * Getter for instance variable topic
	 * @return the topic
	 */
	public String getTopic() {
		return topic;
	}

	/**
	 * Setter for instance variable topic
	 * @param topic
	 */
	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * Getter for instance variable to do list
	 * @return to do list
	 */
	public static ArrayList<Task> getToDoList() {
		return toDoList;
	}

	/**
	 * Method to create task
	 */
	public void createTask() {
		// System.out.println("Inside createTask()");
		Task task = Helper.inputTask("=============Enter The Task details============");

		toDoList.add(task);
		System.out.println(toDoList);
	}

	/**
	 * Method to rename a task
	 * @param taskName
	 * @param myTask
	 */
	public void renameTask(String taskName, Task myTask) {
		System.out.println("Inside renameTask :" + taskName);
		System.out.println(toDoList);
		Task t = new Task();
		int count = 0;
		for (Task task : toDoList) {
			if (task.getTaskName().equals(taskName))
				;
			System.out.println("inside");
			t.setTaskName(myTask.getTaskName());
			t.setEmployee(myTask.getEmployee());
			t.setDone(myTask.isDone());
			t.setDeadline(myTask.getDeadline());

			toDoList.set(count, t);
		}
		count++;
	}

	/**
	 * Method to remove a task
	 * @param removeTask
	 */
	public void removeTask(String removeTask) {
		System.out.println("Inside removeTask()");
		System.out.println();
		System.out.println("Removing an existing Task");
		int count = 0;
		Task deleteTask = null;
		for (Task t : toDoList) {
			if (t.getTaskName().equals(removeTask)) {

				break;
			}

			count++;
		}
		deleteTask = toDoList.remove(count);

		if (deleteTask != null) {
			System.out.println("Task deleted successfully");
		} else {
			System.out.println("Task not found");
		}
	}

	/**
	 * Method to mark as done a task
	 * @param taskName
	 */
	public void markAsDone(String taskName) {
		System.out.println("Inside markAsDone()");
		int count = 0;

		for (Task task : toDoList) {
			if (task.getTaskName().equals(taskName)) {
				task.setDone(true);
				toDoList.set(count, task);
			}
			count++;
		}
	}

	/**
	 * Method to assign deadline
	 * @param deadline
	 * @param taskName
	 */
	public void assignDeadline(String deadline, String taskName) {

		System.out.println("Inside assignDeadline()");
		Task t = new Task();
		int count = 0;
		for (Task task : toDoList) {
			if (task.getTaskName().equals(taskName)) {
				t = task;
				try {
					task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(deadline));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				toDoList.set(count, task);
			}
			count++;
		}
		System.out.println("Task Deadline Assigned successfully");
	}

	/**
	 * Method to display
	 */
	public void display() {
		System.out.println("Inside display the toDoList()");

		for (Task task : toDoList) {

			System.out.println("The task Name " + task.getTaskName() + " is assigned to " + task.getEmployee()
					+ " is given deadline as " + task.getDeadline() + " having status as " + task.isDone());
		}
	}

	/**
	 * Method to assign task
	 * @param employee
	 * @param taskName
	 */
	public void assignTask(String employee, String taskName) {
		System.out.println("Inside assignTask()");
		// Task t = new Task();
		int count = 0;
		for (Task task : toDoList) {
			if (task.getTaskName().equals(taskName)) {
				// t = task;
				task.setEmployee(employee);
				toDoList.set(count, task);
			}
			count++;
		}
		System.out.println("Task Assigned to Employee Sucessfully");
	}

}