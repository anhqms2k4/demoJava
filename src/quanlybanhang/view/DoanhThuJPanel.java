/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package quanlybanhang.view;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DoanhThuJPanel extends javax.swing.JPanel {
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
        String sql = "SELECT * FROM doanhthu ORDER BY ma_san_pham";
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

/**
 *
 * @author Dell
 */


    /**
     * Creates new form DoanhThuJPanel
     */
    public DoanhThuJPanel() throws SQLException{
        initComponents();
        getDataTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtfMASP = new javax.swing.JTextField();
        jtfTenSP = new javax.swing.JTextField();
        jtfSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfDonGia = new javax.swing.JTextField();
        jtfDoanhThu = new javax.swing.JTextField();
        jtfSeach = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm ", "Số Lượng", "Đơn Gía", "Doanh Thu"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Tên Sản Phẩm");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Mã Sản Phẩm :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Số Lượng :");

        jtfMASP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfMASP.setText(" ");

        jtfTenSP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfTenSP.setText(" ");

        jtfSoLuong.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSoLuong.setText(" ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Đơn Gía");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Doanh Thu");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Tìm Kiếm :");

        jtfDonGia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfDonGia.setText(" ");

        jtfDoanhThu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfDoanhThu.setText(" ");

        jtfSeach.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtfSeach.setText(" ");

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

        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMASP, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jtfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addComponent(jtfMASP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtfDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSeach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection sqlconn = null;
        PreparedStatement pst = null;
        try {
    // Kết nối tới cơ sở dữ liệu
    sqlconn = DriverManager.getConnection(url, user, password);

    // Kiểm tra xem mã hóa đơn đã tồn tại chưa
    String checkSql = "SELECT COUNT(*) FROM hoadon WHERE maHD = ?";
    pst = sqlconn.prepareStatement(checkSql);
    pst.setString(1, jtfMASP.getText());
    rs = pst.executeQuery();

    if (rs.next() && rs.getInt(1) > 0) {
        // Nếu mã hóa đơn đã tồn tại
        JOptionPane.showMessageDialog(null, "Mã hóa đơn đã tồn tại. Vui lòng chọn mã khác.");
    } else {
        // Câu lệnh SQL để thêm hóa đơn mới vào bảng hoadon
        String sql = "INSERT INTO doanhthu(ma_san_pham, tenSP, soLuong, donGia, DoanhThu) VALUES (?, ?, ?, ?, ?)";
        pst = sqlconn.prepareStatement(sql);
        pst.setString(1, jtfMASP.getText());
        pst.setString(2, jtfTenSP.getText());
        pst.setString(3, jtfSoLuong.getText());
        pst.setString(4, jtfDonGia.getText());
        pst.setString(5, jtfDoanhThu.getText());
        
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
        if (rs != null) rs.close();
        if (pst != null) pst.close();
        if (sqlconn != null) sqlconn.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Lỗi khi đóng kết nối: " + ex.getMessage());
    }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
    // Kết nối tới cơ sở dữ liệu
    sqlconn = DriverManager.getConnection(url, user, password);

    // Câu lệnh SQL để cập nhật thông tin doanh thu theo mã sản phẩm
    String sql = "UPDATE doanhthu SET tenSP = ?, soLuong = ?, donGia = ?, DoanhThu = ? WHERE ma_san_pham = ?";

    // Chuẩn bị câu lệnh PreparedStatement
    pst = sqlconn.prepareStatement(sql);

    // Đảm bảo kiểu dữ liệu đúng khi cập nhật
    String tenSP = jtfTenSP.getText(); // Lấy tên sản phẩm từ JTextField
    int soLuong = Integer.parseInt(jtfSoLuong.getText()); // Chuyển đổi số lượng thành int
    int donGia = Integer.parseInt(jtfDonGia.getText()); // Chuyển đổi đơn giá thành int
    int doanhThu = soLuong * donGia; // Tính doanh thu

    // Đặt các giá trị vào PreparedStatement
    pst.setString(1, tenSP); // Cập nhật tên sản phẩm
    pst.setInt(2, soLuong); // Cập nhật số lượng
    pst.setInt(3, donGia); // Cập nhật đơn giá
    pst.setInt(4, doanhThu); // Cập nhật doanh thu (doanh thu = soLuong * donGia)
    pst.setInt(5, Integer.parseInt(jtfMASP.getText())); // Dùng mã sản phẩm để tìm bản ghi cần cập nhật

    // Thực thi câu lệnh cập nhật
    int rowsAffected = pst.executeUpdate();

    // Kiểm tra nếu cập nhật thành công
    if (rowsAffected > 0) {
        JOptionPane.showMessageDialog(null, "Đã cập nhật doanh thu cho sản phẩm thành công!");
    } else {
        JOptionPane.showMessageDialog(null, "Không tìm thấy sản phẩm với mã đã nhập!");
    }

    // Cập nhật lại bảng dữ liệu
    getDataTable();
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật doanh thu: " + ex.getMessage());
} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(null, "Lỗi khi chuyển đổi kiểu dữ liệu: " + ex.getMessage());
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            // Kết nối tới cơ sở dữ liệu
            sqlconn = DriverManager.getConnection(url, user, password);

            // Câu lệnh SQL để xóa hóa đơn theo mã hóa đơn
            String sql = "DELETE FROM doanhthu WHERE ma_san_pham = ?";

            // Chuẩn bị câu lệnh PreparedStatement
            pst = sqlconn.prepareStatement(sql);
            pst.setString(0, jtfMASP.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xóa hóa đơn thành công!");

            // Cập nhật lại bảng dữ liệu
            getDataTable();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa hóa đơn: " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            // Kết nối tới cơ sở dữ liệu
            sqlconn = DriverManager.getConnection(url, user, password);

            // Lấy từ khóa tìm kiếm từ ô nhập liệu
            String searchKeyword = jtfSeach.getText().trim();

            // Câu lệnh SQL với điều kiện tìm kiếm
            String sql = "SELECT * FROM doanhthu WHERE ma_san_pham LIKE ? OR tenSP LIKE ? OR soLuong LIKE ? OR donGia LIKE ? OR DoanhThu LIKE ?";

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

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel) jTable1.getModel();
int selectRows = jTable1.getSelectedRow();

if (selectRows != -1) {  // Kiểm tra nếu có dòng nào được chọn trong bảng
    // Lấy giá trị từ các cột trong dòng đã chọn và hiển thị vào các JTextField
    jtfMASP.setText(RecordTable.getValueAt(selectRows, 0).toString());  // ma_san_pham
    jtfTenSP.setText(RecordTable.getValueAt(selectRows, 1).toString());  // tenSP
    jtfSoLuong.setText(RecordTable.getValueAt(selectRows, 2).toString()); // soLuong
    jtfDonGia.setText(RecordTable.getValueAt(selectRows, 3).toString());  // donGia
    jtfDoanhThu.setText(RecordTable.getValueAt(selectRows, 4).toString()); // DoanhThu
} else {
    JOptionPane.showMessageDialog(null, "Vui lòng chọn một dòng trong bảng.");
}
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfDoanhThu;
    private javax.swing.JTextField jtfDonGia;
    private javax.swing.JTextField jtfMASP;
    private javax.swing.JTextField jtfSeach;
    private javax.swing.JTextField jtfSoLuong;
    private javax.swing.JTextField jtfTenSP;
    // End of variables declaration//GEN-END:variables
}
