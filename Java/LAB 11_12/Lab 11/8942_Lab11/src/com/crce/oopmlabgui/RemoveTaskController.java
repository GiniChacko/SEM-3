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
 * Remove Task Controller Class
 * @author Gini Chacko
 *
 */
public class RemoveTaskController extends JFrame {
	
	JLabel lb1TaskName, lb1CompleteStatus;
	JTextField jTaskName, jCompleteStatus;
	JButton btnRemoveTask, btnBack;
	
	 public RemoveTaskController() {
			
	    	lb1TaskName = new JLabel("Enter Task Name: ");
	    	lb1TaskName.setBounds (20, 20, 150, 20);

	    	jTaskName = new JTextField(20);
	    	jTaskName.setBounds (200, 20, 120, 20);
	    
	    	btnRemoveTask = new JButton("Remove Task");
	    	btnRemoveTask.setBounds (20, 50, 150, 20);
	    	
	    	btnBack = new JButton ("Back");	
	        btnBack.setBounds(250, 50, 120, 20);

	        add(lb1TaskName);
	        add(jTaskName);
	        
	        add(btnRemoveTask); 
	        add(btnBack);
	        
	        btnRemoveTask.addActionListener(new ActionListener() {
	        	
	        	@Override
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		ToDoList toDoList = new ToDoList();
	        		toDoList.removeTask(jTaskName.getText());
	        		JOptionPane.showMessageDialog(btnRemoveTask," Task removed sucessfully");
	        	}
	        	
	        });
	        
	        btnBack.addActionListener(new ActionListener() {
	        	
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		JOptionPane.showMessageDialog(btnBack, "Going Back To ToDoList Home");
	        		new ToDoListController();
	        	}
	        	
	        });

	        setTitle("ToDolist Application");
	        setSize(400, 150);
	        setLocationRelativeTo(null);
	        setLayout(null);
	        setVisible(true);
	    }

	    public static void main(String[] args) {
			new RemoveTaskController();
		}


}
