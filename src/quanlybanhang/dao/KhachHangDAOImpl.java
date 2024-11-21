
package quanlybanhang.dao;
import java.sql.Connection;
import java.util.List;

import quanlybanhang.moder.Kháchhang;
import java.sql.*;
import java.util.ArrayList;
 

public class KhachHangDAOImpl implements KhachHangDAO{
      @Override
    public List<Kháchhang> getlist() {
        try {
            Connection cons = DBConnect.getJDBCConnection();
            String sql = "SELECT * FROM quảnlýbánhàng.khachhang;";
            List<Kháchhang> list = new ArrayList<>();
            PreparedStatement ps = cons.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 Kháchhang kh = new Kháchhang();
            kh.setMaKhachHang(rs.getInt("maKhachHang"));
            kh.setTenKh(rs.getString("tenKh"));
            kh.setSoDt(rs.getString("soDT"));
            kh.setDiaChi(rs.getString("diaChi"));
            kh.setLoaiKh(rs.getString("loaiKH"));
            list.add(kh);
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
        KhachHangDAO kh = new KhachHangDAOImpl();
        System.out.println(kh.getlist());
        
    }

    @Override
public int createrOfUpdate(Kháchhang kh) {
    int maKhachHang = kh.getMaKhachHang(); // Lấy mã khách hàng
    
    try {
        Connection cons = DBConnect.getJDBCConnection();

        if (maKhachHang != 0) {
            // Nếu mã khách hàng đã có, cập nhật bản ghi
            String sqlUpdate = "UPDATE khachhang SET tenKh = ?, soDT = ?, diaChi = ?, loaiKH = ? WHERE maKhachHang = ?";
            PreparedStatement ps = cons.prepareStatement(sqlUpdate);
            ps.setString(1, kh.getTenKh());
            ps.setString(2, kh.getSoDt());
            ps.setString(3, kh.getDiaChi());
            ps.setString(4, kh.getLoaiKh());
            ps.setInt(5, maKhachHang); // Sử dụng mã khách hàng để cập nhật
            
            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Cập nhật thành công khách hàng mã: " + maKhachHang);
            } else {
                System.out.println("Không có bản ghi nào được cập nhật.");
            }
            ps.close();
        } else {
            // Nếu không có mã khách hàng (tạo mới khách hàng)
            String sqlMaxID = "SELECT MAX(maKhachHang) FROM khachhang";
            Statement stmt = cons.createStatement();
            ResultSet rs = stmt.executeQuery(sqlMaxID);

            if (rs.next()) {
                maKhachHang = rs.getInt(1) + 1; // Lấy mã mới lớn nhất và tăng thêm 1
            }
            rs.close();
            stmt.close();

            String sqlInsert = "INSERT INTO khachhang(maKhachHang, tenKh, soDT, diaChi, loaiKH) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement ps = cons.prepareStatement(sqlInsert);
            ps.setInt(1, maKhachHang); // Chỉ định mã khách hàng mới
            ps.setString(2, kh.getTenKh());
            ps.setString(3, kh.getSoDt());
            ps.setString(4, kh.getDiaChi());
            ps.setString(5, kh.getLoaiKh());

            int affectedRows = ps.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Thêm mới thành công. Mã khách hàng: " + maKhachHang);
            } else {
                System.out.println("Không có bản ghi nào được thêm.");
            }
            ps.close();
        }
        cons.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
        System.err.println("Lỗi trong createrOfUpdate: " + ex.getMessage());
    }
    
    return maKhachHang; // Trả về mã khách hàng
}


    }
    

