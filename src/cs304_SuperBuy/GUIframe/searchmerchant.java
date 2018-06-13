package cs304_SuperBuy.GUIframe;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Vector;


import cs304_SuperBuy.Model.Merchant;
import cs304_SuperBuy.backend.returnResultSet;
import cs304_SuperBuy.Model.MerchantType;
import jdk.nashorn.internal.scripts.JO;


public class searchmerchant {
    public JPanel panel1;
    private JTextField textFieldSearchbyMname;
    private JList sortbyRatingmultiple;
    private JComboBox comboBoxSortby;
    private JList merchanttypemultiple;
    private JButton searchMerchant;
    private JTextField textFieldmid;
    private JTable table1;
    private JButton purchaseButton;
//    private JTable returnmerchantstable;

    public searchmerchant() {

//         List types = new ArrayList();
//        merchanttypemultiple.addListSelectionListener(new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent e) {
//
//                 types = merchanttypemultiple.getSelectedValuesList();
//
//            }
//        });

        searchMerchant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                List<Object> pars = new ArrayList<Object>();
                //mid string
                String mid = textFieldmid.getText();


//                int len = merchanttypemultiple.getSelectedIndices().length;
//                int[] indices = merchanttypemultiple.getSelectedIndices();
//                // merchantTypes List<String>
                List selectedmerTypes = merchanttypemultiple.getSelectedValuesList();

//                String[] myArray = new String[50];
//                for (int i = 0; i < selectedmerTypes.size(); i++) {
//                    MerchantType mt = null;
////                    String setvalue = String.valueOf(merchanttypemultiple.getModel().getElementAt(selectedIndices[i]));
//                    switch (selectedmerTypes.get(i).toString()) {
//
//                        case "FOOD":
//                            mt = MerchantType.FOOD;
//                            break;
//                        case "ELECTRONICS":
//                            mt = MerchantType.ELECTRONICS;
//                            break;
//                        case "CLOTHING":
//                            mt = MerchantType.CLOTHING;
//                            break;
//                        case "BOOKS":
//                            mt = MerchantType.BOOKS;
//                            break;
//                        case "MUSIC":
//                            mt = MerchantType.MUSIC;
//                            break;
//                    }
//                    selectedmerTypes.add(mt);
//                }
                //mername String
                String mername = textFieldSearchbyMname.getText();
                //List<String> ratings
                List selectedIndicesforRating = sortbyRatingmultiple.getSelectedValuesList();
//                List<Integer> intlist = new ArrayList<Integer>();
//                for (int index = 0; index < selectedIndicesforRating.length; index++) {
//                    intlist.add(selectedIndicesforRating[index]);
//                }
//                List selectedmerRs = new ArrayList<String>();
//                for (int i = 0; i < selectedIndicesforRating.length; i++) {
//                    String setvalueforR = String.valueOf(sortbyRatingmultiple.getModel().getElementAt(selectedIndicesforRating[i]));
//                    selectedmerRs.set(i,setvalueforR);
//                }

                //sort by String
                int sortby = comboBoxSortby.getSelectedIndex();

//                pars.add("");
//                pars.add(mid);
//                pars.add(indices);
//                pars.add(mername);
//                pars.add(selectedIndicesforRating);
//                pars.add(sortmerchant);

                returnResultSet rs = new returnResultSet();
                ResultSet rss = rs.searchMerchant(mid, selectedmerTypes,
                        mername, selectedIndicesforRating, sortby);



                //result table
                int columnCount = 7;

                String cols[] = {"mid", "mname", "rating", "type", "address", "password", "sales"};

                DefaultTableModel defaultTableModel = (DefaultTableModel) table1.getModel();
                defaultTableModel.setRowCount(0);

                defaultTableModel.setColumnIdentifiers(cols);
                // Data of the table.
//                Vector<Vector<Object>> dataVector = new Vector<>();
                try {
                    while (rss.next()) {
                        Vector<Object> rowVector = new Vector<>();
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            rowVector.add(rss.getObject(columnIndex));
                        }
                        defaultTableModel.addRow(rowVector);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"failed! 121");
                }


//
//                JFrame f = new JFrame("pop-up window");
//                f.setLocation(600,300);
//                f.setSize(800,600);
//                JScrollPane jspane = new JScrollPane(returnmerchantstable);
//                f.add(jspane);
//                f.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//                f.setVisible(true);


            }
        });

        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int rowind= table1.getSelectedRow();

                String value = table1.getModel().getValueAt(rowind, 0).toString();


                returnResultSet rb = new returnResultSet();


                returnResultSet rss = new returnResultSet();
                String val = rss.EndAnAuction(value);
                JOptionPane.showMessageDialog(null,"Auction " + value + "is ended, the final winner is " + val);


            }
        });
    }

    public static void main(String[] args) {
        JFrame framemain = new JFrame("dsUI");
        framemain.setLocation(600,300);
        framemain.setSize(800,600);
        framemain.setContentPane(new searchmerchant().panel1);
        framemain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framemain.pack();
        framemain.setVisible(true);
    }


}
