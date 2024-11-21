 
package quanlybanhang.moder;

import java.sql.*;


/**
 *
 * @author Dell
 */
public class HoaDon {
   private String nvBanHang;

    public String getNvBanHang() {
        return nvBanHang;
    }

    public void setNvBanHang(String nvBanHang) {
        this.nvBanHang = nvBanHang;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public String getThongTinSPDaBan() {
        return thongTinSPDaBan;
    }

    public void setThongTinSPDaBan(String thongTinSPDaBan) {
        this.thongTinSPDaBan = thongTinSPDaBan;
    }

  
    public String getHinhThucThanhToan() {
        return hinhThucThanhToan;
    }

    public void setHinhThucThanhToan(String hinhThucThanhToan) {
        this.hinhThucThanhToan = hinhThucThanhToan;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }
   private int maHD;
   private String thongTinSPDaBan;
   private String hinhThucThanhToan;
   private Date ngayBan;
}
