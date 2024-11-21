package quanlybanhang.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import quanlybanhang.moder.Sảnphẩm;
import quanlybanhang.service.SanPhamxinService;
import quanlybanhang.service.SanPhamxinServiceImpl;
import java.util.List;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import quanlybanhang.utility.ClassTableModel;
import quanlybanhang.view.SanPhamJFrame;

public class QuanLySanPhamController {
    private JPanel jpnView; // Panel chứa bảng hiển thị
    private JButton btnAdd; // Nút thêm sản phẩm
    private JTextField jtfSearch; // Ô tìm kiếm sản phẩm
    private SanPhamxinService spv; // Service xử lý logic
    private String[] listColumn = {
        "Mã Sản Phẩm", 
        "Tên Sản Phẩm", 
        "Giá Bán", 
        "Ngày Sản Xuất", 
        "Hãng Sản Xuất", 
        "Cấu Hình"
    };
    private TableRowSorter<DefaultTableModel> rowSorter; // Bộ lọc tìm kiếm

    public QuanLySanPhamController(JPanel jpnView, JButton btnAdd, JTextField jtfSearch) {
        this.jpnView = jpnView;
        this.btnAdd = btnAdd;
        this.jtfSearch = jtfSearch;
        this.spv = new SanPhamxinServiceImpl(); // Khởi tạo service
    }

    public void setDateToTable() {
        // Lấy danh sách sản phẩm từ service
        List<Sảnphẩm> listItem = spv.getlist();

        // Tạo bảng với dữ liệu và tiêu đề cột
        DefaultTableModel model = new ClassTableModel().setTableSanPhamxin(listItem, listColumn);
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

        // Tùy chỉnh giao diện bảng
//        table.getColumnModel().getColumn(0).setMaxWidth(0);
//        table.getColumnModel().getColumn(0).setMinWidth(0);
//        table.getColumnModel().getColumn(0).setPreferredWidth(0);
//      
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                   if(e.getClickCount() == 2 && table.getSelectedRow() != -1){
                       DefaultTableModel moder = (DefaultTableModel) table.getModel();
                       int selectedRowIndex = table.getSelectedRow();
                       selectedRowIndex = table.convertRowIndexToModel(selectedRowIndex);
                       System.out.println(selectedRowIndex);
                       Sảnphẩm sp = new Sảnphẩm();
                       sp.setMa_san_pham((int) moder.getValueAt(selectedRowIndex, 0));
                       sp.setTen_Sp(moder.getValueAt(selectedRowIndex, 1).toString());
                       sp.setGia_ban((int) moder.getValueAt(selectedRowIndex, 2));
                       sp.setHang_sx((String) moder.getValueAt(selectedRowIndex, 4));
                       sp.setNgaysx((Date) moder.getValueAt(selectedRowIndex, 3));
                       sp.setCauHinh((String) moder.getValueAt(selectedRowIndex, 5));
                       SanPhamJFrame frame = new SanPhamJFrame(sp);
                       frame.setTitle("Thông tin sản phẩm");
                       frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Thay đổi hành vi đóng
                       frame.setResizable(false);
                       frame.setLocationRelativeTo(null);
                       frame.setVisible(true);
                       
                       
                   }
            }
            
        });

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
    public  void setEvent(){
        btnAdd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SanPhamJFrame frame = new SanPhamJFrame(new Sảnphẩm());
                       frame.setTitle("Thông tin sản phẩm");
                       frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // Thay đổi hành vi đóng
                       frame.setResizable(false);
                       frame.setLocationRelativeTo(null);
                       frame.setVisible(true);
             }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdd.setBackground(Color.red);
             }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdd.setBackground(new Color(100,212,32));
             }
        
        });
    }
}
