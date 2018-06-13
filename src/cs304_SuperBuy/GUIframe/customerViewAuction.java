package cs304_SuperBuy.GUIframe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import java.util.List;

import com.sun.codemodel.internal.JOp;
import cs304_SuperBuy.backend.returnResultSet;
import javax.swing.table.DefaultTableModel;
import cs304_SuperBuy.backend.returnBoolean;
import jdk.nashorn.internal.scripts.JO;


public class customerViewAuction {

    public JPanel panel1;
    private JTextField auctionIdValue;
    private JButton viewAuctionButton;
    private JTextField eqgrbidprice;

    private JTable table1;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton bidButton;
    //    public JPanel panel1;
//    private JTextField textFieldAuctionIDbyC;
//    private JButton viewAuctionButton;
//    private JTextField eqgrbidprice;
//
//    private JTable table1;
//    private JComboBox comboBox1;
//    private JButton bidButton;
//    private JTextField textField1;
//    private JTextArea auctionIDTextArea;


    public customerViewAuction(String id) {
        viewAuctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                List pars = new ArrayList<String>();

                pars.add("vewAuctionsForC");
                String aid = auctionIdValue.getText();
                String bidp = eqgrbidprice.getText();
                String selecteditem = comboBox1.getSelectedItem().toString();


                pars.add(aid);
                pars.add(bidp);
                pars.add(selecteditem);

                returnResultSet rss = new returnResultSet();
                System.out.println(pars);
                ResultSet output = rss.doSomething(pars);

                int columnCount = 7;

                String cols[] = {"aid", "mid", "iid", "start date", "askprice", "bidprice", "status"};

                DefaultTableModel defaultTableModel = (DefaultTableModel) table1.getModel();
                defaultTableModel.setRowCount(0);


                defaultTableModel.setColumnIdentifiers(cols);
                Vector<Vector<Object>> dataVector = new Vector<>();
                try {
                    while (output.next()) {
                        Vector<Object> rowVector = new Vector<>();
                        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                            rowVector.add(output.getObject(columnIndex));
                        }
                        defaultTableModel.addRow(rowVector);
                    }
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"failed! 121");
                }



            }
        });
        bidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // bid(String cid, String aid, String bidprice)
                String bidp = textField1.getText().toString();
                int index = table1.getSelectedRow();

                String value = table1.getModel().getValueAt(index, 0).toString();

                returnBoolean rb = new returnBoolean();

                boolean rs = rb.bid(id,value,bidp);
                if (rs) {
                    JOptionPane.showMessageDialog(null,"You gave the highest bidprice till now!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"You should bid higher!");
                }

//                if (rs) {
//                    JOptionPane.showMessageDialog(null,"Successfully Deleted!");
//                }
//                else {sue0320BB

//                    JOptionPane.showMessageDialog(null,"Fail to delete it!");
//                }
            }
        });

    }
}
