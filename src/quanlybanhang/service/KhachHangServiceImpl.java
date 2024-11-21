 
package quanlybanhang.service;
import quanlybanhang.dao.KhachHangDAO;
import quanlybanhang.dao.KhachHangDAOImpl;
import quanlybanhang.moder.Kháchhang;
import java.util.List;
import quanlybanhang.dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class KhachHangServiceImpl implements KhachHangService{
    private KhachHangDAO spDAO = null;
    public  KhachHangServiceImpl(){
        spDAO = new KhachHangDAOImpl();
    }

    @Override
    public List<Kháchhang> getlist() {
    return spDAO.getlist();
        }
//    @Override
    public int createrOfUpdate(Kháchhang sp) {
        return spDAO.createrOfUpdate(sp);
    }

}
