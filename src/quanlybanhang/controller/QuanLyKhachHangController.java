package quanlybanhang.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import quanlybanhang.moder.Kháchhang;
import quanlybanhang.service.KhachHangService;
import quanlybanhang.service.KhachHangServiceImpl;
import quanlybanhang.utility.ClassTableModel2;
import quanlybanhang.view.KhachHangJFrame;

public class QuanLyKhachHangController {
    private JPanel jpnView; // Panel hiển thị bảng khách hàng
    private JButton btnAdd; // Nút thêm khách hàng
    private JTextField jtfSearch; // Ô tìm kiếm khách hàng
    private KhachHangService khachHangService; // Service xử lý logic
    private String[] listColumn = {
        "Mã Khách Hàng", 
        "Tên Khách Hàng", 
        "Số Điện Thoại", 
        "Địa Chỉ", 
        "Loại Khách Hàng"
    };
    private TableRowSorter<DefaultTableModel> rowSorter; // Bộ lọc tìm kiếm

    public QuanLyKhachHangController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.khachHangService = new KhachHangServiceImpl(); // Khởi tạo service
    }

    public void setDateToTable() {
        // Lấy danh sách khách hàng từ service
        List<Kháchhang> listItem = khachHangService.getlist();

        // Tạo bảng với dữ liệu và tiêu đề cột
        DefaultTableModel model = new ClassTableModel2().setTableKhachHang(listItem, listColumn);
        JTable table = new JTable(model);

        // Cấu hình bộ lọc tìm kiếm
        rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);

        // Lắng nghe sự thay đổi trong ô tìm kiếm để thực hiện bộ lọc
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }

            private void filterTable() {
                String text = jtfSearch.getText();
                if (text.trim().isEmpty()) {
                    rowSorter.setRowFilter(null); // Không lọc
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text)); // Lọc không phân biệt hoa thường
                }
            }
        });
         table.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                int selectedRowIndex = table.getSelectedRow();
                selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);

                // Lấy dữ liệu khách hàng từ dòng được chọn
                Kháchhang kh = new Kháchhang();
                kh.setMaKhachHang((int) model.getValueAt(selectedRowIndex, 0));
                kh.setTenKh(model.getValueAt(selectedRowIndex, 1).toString());
                kh.setSoDt(model.getValueAt(selectedRowIndex, 2).toString());
                kh.setDiaChi(model.getValueAt(selectedRowIndex, 3).toString());
                kh.setLoaiKh(model.getValueAt(selectedRowIndex, 4).toString());

                // Mở JFrame để chỉnh sửa thông tin khách hàng
                KhachHangJFrame frame = new KhachHangJFrame(kh);
                frame.setTitle("Chỉnh sửa thông tin khách hàng");
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                frame.setResizable(false);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // Cập nhật lại bảng sau khi chỉnh sửa
                setDateToTable();
            }
        }
    });

        // Tùy chỉnh giao diện bảng
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.setRowHeight(50);
        table.validate();
        table.repaint();

        // Thêm bảng vào JScrollPane để hỗ trợ cuộn
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1300, 400));

        // Cập nhật panel hiển thị
        jpnView.removeAll();
        jpnView.setLayout(new BorderLayout());
        jpnView.add(scrollPane, BorderLayout.CENTER);
        jpnView.validate();
        jpnView.repaint();
    }

    public void setEvent() {
    btnAdd.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Mở JFrame thêm/sửa khách hàng
            KhachHangJFrame frame = new KhachHangJFrame(new Kháchhang());
            frame.setTitle("Thông tin khách hàng");
            frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); 
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Cập nhật lại bảng sau khi thêm khách hàng
            setDateToTable();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            btnAdd.setBackground(Color.RED);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btnAdd.setBackground(new Color(100, 212, 32));
        }
    });
}
}
