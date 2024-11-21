
package quanlybanhang.dao;
import java.util.List;
import quanlybanhang.moder.Sảnphẩm;
/**
 *
 * @author Dell
 */
public interface SanPhamxinDAO {
    public List<Sảnphẩm> getlist();
    public int createrOfUpdate(Sảnphẩm sp);
}
