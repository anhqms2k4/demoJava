package quanlybanhang.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import quanlybanhang.bean.DoanhmucBean;
import quanlybanhang.view.DoanhThuJPanel;
import quanlybanhang.view.HoaDonJPanel;
import quanlybanhang.view.KhachhangJPanel;
import quanlybanhang.view.SanPhamxinJPanel;

public class ChuyenManHinhController {
    private final JPanel root;
    private List<DoanhmucBean> listItem = null;

    public ChuyenManHinhController(JPanel jpnroot) {
        this.root = jpnroot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        // Set màu nền cho các panel
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));

        // Xóa tất cả các thành phần của root và thêm một thành phần mới
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new SanPhamxinJPanel());
        root.validate();
        root.repaint();
    }

    public void setEvent(List<DoanhmucBean> listItem) {
        this.listItem = listItem;
        if (listItem != null) {
            for (DoanhmucBean item : listItem) {
                if (item.getJlb() != null) {
                    item.getJlb().addMouseListener(new LabelEvent(root, item.getKind(), item.getJpn(), item.getJlb()));
                }
            }
        }
    }

    class LabelEvent implements MouseListener {
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel jlbItem;
        private String kindSelected;

        public LabelEvent(JPanel node, String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            try {
                // Xử lý khi nhấn vào từng label
                switch (kind) {
                    case "SanPhamxin":
                        node = new SanPhamxinJPanel();
                        break;
                    case "Khachhang":
                        node = new KhachhangJPanel();
                        break;
                    case "HoaDon":
                        node = new HoaDonJPanel();
                        break;
                    case "DoanhThu":
                        node = new DoanhThuJPanel();
                        break;
                    default:
                        break;
                }
                root.removeAll();
                root.setLayout(new BorderLayout());
                root.add(node);
                root.validate();
                root.repaint();
                setChangeBackgroud(kind);
            } catch (SQLException ex) {
                Logger.getLogger(ChuyenManHinhController.class.getName()).log(Level.SEVERE, null, ex);
            }
}

        @Override
        public void mousePressed(MouseEvent e) {
            // Khi nhấn vào label, thay đổi màu nền
            kindSelected = kind;
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // Không làm gì ở đây
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // Khi chuột đi vào, thay đổi màu nền
            jpnItem.setBackground(new Color(96, 100, 191));
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Khi chuột rời khỏi, kiểm tra và đổi lại màu nền nếu cần
            if (kindSelected != null && !kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(76, 175, 80));
                jlbItem.setBackground(new Color(76, 175, 80));
            }
        }
    }

    private void setChangeBackgroud(String kind) {
        // Thay đổi màu nền của các panel dựa trên kind
        for (DoanhmucBean item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                item.getJpn().setBackground(new Color(76, 175, 80));
                item.getJlb().setBackground(new Color(76, 175, 80));
            }
        }
    }
}
