/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.gui;

import com.crce.oopmlab.ToDoList;
import com.crce.oopmlab.ToDoListDao;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 * Assign Task Controller Class
 * @author Gini Chacko
 *
 */
public class AssignTaskController extends JFrame {

	JLabel lb1TaskName, lblEmployeeName;
	JTextField jTaskName, jEmployeeName;
	JButton btnAssignTaskToEmployee, btnBack;

        public AssignTaskController()
        {
	
            lb1TaskName = new JLabel("Enter Task Name: ");
            lblEmployeeName =  new JLabel("Enter Employee Name : ");

            lb1TaskName.setBounds (20, 20, 150, 20);
            lblEmployeeName.setBounds (20, 60, 150, 20);

            jTaskName = new JTextField(20);
            jEmployeeName = new JTextField(20);

            jTaskName.setBounds (250, 20, 100, 20);
            jEmployeeName.setBounds (250, 60, 150, 20);

            btnAssignTaskToEmployee = new JButton("Assign Task To Employee");
            btnBack = new JButton ("Back");	


            btnAssignTaskToEmployee.setBounds (20, 100, 170, 20);
            btnBack.setBounds (250, 100, 150, 20);

            add(lb1TaskName);
            add(lblEmployeeName);

            add(jTaskName);
            add(jEmployeeName);

            add(btnAssignTaskToEmployee); 
            add(btnBack);

            btnAssignTaskToEmployee.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                            ToDoListDao toDoList = new ToDoListDao();
                            toDoList.assignTask(jEmployeeName.getText(), jTaskName.getText());
                            JOptionPane.showMessageDialog(btnAssignTaskToEmployee," Task Assigned to Employee " );
                    }

            });

            btnBack.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                            JOptionPane.showMessageDialog(btnBack, "Going Back To To Do List Home");
                            new ToDoListController();
                    }

            });

            setTitle(" TO DO LIST APPLICATION ");
            setSize(500, 200);
            setLocationRelativeTo(null);
            setLayout(null);
            setVisible(true);
        }

    public static void main(String[] args)
    {
	new AssignTaskController();
    }
}




