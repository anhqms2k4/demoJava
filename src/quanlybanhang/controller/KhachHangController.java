
package quanlybanhang.controller;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import quanlybanhang.moder.Kháchhang;
import quanlybanhang.service.KhachHangService;
import quanlybanhang.service.KhachHangServiceImpl;
public class KhachHangController {
     private JButton btnSua;
   
    private JTextField jtfMaKH;
    private JTextField jtfTenKhachHang;
    private JTextField jtfSoDT;
    private JTextArea jtaDiaChi;
    private JTextField jtfLoaiKH;
    private Kháchhang kh = null;
    private JLabel lblMng;
    private KhachHangService spSV =null;

    public KhachHangController(JButton btnSua, JTextField jtfMaKH, JTextField jtfTenKhachHang, JTextField jtfSoDT, JTextArea jtaDiaChi, JTextField jtfLoaiKH, JLabel lblMng) {
        this.btnSua = btnSua;
        this.jtfMaKH = jtfMaKH;
        this.jtfTenKhachHang = jtfTenKhachHang;
        this.jtfSoDT = jtfSoDT;
        this.jtaDiaChi = jtaDiaChi;
        this.jtfLoaiKH = jtfLoaiKH;
        this.lblMng = lblMng;
        this.spSV = new KhachHangServiceImpl();
    }
    public void setView(Kháchhang kh) {
    this.kh = kh;
    
    // Hiển thị thông tin khách hàng lên các trường nhập liệu
    jtfMaKH.setText("#" + kh.getMaKhachHang());
    jtfTenKhachHang.setText(kh.getTenKh());
    jtfSoDT.setText(kh.getSoDt());
    jtaDiaChi.setText(kh.getDiaChi());
    jtfLoaiKH.setText(kh.getLoaiKh());
}
    public void setEvent(){
    btnSua.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Kiểm tra nếu tên khách hàng hoặc số điện thoại chưa được nhập
            if(jtfTenKhachHang.getText().length() == 0 || jtfSoDT.getText().length() == 0){
                lblMng.setText("Vui lòng nhập tên khách hàng và số điện thoại");
            } else {
                // Cập nhật thông tin khách hàng
                kh.setTenKh(jtfTenKhachHang.getText());
                kh.setSoDt(jtfSoDT.getText());
                kh.setDiaChi(jtaDiaChi.getText());
                kh.setLoaiKh(jtfLoaiKH.getText());

                // Cập nhật khách hàng vào cơ sở dữ liệu
                int lastID = spSV.createrOfUpdate(kh);
                kh.setMaKhachHang(lastID); // Cập nhật mã khách hàng mới
                jtfMaKH.setText("#" + lastID); // Hiển thị mã khách hàng
                lblMng.setText("Cập nhật dữ liệu thành công");
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            btnSua.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnSua.setBackground(new Color(100, 212, 23));
        }
    });
}

    
}
