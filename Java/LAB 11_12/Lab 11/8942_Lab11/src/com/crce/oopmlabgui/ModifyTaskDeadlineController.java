/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package com.crce.oopmlabgui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.crce.oopmlab.ToDoList;

import java.awt.event. ActionEvent ;
import java.awt.event.ActionListener;

/**
 * Modify Task Deadline Controller Class
 * @author Gini Chacko
 *
 */
public class ModifyTaskDeadlineController extends JFrame {

	JLabel lb1TaskName, lb1Deadline;
	JTextField jTaskName, jDeadline;
	JButton btnModifyTaskToDeadline, btnBack;
	
	 public ModifyTaskDeadlineController() {
			
	    	lb1TaskName = new JLabel("Enter Task Name: ");
	        lb1Deadline =  new JLabel("Enter Modified Deadline : ");

	    	lb1TaskName.setBounds (20, 20, 150, 20);
	    	lb1Deadline.setBounds (20, 60, 150, 20);

	    	jTaskName = new JTextField(20);
	    	jDeadline = new JTextField(20);

	    	jTaskName.setBounds (250, 20, 100, 20);
	    	jDeadline.setBounds (250, 60, 150, 20);

	    	btnModifyTaskToDeadline = new JButton("Modify Task Deadline");
	    	btnBack = new JButton ("Back");	
	    	

	    	btnModifyTaskToDeadline.setBounds (20, 100, 170, 20);
	        btnBack.setBounds (250, 100, 150, 20);

	        add(lb1TaskName);
	        add(lb1Deadline);

	        add(jTaskName);
	        add(jDeadline);

	        add(btnModifyTaskToDeadline); 
	        add(btnBack);
	        
	        btnModifyTaskToDeadline.addActionListener(new ActionListener() {
	        	
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		ToDoList toDoList = new ToDoList();
	        		toDoList.modifyDeadline(jDeadline.getText(), jTaskName.getText());
	        		JOptionPane.showMessageDialog(btnModifyTaskToDeadline," Task deadline changed" );
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
			new ModifyTaskDeadlineController();
		}

}

