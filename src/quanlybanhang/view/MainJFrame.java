/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.view;
import java.util.ArrayList;
import java.util.List;
import quanlybanhang.bean.DoanhmucBean;
import quanlybanhang.controller.ChuyenManHinhController;

public class MainJFrame extends javax.swing.JFrame {

    public MainJFrame() {
        initComponents();
        setTitle("Quản Lý Học Viên ");
        ChuyenManHinhController controller = new ChuyenManHinhController(jbnView);
        controller.setView(jpnSanPham,lblSanPham);
        List<DoanhmucBean> listItem = new ArrayList<>();
        listItem.add(new DoanhmucBean("SanPhamxin",jpnSanPham,lblSanPham));
        listItem.add(new DoanhmucBean("Khachhang",jpnkhachhang,lblkhachhang));
        listItem.add(new DoanhmucBean("HoaDon",jpnhoadon,lblhoadon));
        listItem.add(new DoanhmucBean("DoanhThu",jpndoanhthu,lbldoanhthu));
        controller.setEvent(listItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbnjoot = new javax.swing.JPanel();
        jbnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpnkhachhang = new javax.swing.JPanel();
        lblkhachhang = new javax.swing.JLabel();
        jpnhoadon = new javax.swing.JPanel();
        lblhoadon = new javax.swing.JLabel();
        jpndoanhthu = new javax.swing.JPanel();
        lbldoanhthu = new javax.swing.JLabel();
        jpnSanPham = new javax.swing.JPanel();
        lblSanPham = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbnMenu.setBackground(new java.awt.Color(82, 83, 81));

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/images/9039900_cart2_icon.png"))); // NOI18N
        jLabel1.setText("QUẢN LÝ BÁN HÀNG");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnkhachhang.setBackground(new java.awt.Color(76, 175, 80));

        lblkhachhang.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblkhachhang.setForeground(new java.awt.Color(255, 255, 255));
        lblkhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/images/target-audience.png"))); // NOI18N
        lblkhachhang.setText("Khách Hàng");

        javax.swing.GroupLayout jpnkhachhangLayout = new javax.swing.GroupLayout(jpnkhachhang);
        jpnkhachhang.setLayout(jpnkhachhangLayout);
        jpnkhachhangLayout.setHorizontalGroup(
            jpnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnkhachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnkhachhangLayout.setVerticalGroup(
            jpnkhachhangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnkhachhangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );

        jpnhoadon.setBackground(new java.awt.Color(76, 175, 80));

        lblhoadon.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblhoadon.setForeground(new java.awt.Color(255, 255, 255));
        lblhoadon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblhoadon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/images/calculator-bill.png"))); // NOI18N
        lblhoadon.setText("Hóa Đơn ");

        javax.swing.GroupLayout jpnhoadonLayout = new javax.swing.GroupLayout(jpnhoadon);
        jpnhoadon.setLayout(jpnhoadonLayout);
        jpnhoadonLayout.setHorizontalGroup(
            jpnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnhoadonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnhoadonLayout.setVerticalGroup(
            jpnhoadonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnhoadonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jpndoanhthu.setBackground(new java.awt.Color(76, 175, 80));

        lbldoanhthu.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lbldoanhthu.setForeground(new java.awt.Color(255, 255, 255));
        lbldoanhthu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldoanhthu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/images/revenue-euro.png"))); // NOI18N
        lbldoanhthu.setText("Doanh Thu");

        javax.swing.GroupLayout jpndoanhthuLayout = new javax.swing.GroupLayout(jpndoanhthu);
        jpndoanhthu.setLayout(jpndoanhthuLayout);
        jpndoanhthuLayout.setHorizontalGroup(
            jpndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpndoanhthuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbldoanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jpndoanhthuLayout.setVerticalGroup(
            jpndoanhthuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpndoanhthuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbldoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpnSanPham.setBackground(new java.awt.Color(76, 175, 80));

        lblSanPham.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblSanPham.setForeground(new java.awt.Color(255, 255, 255));
        lblSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/images/selling.png"))); // NOI18N
        lblSanPham.setText("Sản Phẩm");

        javax.swing.GroupLayout jpnSanPhamLayout = new javax.swing.GroupLayout(jpnSanPham);
        jpnSanPham.setLayout(jpnSanPhamLayout);
        jpnSanPhamLayout.setHorizontalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnSanPhamLayout.setVerticalGroup(
            jpnSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSanPhamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nhóm ......");

        javax.swing.GroupLayout jbnMenuLayout = new javax.swing.GroupLayout(jbnMenu);
        jbnMenu.setLayout(jbnMenuLayout);
        jbnMenuLayout.setHorizontalGroup(
            jbnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jbnMenuLayout.createSequentialGroup()
                .addGroup(jbnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jbnMenuLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jbnMenuLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jbnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpndoanhthu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnhoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpnkhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jbnMenuLayout.setVerticalGroup(
            jbnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbnMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jpnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jpnkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jpnhoadon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jpndoanhthu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(31, 31, 31))
        );

        jbnView.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jbnViewLayout = new javax.swing.GroupLayout(jbnView);
        jbnView.setLayout(jbnViewLayout);
        jbnViewLayout.setHorizontalGroup(
            jbnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );
        jbnViewLayout.setVerticalGroup(
            jbnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jbnjootLayout = new javax.swing.GroupLayout(jbnjoot);
        jbnjoot.setLayout(jbnjootLayout);
        jbnjootLayout.setHorizontalGroup(
            jbnjootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jbnjootLayout.createSequentialGroup()
                .addComponent(jbnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jbnjootLayout.setVerticalGroup(
            jbnjootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jbnjootLayout.createSequentialGroup()
                .addGroup(jbnjootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbnView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbnjoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jbnjoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jbnMenu;
    private javax.swing.JPanel jbnView;
    private javax.swing.JPanel jbnjoot;
    private javax.swing.JPanel jpnSanPham;
    private javax.swing.JPanel jpndoanhthu;
    private javax.swing.JPanel jpnhoadon;
    private javax.swing.JPanel jpnkhachhang;
    private javax.swing.JLabel lblSanPham;
    private javax.swing.JLabel lbldoanhthu;
    private javax.swing.JLabel lblhoadon;
    private javax.swing.JLabel lblkhachhang;
    // End of variables declaration//GEN-END:variables
}
