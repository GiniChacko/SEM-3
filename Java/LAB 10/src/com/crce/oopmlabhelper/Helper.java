/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlabhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.crce.oopmlab.Task;

/**
 * Helper class
 * @author Gini Chacko
 *
 */
public class Helper {
	
	/**
	 * Method to input task
	 * @param message
	 * @return
	 */
	public static Task inputTask(String message) {
		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter task name : ");
		
		String taskName = sc.nextLine();
		
		System.out.println("Please enter employee name : ");
		String employeeName = sc.nextLine();
		//System.out.println("Please enter due date");
		System.out.println("Please enter the due date in the format dd/MM/yyyy : ");
		Scanner scanner = new Scanner(System.in);
		Date d = null;
		
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
		}catch (ParseException e) {
			e.printStackTrace();
		}
		Task t = new Task();
		t.setTaskName(taskName);
		t.setDeadline(d);
		t.setEmployee(employeeName);
		
		return t;
		
		
	}

}
