/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package quanlybanhang.dao;
import java.util.List;
 import quanlybanhang.moder.Kháchhang;
public interface KhachHangDAO {
    public List<Kháchhang> getlist();
    public int createrOfUpdate(Kháchhang kh);
}
