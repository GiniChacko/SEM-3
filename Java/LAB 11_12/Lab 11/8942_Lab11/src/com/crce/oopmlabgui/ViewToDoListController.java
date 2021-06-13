/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */

package com.crce.oopmlabgui;

import com.crce.oopmlab.ToDoList;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * View To Do List Controller Class
 * @author Gini Chacko
 *
 */
public class ViewToDoListController extends JFrame {

	JLabel lb1TaskName, lblEmployeeName;
	JTextField jTaskName, jEmployeeName;
	JButton btnViewToDoList, btnBack;

        public ViewToDoListController ()
        {
	
            
            btnViewToDoList = new JButton("View To Do List");
            btnBack = new JButton ("Back");	


            btnViewToDoList.setBounds (20, 50, 170, 50);
            btnBack.setBounds (250, 50, 170, 50);

            
            add(btnViewToDoList); 
            add(btnBack);

            btnViewToDoList.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                            ToDoList toDoList = new ToDoList();
                            toDoList.display();
                            JOptionPane.showMessageDialog(btnViewToDoList," To Do List Has Been Shown " );
                    }

            });

            btnBack.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                            JOptionPane.showMessageDialog(btnBack, " Going Back To To Do List Home ");
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
	new ViewToDoListController();
    }
}