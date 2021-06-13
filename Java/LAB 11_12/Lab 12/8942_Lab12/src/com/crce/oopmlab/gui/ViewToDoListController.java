/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.gui;

import com.crce.oopmlab.Task;
import com.crce.oopmlab.ToDoList;
import com.crce.oopmlab.ToDoListDao;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * View To Do List Controller Class
 * @author Gini Chacko
 *
 */
public class ViewToDoListController{
	
	JFrame frame;
	JTable table;
	JButton btnBack;
	String column_names[] = { "Task Name", "Employee Name", "Deadline Date", "Task status(isDone)"};
	Connection c;
	PreparedStatement ps;
	Statement s;
	ResultSet rs;
	int k = 0;
	
	public ViewToDoListController() {
		//Frame and Table details
		frame = new JFrame("TO DO TASKS LIST");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(column_names);
		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);



        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                frame.dispose();
                new ToDoListController();
            }
        });
        //For values input in table
        String taskName, employeeName;
        boolean isDone;
        Date date;

        ToDoListDao dao = new ToDoListDao();
        //Store returned ArrayList from viewToDoList() method in an ArrayList
        ArrayList <Task> tasks = dao.viewToDoList(); 
        //Iterate till there are tasks in the list
        for(Task task : tasks)
        {
            taskName = task.getTaskName();
            employeeName = task.getEmployee();
            date = task.getDeadline();
            isDone = task.isDone();
            model.addRow(new Object[]{ taskName, employeeName, date, isDone});
            k++;
        }

        //If Tasks are found
        if(k!=0)
        {
            frame.add(scroll);
            frame.add(btnBack, BorderLayout.SOUTH);
            frame.setResizable(true);
            frame.setSize(200,150);
            frame.setVisible(true);

        }

        //If Tasks are not found

        if(k==0)
        {
            frame.dispose();
            JOptionPane.showMessageDialog(null, " No Record Found ", " Error ",JOptionPane.ERROR_MESSAGE);
        }
        frame.setVisible(true);
    }


    public static void main(String[] args)
    {
        new ViewToDoListController();
    }
}




