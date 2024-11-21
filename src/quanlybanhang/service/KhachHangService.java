 
package quanlybanhang.service;

import java.util.List;
import quanlybanhang.moder.Kháchhang;
public interface  KhachHangService {
    public List<Kháchhang> getlist();
    public int createrOfUpdate(Kháchhang kh);
}
