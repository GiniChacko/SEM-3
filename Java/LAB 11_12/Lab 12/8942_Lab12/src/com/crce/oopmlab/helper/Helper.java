/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package com.crce.oopmlab.helper;

import com.crce.oopmlab.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Helper Class
 * @author Gini Chacko
 *
 */
public class Helper 
{
	/**
	 * Method to input task
	 * @param message
	 * @return t
	 */
    public static Task inputTask(String message)
    {
        System.out.println(message);
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" ENTER THE TASK : ");       
        String taskName = sc.nextLine();
        
        System.out.println(" ENTER THE NAME OF THE EMPLOYEE : ");
        String employeeName = sc.nextLine();
        
        System.out.println(" ENTER THE DUE DATE (dd/mm/yyyy) : ");
        Scanner scan = new Scanner(System.in);
        Date d = null;
        try
        {
            d = new SimpleDateFormat("dd/MM/yyyy").parse(scan.nextLine());
        } 
        catch (ParseException ex) 
        {
            ex.printStackTrace();
        }
        System.out.println();
        Task t = new Task();
        t.setTaskName(taskName);
        t.setEmployee(employeeName);
        t.setDeadline(d);
        
        return t;
        
    }
    public static void main(String[] args)
    {
        Helper helper = new Helper();
        Task t1 = helper.inputTask(" TEDxCRCE ");
        System.out.println(t1);
    }
}

