 
package quanlybanhang.utility;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlybanhang.moder.Sảnphẩm;
/**
 *
 * @author Dell
 */
public class ClassTableModel {
    public DefaultTableModel setTableSanPhamxin(List<Sảnphẩm> listItem, String[] listColumn) {
    DefaultTableModel dtm = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
        
        };
    dtm.setColumnIdentifiers(listColumn);
    int columns =listColumn.length;
    Object[] obj =null;
    int rows = listItem.size();
    if(rows >  0 ){
        for(int i = 0 ;i<rows;i++){
            obj = new Object[columns];
            Sảnphẩm sp = listItem.get(i);
            obj[0] = sp.getMa_san_pham();
            obj[1] = sp.getTen_Sp();
            obj[2] = sp.getGia_ban();
            obj[3] = sp.getNgaysx();
            obj[4] = sp.getHang_sx();
            obj[5] = sp.getCauHinh();
            dtm.addRow(obj);
        }
    }
    
     return dtm;
}
    
}
