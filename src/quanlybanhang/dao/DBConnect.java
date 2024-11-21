
package quanlybanhang.dao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dell
 */
public class DBConnect {
public static Connection getJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/quảnlýbánhàng";
        String user = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        Connection conn = getJDBCConnection();
        System.out.println(conn.toString());
        conn.close();
    }
}
