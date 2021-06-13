/* NAME : GINI CHACKO
 * ROLL : 8942
 * CLASS : SE COMPS B
 * BATCH : B
 */
package com.crce.oopmlab.helper;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
/**
 * DBUtil Class
 * @author Gini Chacko
 *
 */
public class DBUtil {
    Connection con;
    PreparedStatement pst;

    /**
     * Method to get connection
     * @return con
     */
	public static Connection getConnection() {
		Connection con = null;
		
		String url = "jdbc:mysql://localhost/todolist";
		String username = "root";
		String password = "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");//Step1
			con = DriverManager.getConnection(url, username, password);//step 2
			System.out.println(con);
			System.out.println("Connected");
		}
                catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		}finally {
			/*try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}*/
		}
		return con;
	}
	
     /**   
      * Method to close connection for prepared statement p
      * @param p
      */
    public static void closeConnection(PreparedStatement p)
    {
        try {
            p.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method to close connection for connection c
     * @param c
     */
    public static void closeConnection(Connection c)
    {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method to close connection statement s
     * @param s
     */
    public static void closeConnection(Statement s)
    {
        try {
            s.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Method to close connection result set rs
     * @param rs
     */
    public static void closeConnection(ResultSet rs)
    {
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
