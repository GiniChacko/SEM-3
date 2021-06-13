/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package com.crce.oopmlabgui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax. swing. JButton;
import javax.swing.JFrame;

import javax.swing.JLabel; 
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import com.crce.oopmlab.Task;
import com.crce.oopmlab.ToDoList;

/**
 * To Do List Controller Class
 * @author Gini Chacko
 *
 */
 public class ToDoListController extends JFrame
 {
    JLabel lblTaskName, lblEmployeeName, lblDeadline, lblCompleteStatus;
    JTextField jTaskName, jEmployeeName, jDeadline, jCompleteStatus;
    JButton btnAddTask, btnRenameTask, btnRemoveTask, btnModifyTaskDeadline, btnAssignTask,btnMarkAsDoneTask, btnViewToDoList;



    public ToDoListController()
    {
        lblTaskName = new JLabel("Enter Task Name : ");
        lblDeadline = new JLabel("Enter Task Deadline : ");
        lblEmployeeName = new JLabel("Enter Employee Name : ");
        lblCompleteStatus = new JLabel("Dummy : ");
        
        lblTaskName.setBounds (20, 20, 150, 20);
	    lblDeadline.setBounds (20, 50, 150, 20);
        lblEmployeeName.setBounds(20,80,150,20);
        lblCompleteStatus.setBounds(20, 110, 150, 20);
        
        jTaskName = new JTextField(20);//20 Char
        jDeadline = new JTextField(20);
        jEmployeeName = new JTextField(20);
        jCompleteStatus = new JTextField(20);
        
        jTaskName.setBounds(170, 20, 100, 20);
        jDeadline.setBounds(170, 50, 100, 20);
        jEmployeeName.setBounds(170, 80, 100, 20);
        jCompleteStatus.setBounds(170, 110, 100, 20);
        
        btnAddTask = new JButton("Add Task ");
        btnRenameTask = new JButton("Rename Task");
        btnRemoveTask = new JButton("Remove Task");
        btnAssignTask = new JButton("Assign Task");
        btnMarkAsDoneTask = new JButton("Mark Task As Done");
        btnModifyTaskDeadline = new JButton("Modify Task Deadline");
        
        btnViewToDoList = new JButton("View To Do List");
        
        btnAddTask.setBounds(300, 20, 150, 20);
        btnRenameTask.setBounds(300, 50, 150, 20); 
        btnRemoveTask.setBounds(300, 80, 150, 20);
        btnModifyTaskDeadline.setBounds(300, 110, 150, 20);
        btnAssignTask.setBounds(300, 140, 150, 20);
        btnMarkAsDoneTask.setBounds(300,170,150,20);
        btnViewToDoList.setBounds(300,200,150,20);
        
        add(lblTaskName);
        add(lblDeadline);
        add(lblEmployeeName);
        //add(lblCompleteStatus);
        
        add(jTaskName);
        add(jDeadline);
        add(jEmployeeName);
        //add(jCompleteStatus);
        
        add(btnAddTask);
        add(btnRenameTask);
        add(btnRemoveTask);
        add(btnAssignTask);
        add(btnMarkAsDoneTask);
        add(btnModifyTaskDeadline);
        add(btnViewToDoList);
        
        btnAddTask.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Task task = new Task();
                task.setTaskName(jTaskName.getText());
                
                try
                {
                    task.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(jDeadline.getText()));
                }
                catch(ParseException e1)
                {
                    e1.printStackTrace();
                }
                
                task.setEmployee(jEmployeeName.getText());
                
               // ToDoListDao dao = new ToDoListDao();
               // dao.addTask(task);
               
                ToDoList toDoList = new ToDoList();
                toDoList.addTask(task);
                JOptionPane.showMessageDialog(btnAddTask," Task Added!! "+task);                
            }
        });
        
        btnRenameTask.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
            {
                Task myTask = new Task();
                myTask.setTaskName(jTaskName.getText());
                
                try
                {
                    myTask.setDeadline(new SimpleDateFormat("dd/MM/yyyy").parse(jDeadline.getText()));
                }
                catch(ParseException e1)
                {
                    e1.printStackTrace();
                }
                
                myTask.setEmployee(jEmployeeName.getText());
             // myTask.setDone(true);
                
               // ToDoListDao dao = new ToDoListDao();
               // dao.renameTask(myTask.getTaskName(),myTask);
               
                
                ToDoList toDoList = new ToDoList();
                toDoList.renameTask(myTask.getTaskName(),myTask);
                JOptionPane.showMessageDialog(btnRenameTask," Task renamed!! "+myTask);                
            }
        });
        
        btnRemoveTask.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
            {
                
                JOptionPane.showMessageDialog(btnRemoveTask," Let's Remove the task!! ");
                new RemoveTaskController();
            }
        });
        
        btnAssignTask.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
            {
                
                JOptionPane.showMessageDialog(btnAssignTask," Let's Assign Task To Employee!! ");
                new AssignTaskController();
            }
        });
        
        btnModifyTaskDeadline.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
            {
                
                JOptionPane.showMessageDialog(btnModifyTaskDeadline," Let's Modify Task Deadline!! ");
                new ModifyTaskDeadlineController();
            }
        });
        
        btnViewToDoList.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
            {
        	    final ToDoList toDoList = new ToDoList();
                toDoList.getToDoList();
                JOptionPane.showMessageDialog(btnViewToDoList," Let's View To Do List!! ");
                new ViewToDoListController();
            }
        });
        
        btnMarkAsDoneTask.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
            {
                
                JOptionPane.showMessageDialog(btnMarkAsDoneTask," Let's mark as done the task!! ");
                new MarkTaskAsDoneController();
            }
        });
        
        setTitle(" TO DO LIST APPLICATION ");
        setSize(500,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);    
  
    }
     public static void main(String[] args)
     {
         new ToDoListController();
     }
 }


