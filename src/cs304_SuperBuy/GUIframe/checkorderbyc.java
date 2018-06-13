package cs304_SuperBuy.GUIframe;

import cs304_SuperBuy.backend.returnResultSet;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class checkorderbyc {
    public JPanel panel1;
    private JTextField textFieldorderIDbyC;
    private JList viewOrderbystatusC;
    private JButton viewMyOrdersButton;
    private JTable table1;
    private JComboBox comboBox1;

    public checkorderbyc(String cid) {
        viewMyOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Integer cidofint = Integer.valueOf((String) cid);

                String passtooid = textFieldorderIDbyC.getText().toString();
//
//                if (!textFieldorderIDbyC.getText().isEmpty()) {
//                    passtooid = Integer.valueOf((String) textFieldorderIDbyC.getText());
//
//                }

                Integer selecteditem = comboBox1.getSelectedIndex();


                returnResultSet rss = new returnResultSet();
                // List<Map<String, Object>> checkOrder(Integer cid, Integer id, Integer type)
                //checkOrderforC(Integer cid, Integer mid, String id, Integer type)
                List<List<Object>> rs = rss.checkOrderforC(cidofint,0,passtooid,selecteditem);




                int columnCount = 4;
                //order.ooid, orders.statu, item.iname,item.price
                String cols[] = {"order id", "order status", "item name", "item price"};

                DefaultTableModel defaultTableModel = (DefaultTableModel) table1.getModel();

                defaultTableModel.setRowCount(0);
                defaultTableModel.setColumnIdentifiers(cols);
                // Data of the table.


                for (int i = 0; i<rs.size();i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    defaultTableModel.addRow(rowVector);
                }


//                JFrame f = new JFrame("View my order");
//
//                JScrollPane jspane = new JScrollPane(table1);
//                f.add(jspane);
//               f.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//                f.setVisible(true);

            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Cdsdf");
//        frame.setContentPane(new checkorderbyc().panel1);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
