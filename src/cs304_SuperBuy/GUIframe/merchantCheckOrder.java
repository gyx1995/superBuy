package cs304_SuperBuy.GUIframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xingrex on 2017-11-19.
 */
public class merchantCheckOrder {
    private JButton searchButton;
    private JTextField orderIDValue;
    private JComboBox comboBox1;
    public JPanel mainPanel;


    public merchantCheckOrder(String mid) {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String oid = orderIDValue.getText();
                Integer st = 0;
                String oSta = comboBox1.getSelectedItem().toString();

                if (oSta == "In process"){
                    st = 2;
                }else if (oSta == "Shipped"){
                    st = 3;
                }else if (oSta == "Delivered") {
                    st = 1;
                }else st = 0;
//                JTable jt= new JTable();
//                String column[]={"Order ID","Order Status", "Item ID"};

//                List<List<Object>> rs = returnResultSet.checkOrder(0,3,oid,st);
//                DefaultTableModel table = (DefaultTableModel) jt.getModel();
//                table.setColumnIdentifiers(column);
//                for (int i = 0; i < rs.size(); i++) {
//                    Vector<Object> rowVector = new Vector<>();
//                    rowVector.addAll(rs.get(i));
//                    table.addRow(rowVector);
//                }

                JFrame orderPanel = new JFrame(" Order Operation ");
                orderPanel.setContentPane(new merchantOrderOperation(mid,oid,st).panel1);
                orderPanel.pack();
                orderPanel.setVisible(true);

//                JFrame orderPanel1 = new JFrame(" Check Order information ");
//                JScrollPane sp = new JScrollPane(jt);
//                orderPanel1.add(sp);
//                orderPanel1.setSize(500,400);
//                orderPanel1.setVisible(true);




//                 String oid = orderIDValue.getText();
//                Integer st = 0;
//                String oSta = comboBox1.getSelectedItem().toString();
//
//                if (oSta == "In process"){
//                    st = 3;
//                }else if (oSta == "Shipped"){
//                    st = 2;
//
//                }else if (oSta == "Delivered") {
//                    st = 1;
//                }else st = 0;
//                JTable jt= new JTable();
//                String column[]={"Order ID","Customer NAME","Order Status"};
//
//                List<List<Object>> rs = returnResultSet.checkOrder(0,3,oid,st);
//                DefaultTableModel table = (DefaultTableModel) jt.getModel();
//                table.setColumnIdentifiers(column);
//                for (int i = 0; i < rs.size(); i++) {
//                    Vector<Object> rowVector = new Vector<>();
//                    rowVector.addAll(rs.get(i));
//                    table.addRow(rowVector);
//                }
//
//                JFrame orderPanel = new JFrame(" Order Operation ");
//                orderPanel.setContentPane(new merchantOrderOperation().panel1);
//                orderPanel.pack();
//                orderPanel.setVisible(true);
//
//                JFrame orderPanel1 = new JFrame(" Check Order information ");
//                JScrollPane sp = new JScrollPane(jt);
//                orderPanel1.add(sp);
//                orderPanel1.setSize(500,400);
//                orderPanel1.setVisible(true);
            }
        });
    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("LoginMain");
//        int i = 3;
//        String mid = "" + i;
//        frame.setContentPane(new merchantCheckOrder(mid).mainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

}