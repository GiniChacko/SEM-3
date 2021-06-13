/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package com.crce.oopmlabgui;

import java. awt. Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.crce.oopmlab.ToDoList;

/**
 * Assign Task Controller Class
 * @author Gini Chacko
 *
 */
public class AssignTaskController extends JFrame {

	JLabel lb1TaskName, lb1EmployeeName;
	JTextField jTaskName, jEmployeeName;
	JButton btnAssignTaskToEmployee, btnBack;

    public AssignTaskController() {
	
    	lb1TaskName = new JLabel("Enter Task Name: ");
        lb1EmployeeName =  new JLabel("Enter Employee Name : ");

    	lb1TaskName.setBounds (20, 20, 150, 20);
    	lb1EmployeeName.setBounds (20, 60, 150, 20);

    	jTaskName = new JTextField(20);
    	jEmployeeName = new JTextField(20);

    	jTaskName.setBounds (250, 20, 100, 20);
    	jEmployeeName.setBounds (250, 60, 150, 20);

    	btnAssignTaskToEmployee = new JButton("Assign Task To Employee");
    	btnBack = new JButton ("Back");	
    	

        btnAssignTaskToEmployee.setBounds (20, 100, 170, 20);
        btnBack.setBounds (250, 100, 150, 20);

        add(lb1TaskName);
        add(lb1EmployeeName);

        add(jTaskName);
        add(jEmployeeName);

        add(btnAssignTaskToEmployee); 
        add(btnBack);
        
        btnAssignTaskToEmployee.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		ToDoList toDoList = new ToDoList();
        		toDoList.assignTask(jEmployeeName.getText(), jTaskName.getText());
        		JOptionPane.showMessageDialog(btnAssignTaskToEmployee," Task Assigned to Employee " );
        	}
        	
        });
        
        btnBack.addActionListener(new ActionListener() {
        	
        	public void actionPerformed(ActionEvent e) {
        		
        		JOptionPane.showMessageDialog(btnBack, "Going Back To ToDoList Home");
        		new ToDoListController();
        	}
        	
        });

        setTitle("ToDolist Application");
        setSize(500, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
		new AssignTaskController();
	}
}




