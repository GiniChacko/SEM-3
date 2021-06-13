/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab;

import com.crce.oopmlab.helper.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.ParseException;
import java.util.ArrayList;

/**
 * To Do List Dao Class
 * @author Gini Chacko
 *
 */
public class ToDoListDao 
{
	Connection connection;
	PreparedStatement preparedStatement;
	Statement statement;
	ResultSet resultSet;
	
	/**
	 * Method to add task
	 * @param task
	 */
	public void addTask(Task task)
	{
		System.out.println("Adding Task into database");
		
		connection=DBUtil.getConnection();
		String sql="insert into todolist.tasks values (?,?,?,?)";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, task.getTaskName());
			preparedStatement.setString(2, task.getEmployee());
			preparedStatement.setDate(3, new java.sql.Date(task.getDeadline().getTime()));
			preparedStatement.setBoolean(4, task.isDone());
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Added Successfully");
			}
			else
			{
				System.out.println("Insertion Unsuccessful");
			}
		}
                catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	/**
	 * Method to rename task
	 * @param taskName
	 * @param myTask
	 */
	public void renameTask(String taskName, Task myTask)
        {
		System.out.println("Inside rename task");
		Connection connection = DBUtil.getConnection();
		String sql = "update todolist.tasks set employeeName=?,dob = ?,isDone =? where  taskName =?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, myTask.getEmployee());
			preparedStatement.setDate(2, new java.sql.Date(myTask.getDeadline().getTime()));
			preparedStatement.setBoolean(3, myTask.isDone());
			preparedStatement.setNString(4, myTask.getTaskName());
			int count = preparedStatement.executeUpdate();
			if(count>0) {
				System.out.println("Successfully Updated");
			}
			else
				System.out.println("Updation failed");
		}
                catch(SQLException e) 
                {
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
	}
	
	/**
	 * Method to remove task
	 * @param removeTask
	 */
	public void removeTask(String removeTask)
	{
		System.out.println("Removing Task");
		connection=DBUtil.getConnection();
		String sql="delete from todolist.tasks where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, removeTask);
                        //preparedStatement.setString(1, "");
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Deleted Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
                finally
                {
                    try {
                        connection.close();
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
	}
		
	/**
	 * Method to mark as done a  particular ask
	 * @param taskName
	 */
	public void markAsDone(String taskName)
	{
		System.out.println("Marking as Done");
		connection=DBUtil.getConnection();
		String sql="update todolist.tasks set isDone=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(2, taskName);
			preparedStatement.setBoolean(1, true);
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Task Marked done Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}
                catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
                finally
                {
                    try {
                        connection.close();
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
	}
	
	/**
	 * Method to modify deadline
	 * @param deadline
	 * @param taskName
	 */
	public void modifyDeadline(String deadline, String taskName)
	{
		System.out.println("Assigning Deadline Task");
		connection=DBUtil.getConnection();
		String sql="update todolist.tasks set dob=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(2, taskName);
			try {
			preparedStatement.setDate(1, new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(deadline).getTime()));
			}catch(Exception e1)
			{
				e1.printStackTrace();
			}
			int count=preparedStatement.executeUpdate();
			if(count>0)
			{
				System.out.println("DeadLine Modified Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}
                catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
                finally
                {
                    try {
                        connection.close();
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
	}
	
	/**
	 * Method to assign task
	 * @param employeeName
	 * @param taskName
	 */
	public void assignTask(String employeeName, String taskName)
	{
		System.out.println("Assigning Task");
		connection=DBUtil.getConnection();
		String sql="update todolist.tasks set employeeName=? where taskName=?";
		
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(2, taskName);
			preparedStatement.setString(1, employeeName);
			int count=preparedStatement.executeUpdate();
			
			if(count>0)
			{
				System.out.println("Assigned Task Successfully");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}
                catch(SQLException e)
		{
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
		}
                finally
                {
                    try {
                        connection.close();
                        preparedStatement.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        
                }
        
	}
        /**
         * Method to view the to do list
         * @return the list
         */
        public ArrayList<Task> viewToDoList()
        {
		
		Connection c = DBUtil.getConnection();
		//select each task from table
		String sql = "select * from todolist.tasks";
		ToDoList toDoList = new ToDoList();
		ArrayList<Task> list = new ArrayList<Task>();
		try
                {
                    preparedStatement = c.prepareStatement(sql);
                    ResultSet rs = preparedStatement.executeQuery();
                    //Iterate till there are tasks in the list
                    while(rs.next())
                    {
                            //Create a task object
                            Task t = new Task();
                            //Set values after retrieving from the databes
                            t.setTaskName(rs.getString("taskName"));
                            t.setEmployee(rs.getString("employeeName"));
                            t.setDeadline(rs.getDate("dob"));
                            t.setDone(rs.getBoolean("isDone"));
                            //add to arraylist
                            list.add(t);
                    }
                    
			
		}
                catch(SQLException e) 
                {
			e.printStackTrace();
			Logger.getLogger(ToDoListDao.class.getName()).log(Level.SEVERE,null,e);
                }
            return list;
                
        }
        
}     
	

	
	





