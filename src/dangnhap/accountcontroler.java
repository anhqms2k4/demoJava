/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dangnhap;

import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author Dell
 */
public class accountcontroler {
    public static Connection getJDBCConnection(){
        String url = "jdbc:mysql://localhost:3306/dangnhapchuan";
        String user = "root";
        String password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url,user,password); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(accountcontroler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(accountcontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public boolean login(String username ,String password){
         Connection conn = getJDBCConnection();
         String sql = "SELECT * FROM accounts WHERE username = ? and password = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(accountcontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
       
return false;
//    public static void main(String[] args) {
//        Connection conn = getJDBCConnection();
//        if(conn != null ){
//            System.out.println("thanh cong ");
//        }else{
//            System.out.println("that bai ");
//        }
//    }
}
    public void register(account ac){
    Connection conn = getJDBCConnection();
    String sql = "INSERT INTO accounts(username,password,fullname,address) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ac.getUsername());
                ps.setString(2, ac.getPassword());
                ps.setString(3, ac.getFullname());
                ps.setString(4, ac.getAddress());
                int rs = ps.executeUpdate();
                if(rs != 0){
                    System.out.println("them thành công ");
                }else{
                    System.out.println("thêm thất bại");
                }
        } catch (SQLException ex) {
            Logger.getLogger(accountcontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}