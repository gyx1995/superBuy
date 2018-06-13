package cs304_SuperBuy.GUIframe;

import cs304_SuperBuy.backend.returnResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by xingrex on 2017-11-19.
 */
public class customerCheckOrder {


    public JPanel panel1;
    private JTextField textFieldSearchbyMname;
    private JList sortbyRatingmultiple;
    private JComboBox comboBoxSortby;
    private JList merchanttypemultiple;
    private JButton searchMerchant;
    private JTextField textFieldmid;
    private JTable returnmerchantstable;
    private JTextField itemNameValue;
    private JTextField textField2;
    private JButton placeOrderButton;
    private JLabel highestPrice;
    private JScrollPane JSP;

    public customerCheckOrder(String id) {
        System.out.print(id);
        searchMerchant.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                List selectedIndicesforRating =  sortbyRatingmultiple.getSelectedValuesList();
                String mername = textFieldSearchbyMname.getText();
                int sortby = comboBoxSortby.getSelectedIndex();
                List selectedmerTypes =  merchanttypemultiple.getSelectedValuesList();
                String mid = textFieldmid.getText().toString();
                String hp = textField2.getText().toString();
                String iname = itemNameValue.getText().toString();


                DefaultTableModel table = (DefaultTableModel) returnmerchantstable.getModel();

                String column[]={"Merchant name", "rating","Merchant Type","Item name",
                        "price","Stock"};

                table.setRowCount(0);

                List<List<Object>> rs = returnResultSet.searchMerchant2(mid,selectedmerTypes,mername,selectedIndicesforRating,iname,hp,sortby);
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {

                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }
                //               JFrame orderPanel = new JFrame(" Order Operation ");
//                orderPanel.setContentPane(new merchantOrderOperation(,).panel1);
//                orderPanel.pack();
//                orderPanel.setVisible(true);


//                if (oSta == "In process"){
//                    st = 2;
//                }else if (oSta == "Shipped"){
//                    st = 3;
//                }else if (oSta == "Delivered") {
//                    st = 1;
//                }else st = 0;
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

        returnmerchantstable.setRowSelectionAllowed(true);
        returnmerchantstable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] sel = returnmerchantstable.getSelectedRows();

                ArrayList<String> list = new ArrayList<String>();

                for (int i = 0; i < sel.length; i ++){
                    list.add(returnmerchantstable.getValueAt(sel[i],3).toString());
                }

                System.out.print(list);
                int newoid = returnResultSet.placeOrder(id,list);

                JOptionPane.showMessageDialog(null,"oder compelete!! Order ID: " + newoid);
            }
        });
    }
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("LoginMain");
//        frame.setContentPane(new customerCheckOrder("35").panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

}
