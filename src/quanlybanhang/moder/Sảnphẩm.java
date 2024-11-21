/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang.moder;

import java.util.Date;


public class Sảnphẩm {
    private int ma_san_pham;
    private String ten_Sp;
    private int gia_ban;

    public Sảnphẩm() {
    }

    
    public Sảnphẩm(int ma_san_pham, String ten_Sp, int gia_ban, Date ngaysx, String hang_sx, String cauHinh) {
        this.ma_san_pham = ma_san_pham;
        this.ten_Sp = ten_Sp;
        this.gia_ban = gia_ban;
        this.ngaysx = ngaysx;
        this.hang_sx = hang_sx;
        this.cauHinh = cauHinh;
    }

    public int getMa_san_pham() {
        return ma_san_pham;
    }

    public void setMa_san_pham(int ma_san_pham) {
        this.ma_san_pham = ma_san_pham;
    }

    public String getTen_Sp() {
        return ten_Sp;
    }

    public void setTen_Sp(String ten_Sp) {
        this.ten_Sp = ten_Sp;
    }

    public int getGia_ban() {
        return gia_ban;
    }

    public void setGia_ban(int gia_ban) {
        this.gia_ban = gia_ban;
    }

    public Date getNgaysx() {
        return ngaysx;
    }

    public void setNgaysx(Date ngaysx) {
        this.ngaysx = ngaysx;
    }

    public String getHang_sx() {
        return hang_sx;
    }

    public void setHang_sx(String hang_sx) {
        this.hang_sx = hang_sx;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }
    private Date ngaysx;
    private String hang_sx;
    private String cauHinh;
}
