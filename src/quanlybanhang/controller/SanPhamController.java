 
package quanlybanhang.controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.*;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import quanlybanhang.moder.Sảnphẩm;
import quanlybanhang.service.SanPhamxinService;
import quanlybanhang.service.SanPhamxinServiceImpl;


public class SanPhamController {
    private JButton btnSua;
   
    private JTextField jtfMaSP;
    private JTextField jtfTenSanPham;
    private JTextField jtfGiaBan;
    private JTextField jtfHangSX;
    private JDateChooser jdcNgaySX;
    private JTextArea jtaCauHinh;  
    private JLabel lblMng;
    private Sảnphẩm sp = null;
 
    private SanPhamxinService spSV =null;
    
 
    
    
    public SanPhamController(JButton btnSua, JTextField jtfMaSP, JTextField jtfTenSanPham, JTextField jtfGiaBan, JTextField jtfHangSX, JDateChooser jdcNgaySX, JTextArea jtaCauHinh, JLabel lblMng) {
        this.btnSua = btnSua;
        this.jtfTenSanPham = jtfTenSanPham;
        this.jtfMaSP = jtfMaSP;
        this.jtfGiaBan = jtfGiaBan;
        this.jtfHangSX = jtfHangSX;
        this.jdcNgaySX = jdcNgaySX;
        this.jtaCauHinh = jtaCauHinh;
        this.lblMng = lblMng;
        this.spSV = new SanPhamxinServiceImpl();
    }

    

    public void setView(Sảnphẩm sp){
        this.sp = sp;
        
        jtfMaSP.setText("#"+sp.getMa_san_pham());
        jtfTenSanPham.setText(sp.getTen_Sp());
       
        jtfGiaBan.setText(sp.getGia_ban()+ "");
        jtfHangSX.setText(sp.getHang_sx());
        jdcNgaySX.setDate(sp.getNgaysx());
        jtaCauHinh.setText(sp.getCauHinh());
        
                
    }
    public void setEvent(){
        btnSua.addMouseListener(new MouseAdapter() {
            @Override
        public void mouseClicked(MouseEvent e) {
            if(jtfTenSanPham.getText().length() == 0 || jdcNgaySX.getDate() == null){
                lblMng.setText("Vui lòng nhập tên sản phẩm và ngày sản xuất");
            } else {
                // Cập nhật thông tin sản phẩm
                sp.setTen_Sp(jtfTenSanPham.getText());
                int giaBan = Integer.parseInt(jtfGiaBan.getText()); 
                sp.setGia_ban(giaBan);
                sp.setHang_sx(jtfHangSX.getText());
                sp.setCauHinh(jtaCauHinh.getText());
                java.sql.Date sqlDate = new java.sql.Date(jdcNgaySX.getDate().getTime());
                sp.setNgaysx(sqlDate);
                
                // Chỉ sử dụng mã sản phẩm đã có (không tạo mới)
                int lastID = spSV.createrOfUpdate(sp);
                sp.setMa_san_pham(lastID);
                jtfMaSP.setText("#" + lastID); // Hiển thị mã sản phẩm
                lblMng.setText("Cập nhật dữ liệu thành công");
            }
        }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnSua.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnSua.setBackground(new Color(100,212,23));
             }
        
        });
    }
}
