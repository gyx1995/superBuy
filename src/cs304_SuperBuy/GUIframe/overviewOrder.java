package cs304_SuperBuy.GUIframe;
import cs304_SuperBuy.backend.returnResultSet;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * Created by xingrex on 2017-11-18.
 */
public class overviewOrder {
    private JButton searchingWithMerchantNameButton;
    private JTextField mNameValue;
    private JTextField cNameBValue;
    private JButton searchingWithOrderIDButton;
    private JTextField orderIDValue;
    private JButton showAllButton;
    public JPanel ordersPanel;
    private JButton searchngWithCustomerNameButton;
    private JComboBox comboBox1;
    private JButton searchingByOrderTypeButton;



    public overviewOrder() {
        searchingWithMerchantNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                returnBoolean rb = new returnBoolean;
//                String name = mNameValue.getText();
//                List sd = new ArrayList<String>;
//                sd.add("searchingWithMerchantName");
//                sd.add(name);
//
//                boolean exit = false;
//                if (exit){
//                String mname = mNameValue.getText();
//                JTable jt= new JTable();
//                String column[]={"Merchant ID","Merchant Name","Item ID","price","stock"};
//                ResultSet rs = returnResultSet.searchMerchant("", new ArrayList<String>(),mname,new ArrayList<String>(),1);
//                DefaultTableModel table = (DefaultTableModel) jt.getModel();
//                table.setColumnIdentifiers(column);
//
//                for (int i = 0; i < rs.size(); i++) {
//                    Vector<Object> rowVector = new Vector<>();
//                    rowVector.addAll(rs.get(i).values());
//                    table.addRow(rowVector);
//
//                }
//
//                JFrame f;
//                f=new JFrame("searching Merchant: " + mNameValue.getText());
//                JScrollPane sp = new JScrollPane(jt);
//                f.add(sp);
//                f.setSize(500,400);
//                f.setVisible(true);


            }
        });
        searchngWithCustomerNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jt= new JTable();
                String column[]={"Customer ID","NAME","phone number","address"};
                List<List<Object>> rs = returnResultSet.searchCustomer(cNameBValue.getText());
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }

                JFrame f;
                f=new JFrame("searching Customer: " + cNameBValue.getText());
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);




            }
        });
        searchingWithOrderIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable jt= new JTable();
                if (orderIDValue.getText().isEmpty()){
                    JFrame f = new JFrame("Error");
                    f.setVisible(true);
                    JOptionPane.showMessageDialog(f,"please enter Order ID");
                }

                Integer oid = Integer.valueOf(orderIDValue.getText());
                String column[]={"Order ID","Customer NAME","Order Status"};
                List<List< Object>> rs = returnResultSet.searchOrder(oid);
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }

                JFrame f;
                f=new JFrame(" Order " + orderIDValue.getText()+" information");
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);


            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jt= new JTable();
                String column[]={"Order ID","Customer NAME","Order Status"};
                List<List<Object>> rs = returnResultSet.showAllOrders();
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }
                JFrame f;
                f=new JFrame(" Order information");
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);



            }
        });
        searchingByOrderTypeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jt= new JTable();
                String column[]={"Order ID","Customer NAME","Customer Address"};
                String str = comboBox1.getSelectedItem().toString();
                String input = new String();

                if (str == "In process"){
                    input = "InProcess";
                }

                if (str == "Shipped ")
                    input = "Shipped";

                if (str == "Delivered")
                 input = "Delivered";

                List<List<Object>> rs = returnResultSet.searchByOrderStatus(input);
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }
                JFrame f;
                f=new JFrame(" Order Status "+ comboBox1.getSelectedItem().toString().trim());
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);

            }
        });
    }
}