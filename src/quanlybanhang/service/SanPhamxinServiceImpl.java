 
package quanlybanhang.service;
import quanlybanhang.dao.SanPhamxinDAO;
import quanlybanhang.dao.SanPhamxinDAOImpl;
import quanlybanhang.moder.Sảnphẩm;
import java.util.List;
import quanlybanhang.dao.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Dell
 */
public class SanPhamxinServiceImpl implements SanPhamxinService{
    private SanPhamxinDAO spDAO = null;
    public  SanPhamxinServiceImpl(){
        spDAO = new SanPhamxinDAOImpl();
    }

    @Override
    public List<Sảnphẩm> getlist() {
return spDAO.getlist();
        }

    @Override
    public int createrOfUpdate(Sảnphẩm sp) {
        return spDAO.createrOfUpdate(sp);
    }



  


}
