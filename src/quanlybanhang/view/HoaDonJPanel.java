
package quanlybanhang.view;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonJPanel extends javax.swing.JPanel {
    private static  String url = "jdbc:mysql://localhost:3306/quảnlýbánhàng";
    private static    String user = "root";
    private static    String password = "123456";
    
    Connection sqlconn =null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q,i;
    
public void getDataTable() {
    try {
        // Kết nối tới cơ sở dữ liệu
        sqlconn = DriverManager.getConnection(url, user, password);

        // Câu lệnh SQL
        String sql = "SELECT * FROM hoadon ORDER BY maHD, ma_san_pham";
        pst = sqlconn.prepareStatement(sql);

        // Thực thi câu lệnh và lấy dữ liệu
        rs = pst.executeQuery();
        ResultSetMetaData stData = rs.getMetaData();
        q = stData.getColumnCount();

        // Xóa dữ liệu cũ trên bảng (nếu có)
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        RecordTable.setRowCount(0);

        // Duyệt qua từng dòng dữ liệu trong ResultSet
        while (rs.next()) {
            Vector<Object> columnData = new Vector<>();
            for (i = 1; i <= q; i++) { // Lấy tất cả các cột theo thứ tự
                columnData.add(rs.getObject(i)); // Lấy dữ liệu từng cột
            }
            RecordTable.addRow(columnData); // Thêm dòng dữ liệu vào JTable
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi tải dữ liệu: " + ex.getMessage());
    } finally {
        try {
            // Đóng kết nối và tài nguyên
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (sqlconn != null) sqlconn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + ex.getMessage());
        }
    }
}

    public HoaDonJPanel()throws SQLException{
        initComponents();
        getDataTable();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jtfDate = new javax.swing.JTextField();
        jtfSeach = new javax.swing.JTextField();
        jtfMaSP = new javax.swing.JTextField();
        jtfMaHoaDon = new javax.swing.JTextField();
        jtfHinhThucThanhToan = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jtfNVBan = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi Tiết Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Mã Sản Phẩm ", "Hình Thức Thanh Toán", "Ngày Bán", "Nhân Viên Bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        );

        jtfDate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfDate.setText(" ");

        jtfSeach.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSeach.setText(" ");

        jtfMaSP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfMaSP.setText(" ");

        jtfMaHoaDon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfMaHoaDon.setText(" ");

        jtfHinhThucThanhToan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfHinhThucThanhToan.setText(" ");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("+ Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Sửa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton3.setText("Xóa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jtfNVBan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfNVBan.setText(" ");

        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Mã Hóa Đơn :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mã Sản Phẩm :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Hình Thức Thanh Toán :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Bán :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Nhân Viên Bán :");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Tìm Kiếm :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(64, 64, 64))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfNVBan, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(9, 9, 9)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNVBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfHinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   try {
    // Kết nối tới cơ sở dữ liệu
    sqlconn = DriverManager.getConnection(url, user, password);

    // Câu lệnh SQL để cập nhật thông tin hóa đơn theo mã hóa đơn
    String sql = "UPDATE hoadon SET ma_san_pham = ?, hinhThucThanhToan = ?, ngayBan = ?, nhanVienBan = ? WHERE maHD = ?";

    // Chuẩn bị câu lệnh PreparedStatement
    pst = sqlconn.prepareStatement(sql);
    pst.setString(1, jtfMaSP.getText()); // Cập nhật mã sản phẩm từ JTextField
    pst.setString(2, jtfHinhThucThanhToan.getText()); // Cập nhật hình thức thanh toán
    pst.setString(3, jtfDate.getText()); // Cập nhật ngày bán
    pst.setString(4, jtfNVBan.getText()); // Cập nhật nhân viên bán
    pst.setString(5, jtfMaHoaDon.getText()); // Dùng mã hóa đơn để tìm bản ghi cần cập nhật

    // Thực thi câu lệnh cập nhật
    int rowsAffected = pst.executeUpdate();

    // Kiểm tra nếu cập nhật thành công
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Đã cập nhật hóa đơn thành công!");
    } else {
        JOptionPane.showMessageDialog(null, "Không tìm thấy hóa đơn với mã đã nhập!");
    }

    // Cập nhật lại bảng dữ liệu
    getDataTable();
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật hóa đơn: " + ex.getMessage());
} 

    }//GEN-LAST:event_jButton2ActionPerformed

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection sqlconn = null;
    PreparedStatement pst = null;
    try {
    // Kết nối tới cơ sở dữ liệu
    sqlconn = DriverManager.getConnection(url, user, password);

    // Kiểm tra xem mã hóa đơn đã tồn tại chưa
    String checkSql = "SELECT COUNT(*) FROM hoadon WHERE maHD = ?";
    pst = sqlconn.prepareStatement(checkSql);
    pst.setString(1, jtfMaHoaDon.getText());
    rs = pst.executeQuery();
    
    if (rs.next() && rs.getInt(1) > 0) {
        // Nếu mã hóa đơn đã tồn tại
        JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại. Vui lòng chọn mã khác.");
    } else {
        // Câu lệnh SQL để thêm hóa đơn mới
        String sql = "INSERT INTO hoadon(maHD, ma_san_pham, hinhThucThanhToan, ngayBan, nhanVienBan) VALUES (?, ?, ?, ?, ?)";
        
        // Chuẩn bị câu lệnh PreparedStatement để thêm hóa đơn
        pst = sqlconn.prepareStatement(sql);
        pst.setString(1, jtfMaHoaDon.getText());
        pst.setString(2, jtfMaSP.getText());
        pst.setString(3, jtfHinhThucThanhToan.getText());
        pst.setString(4, jtfDate.getText());
        pst.setString(5, jtfNVBan.getText());

        // Thực thi câu lệnh cập nhật
        pst.executeUpdate();

        // Thông báo thành công
        JOptionPane.showMessageDialog(null, "Đã Hoàn Thành Thêm Mới");

        // Cập nhật lại bảng dữ liệu
        getDataTable();
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Lỗi khi thêm hóa đơn: " + ex.getMessage());
} finally {
        try {
            // Đóng kết nối và tài nguyên
            if (pst != null) pst.close();
            if (sqlconn != null) sqlconn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + ex.getMessage());
        }
    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    try {
    // Kết nối tới cơ sở dữ liệu
    sqlconn = DriverManager.getConnection(url, user, password);

    // Câu lệnh SQL để xóa hóa đơn theo mã hóa đơn
    String sql = "DELETE FROM hoadon WHERE maHD = ?";

    // Chuẩn bị câu lệnh PreparedStatement
    pst = sqlconn.prepareStatement(sql);
    pst.setString(1, jtfMaHoaDon.getText());
    pst.executeUpdate();
    JOptionPane.showMessageDialog(null, "Đã xóa hóa đơn thành công!");
  
    

    // Cập nhật lại bảng dữ liệu
    getDataTable();
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Lỗi khi xóa hóa đơn: " + ex.getMessage());
} 

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        int selectRows = jTable1.getSelectedRow();
        jtfMaHoaDon.setText(RecordTable.getValueAt(selectRows, 0).toString());
        jtfMaSP.setText(RecordTable.getValueAt(selectRows, 1).toString());
        jtfHinhThucThanhToan.setText(RecordTable.getValueAt(selectRows, 2).toString());
        jtfDate.setText(RecordTable.getValueAt(selectRows, 3).toString());
        jtfNVBan.setText(RecordTable.getValueAt(selectRows, 4).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
        // Kết nối tới cơ sở dữ liệu
        sqlconn = DriverManager.getConnection(url, user, password);

        // Lấy từ khóa tìm kiếm từ ô nhập liệu
        String searchKeyword = jtfSeach.getText().trim();

        // Câu lệnh SQL với điều kiện tìm kiếm
        String sql = "SELECT * FROM hoadon WHERE maHD LIKE ? OR ma_san_pham LIKE ? OR hinhThucThanhToan LIKE ? OR nhanVienBan LIKE ?";
        pst = sqlconn.prepareStatement(sql);

        // Gán giá trị cho tham số tìm kiếm, dùng dấu % để tìm kiếm tương đối (LIKE)
        pst.setString(1, "%" + searchKeyword + "%");
        pst.setString(2, "%" + searchKeyword + "%");
        pst.setString(3, "%" + searchKeyword + "%");
        pst.setString(4, "%" + searchKeyword + "%");

        // Thực thi câu lệnh và lấy kết quả
        rs = pst.executeQuery();
        ResultSetMetaData stData = rs.getMetaData();
        q = stData.getColumnCount();

        // Xóa dữ liệu cũ trên bảng (nếu có)
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
        RecordTable.setRowCount(0);

        // Duyệt qua từng dòng dữ liệu trong ResultSet và hiển thị trong bảng
        while (rs.next()) {
            Vector<Object> columnData = new Vector<>();
            for (i = 1; i <= q; i++) {
                columnData.add(rs.getObject(i)); // Lấy dữ liệu từng cột
            }
            RecordTable.addRow(columnData); // Thêm dòng dữ liệu vào JTable
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm: " + ex.getMessage());
    } finally {
        try {
            // Đóng kết nối và tài nguyên
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (sqlconn != null) sqlconn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + ex.getMessage());
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfDate;
    private javax.swing.JTextField jtfHinhThucThanhToan;
    private javax.swing.JTextField jtfMaHoaDon;
    private javax.swing.JTextField jtfMaSP;
    private javax.swing.JTextField jtfNVBan;
    private javax.swing.JTextField jtfSeach;
    // End of variables declaration//GEN-END:variables
}
