package cs304_SuperBuy.GUIframe;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import cs304_SuperBuy.backend.returnResultSet;
import javax.swing.table.DefaultTableModel;
import cs304_SuperBuy.backend.returnBoolean;
import java.sql.*;


public class Merchant_checkstock {
    public JPanel panel1;
    private JLabel itemid;
    private JTextField textfieldItemid;
    private JComboBox comboBoxSign;
    private JTextField textFieldqty;
    private JButton searchItems;
    private JTable table1;
    private JButton holdAnAuctionButton;
    private JButton stockMyItemButton;
    private JTextField textField1;
    private JButton stockmyitem;
    private JTextField newqty;

    public Merchant_checkstock(String mid) {


        searchItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                String iid = textfieldItemid.getText();
                Integer sign = comboBoxSign.getSelectedIndex();

                System.out.println(sign);

                String qty = textFieldqty.getText();

                returnResultSet rss = new returnResultSet();
                List<List<Object>> rs = rss.viewItem(mid,iid,sign,qty);

                System.out.println(rs);




                String cols[] = {"Item ID","Price", "number in stock","item name"};



                DefaultTableModel tt = (DefaultTableModel) table1.getModel();
                tt.setRowCount(0);
                tt.setColumnIdentifiers(cols);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    tt.addRow(rowVector);

                }



            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                List<String> pars = new ArrayList<String>();
                super.mouseClicked(e);
                int selectedindexrow = table1.getSelectedRow();
                String updatedItemid = table1.getValueAt(selectedindexrow,0).toString();

                String newqtyvalue = "";
                newqtyvalue = newqty.getText().toString();


                pars.add("stockmyitem");
                pars.add(updatedItemid); //string
                pars.add(newqtyvalue); // new qty value //Integer


                returnBoolean rss =  new returnBoolean();
                boolean result = rss.doSomething(pars);


            }
        });
//        stockmyitem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                String newqtyvalue = "";
//                newqtyvalue = newqty.getText().toString();
//                Integer qtyvalue = Integer.valueOf(newqtyvalue);
//
//                String iid = textfieldItemid.getText();
//                Integer sign = comboBoxSign.getSelectedIndex();
//                String qty = textFieldqty.getText();
//
//
//                System.out.println(qty);
//                returnResultSet rss = new returnResultSet();
//                List<List<Object>> rs = rss.viewItem(mid, iid, sign, qty);
//
//
//                int columnCount = 4;
//
//                String cols[] = {"Item id", "price", "number in stock", "Item name"};
//
//                DefaultTableModel defaultTableModel = (DefaultTableModel) table1.getModel();
//
//                defaultTableModel.setColumnIdentifiers(cols);
//                defaultTableModel.setColumnIdentifiers(cols);
//                // Data of the table.
//
//
//                for (int i = 0; i<rs.size();i++) {
//                    Vector<Object> rowVector = new Vector<>();
//                    rowVector.addAll(rs.get(i));
//                    defaultTableModel.addRow(rowVector);
//                }
//
//
//                JFrame f = new JFrame("View my order");
//                JPanel storebuttons = new JPanel();
//                JButton stockmyintem = new JButton("Stock my item");
//                storebuttons.add(stockmyintem);
//                f.add(storebuttons);
//
//
//                JScrollPane jspane = new JScrollPane(table1);
//                f.add(jspane);
//                f.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//                f.setVisible(true);
//
//
//            }
//        });
        holdAnAuctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String iid = textfieldItemid.getText().toString();

            //Integer addNewAuction(String mid,String iid, String askprice)
                int index = table1.getSelectedRow();
                System.out.println("......");
                System.out.println(index);

                String value = table1.getModel().getValueAt(index, 0).toString();

                System.out.println("164");
                System.out.println(value);
                String askp = table1.getModel().getValueAt(index, 1).toString();



                returnResultSet rb = new returnResultSet();


                Integer aid = rb.addNewAuction(mid,value,askp);
                JOptionPane.showMessageDialog(null, "New auction id is " + aid);

            }
        });
//        stockMyItemButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String newqty = textField1.getText().toString();
//                int index = table1.getSelectedRow();
//
//                String value = table1.getModel().getValueAt(index, 0).toString();
//
//
//
//                returnBoolean rb = new returnBoolean();
//                List pars = new ArrayList();
//                pars.add("stockmyitem");
//                pars.add(value);
//                pars.add(newqty);
//                rb.doSomething(pars);
//
//                boolean result = rb.doSomething(pars);
//
//                JOptionPane.showMessageDialog(null, "Successfully stocked!");
//
//            }
//        });
        stockMyItemButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                String newqty = textField1.getText().toString();
                System.out.println(newqty);

                int index = table1.getSelectedRow();

                String value = table1.getModel().getValueAt(index, 0).toString();



                returnBoolean rb = new returnBoolean();
                List pars = new ArrayList();
                pars.add("stockmyitem");
                pars.add(value);
                pars.add(newqty);

                boolean result = rb.doSomething(pars);

                JOptionPane.showMessageDialog(null, "Successfully stocked!");

            }
        });
    }

    public static void main(String[] args) {
        JFrame framemain = new JFrame("Merchant ID: 3");
        framemain.setLocation(600,300);
        framemain.setSize(800,600);
        int i = 3;
        String mid = ""+ i;
        framemain.setContentPane(new Merchant_checkstock(mid).panel1);
        framemain.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        framemain.pack();
        framemain.setVisible(true);
    }
}
