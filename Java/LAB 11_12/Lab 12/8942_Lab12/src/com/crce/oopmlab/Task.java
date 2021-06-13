/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import java.util.Date;
import java.text.SimpleDateFormat;
/**
 * Task Class
 * @author Gini Chacko
 *
 */
public class Task
{
	/**
	 * private instance variable, not accessible from outside the class
	 */
    private String taskName;
    private Date deadline;
    private String employee;
    private boolean isDone;
    
    /**
	 * Getter for instance variable task name
	 * @return task name
	 */
    public String getTaskName() {
        return taskName;
    }
    
    /**
	 * Setter for instance variable task name
	 * @param taskName
	 */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    
    /**
	 * Getter for instance variable deadline
	 * @return deadline
	 */
    public Date getDeadline() {
        return deadline;
    }
    
    /**
	 * Setter for instance variable deadline
	 * @param deadline
	 */
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    /**
	 * Getter for instance variable employee
	 * @return employee
	 */
    public String getEmployee() {
        return employee;
    }
    
    /**
	 * Setter for instance variable employee
	 * @param employee
	 */
    public void setEmployee(String employee) {
        this.employee = employee;
    }
    
    /**
	 * @return is Done true or false
	 */
    public boolean isDone() {
        return isDone;
    }
    
    /**
	 * Setter for instance variable is done
	 * @param isDone
	 */
    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }
    
    @Override
    public String toString() {
        return "Task{" + "taskName=" + taskName + ", deadline=" + deadline + ", employee=" + employee + ", isDone=" + isDone + '}';
    }

    public void getEmployee(String employeeName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
