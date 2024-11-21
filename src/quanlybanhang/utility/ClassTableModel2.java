package quanlybanhang.utility;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlybanhang.moder.Kháchhang;  // Sử dụng model.KhachHang


public class ClassTableModel2 {

    // Phương thức tạo DefaultTableModel cho Khách Hàng
    public DefaultTableModel setTableKhachHang(List<Kháchhang> listItem, String[] listColumn) {
        DefaultTableModel dtm = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Cấm chỉnh sửa bảng
            }
        };
        
        dtm.setColumnIdentifiers(listColumn);  // Thiết lập tên cột
        int columns = listColumn.length;
        Object[] obj = null;
        int rows = listItem.size();  // Số lượng khách hàng
        
        if (rows > 0) {
            for (int i = 0; i < rows; i++) {
                obj = new Object[columns];
                Kháchhang kh = listItem.get(i);  // Lấy khách hàng từ list
                
                obj[0] = kh.getMaKhachHang();  // Mã khách hàng
                obj[1] = kh.getTenKh();         // Tên khách hàng
                obj[2] = kh.getSoDt();          // Số điện thoại
                obj[3] = kh.getDiaChi();        // Địa chỉ
                obj[4] = kh.getLoaiKh();        // Loại khách hàng
                
                dtm.addRow(obj);  // Thêm dòng vào bảng
            }
        }
        
        return dtm;  // Trả về bảng dữ liệu
    }
}
