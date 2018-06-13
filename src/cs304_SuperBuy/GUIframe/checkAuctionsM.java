package cs304_SuperBuy.GUIframe;

import javax.swing.*;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import cs304_SuperBuy.ResultSetToTable;
import cs304_SuperBuy.backend.returnResultSet;
import cs304_SuperBuy.backend.returnBoolean;
import jdk.nashorn.internal.scripts.JO;

/**
 * Created by ouyangma on 2017-11-18.
 */
public class checkAuctionsM {
    public JPanel checkauctions;
    private JLabel label2;
    private JComboBox status;
    private JButton viewAuctionButton;
    private JTextField textField1AucitnID;
    private JTable table1;
    private JScrollPane scrollpane;
    private JButton deleteAnAuctionButton;
    private JButton endAnAuctionButton;

    public checkAuctionsM(String mid){

        viewAuctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                returnResultSet rss = new returnResultSet();
////                String a = aid.getText().toString();
//                //
//                JFrame orderPanel = new JFrame(" Auction Operation ");
//                orderPanel.setContentPane(new auctionoperationforM().panel1);
//                orderPanel.pack();
//                orderPanel.setVisible(true);
//

                String s = status.getSelectedItem().toString();
                String aidinput = textField1AucitnID.getText().toString();

                if(s == "Null")
                    s = "";


                if (s == "In Process")
                    s = "Inprocess";


                String column[]={ "Auction ID","Merchant ID","Item ID","Start Date","Ask Price","Bid Price","Status"};
                List<List<Object>> rs = returnResultSet.viewAllAuction(mid,aidinput,s);
                DefaultTableModel tt = (DefaultTableModel) table1.getModel();
                tt.setRowCount(0);
                tt.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    tt.addRow(rowVector);

                }

//                scrollpane = new JScrollPane(tt);


            }
        });
        deleteAnAuctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = table1.getSelectedRow();
                System.out.println("......");
                System.out.println(index);

                String value = table1.getModel().getValueAt(index, 0).toString();

                System.out.println(value);

                returnBoolean rb = new returnBoolean();
                List pars = new ArrayList();
                pars.add("deleteAuction");
                pars.add(value);
                boolean rs = rb.doSomething(pars);
                if (rs) {
                    JOptionPane.showMessageDialog(null,"Successfully Deleted!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Fail to delete it!");
                }
            }
        });
        endAnAuctionButton.addActionListener(new ActionListener() {
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
}
