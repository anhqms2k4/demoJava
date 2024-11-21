 
package quanlybanhang.dao;
import java.sql.Connection;
import java.util.List;

import quanlybanhang.moder.Sảnphẩm;
import java.sql.*;
import java.util.ArrayList;
 


/**
 *
 * @author Dell
 */
public class SanPhamxinDAOImpl implements SanPhamxinDAO {

    @Override
    public List<Sảnphẩm> getlist() {
        try {
            Connection cons = DBConnect.getJDBCConnection();
            String sql = "SELECT * FROM quảnlýbánhàng.sanphamxin;";
            List<Sảnphẩm> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Sảnphẩm sp = new Sảnphẩm();
                sp.setMa_san_pham(rs.getInt("ma_san_pham"));
                sp.setTen_Sp(rs.getString("ten_SP"));
                sp.setCauHinh(rs.getString("cauHinh"));
                sp.setGia_ban(rs.getInt("gia_ban"));
                sp.setNgaysx(rs.getDate("ngay_sx"));
                sp.setHang_sx(rs.getString("hang_sx"));
                
                
                list.add(sp);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return null;
    }
    
    public static void main(String[] args) {
        SanPhamxinDAO sanPhamxinDAO = new SanPhamxinDAOImpl();
        System.out.println(sanPhamxinDAO.getlist());
        
    }
 @Override
public int createrOfUpdate(Sảnphẩm sp) {
    int generatedKey = sp.getMa_san_pham(); // Nếu có mã sản phẩm, sử dụng mã đó
    
    try {
        Connection cons = DBConnect.getJDBCConnection();

        if (generatedKey != 0) {
            // Nếu mã sản phẩm có giá trị (cập nhật sản phẩm cũ)
            String sqlUpdate = "UPDATE sanphamxin SET ten_SP = ?, gia_ban = ?, ngay_sx = ?, hang_sx = ?, cauHinh = ? WHERE ma_san_pham = ?";
            PreparedStatement ps = cons.prepareStatement(sqlUpdate);
            ps.setString(1, sp.getTen_Sp());
            ps.setInt(2, sp.getGia_ban());
            ps.setDate(3, sp.getNgaysx() != null ? new Date(sp.getNgaysx().getTime()) : null);
            ps.setString(4, sp.getHang_sx());
            ps.setString(5, sp.getCauHinh());
            ps.setInt(6, generatedKey);  // Sử dụng mã sản phẩm để cập nhật
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cập nhật thành công cho sản phẩm mã: " + generatedKey);
            } else {
                System.out.println("Không có dữ liệu nào được cập nhật.");
            }
            ps.close();
        } else {
            // Nếu không có mã sản phẩm (tạo mới sản phẩm)
            String sqlMaxID = "SELECT MAX(ma_san_pham) FROM sanphamxin";
            Statement stmt = cons.createStatement();
            ResultSet rs = stmt.executeQuery(sqlMaxID);
            if (rs.next()) {
                generatedKey = rs.getInt(1) + 1; // Lấy mã mới lớn nhất và cộng thêm 1
            }
            rs.close();
            stmt.close();

            String sqlInsert = "INSERT INTO sanphamxin(ma_san_pham, ten_SP, gia_ban, ngay_sx, hang_sx, cauHinh) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sqlInsert);
            ps.setInt(1, generatedKey); // Chỉ định mã sản phẩm mới
            ps.setString(2, sp.getTen_Sp());
            ps.setInt(3, sp.getGia_ban());
            ps.setDate(4, sp.getNgaysx() != null ? new Date(sp.getNgaysx().getTime()) : null);
            ps.setString(5, sp.getHang_sx());
            ps.setString(6, sp.getCauHinh());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Thêm mới thành công. Mã sản phẩm: " + generatedKey);
            } else {
                System.out.println("Không có dòng dữ liệu nào được thêm.");
            }
            ps.close();
        }
        cons.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.err.println("Lỗi trong createrOfUpdate: " + ex.getMessage());
    }
    return generatedKey;
}



}
