package cs304_SuperBuy.GUIframe;

import com.sun.codemodel.internal.JOp;
import cs304_SuperBuy.backend.returnResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import cs304_SuperBuy.backend.returnBoolean;
import jdk.nashorn.internal.scripts.JO;

public class auctionoperationforM {


    private JScrollPane JSP;
    private JTable mainTable;
    private JButton updateTheStatusToButton;
    private JPanel panel1;
    private JButton ENDAnAuctionButton;


    public auctionoperationforM(String mid,String aid){
        String column[]={"Auction ID","Merchant id", "Item ID", "Start date", "askprice", "bidprice", "status"};
        Integer mmid = Integer.valueOf((String) mid);
        returnBoolean rb = new returnBoolean();
        List<String> pars = new ArrayList<>();
        pars.add("deleteAuction");
        pars.add(aid);
        boolean rs =rb.doSomething(pars);

        DefaultTableModel table = (DefaultTableModel) mainTable.getModel();

        if (rs) {
            JOptionPane.showMessageDialog(null,"Delected successfully!");
        }else {
            JOptionPane.showMessageDialog(null,"fail to delete it!");
        }
//
//        updateTheStatusToButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int sel = mainTable.getSelectedRow();
//                String oid = mainTable.getValueAt(sel,0).toString();
//                String newSta = comboBox1.getSelectedItem().toString();
//
//                ArrayList input = new ArrayList();
//                input.add("updateOrderStatus");
//                input.add(oid);
//                input.add(newSta);
//                System.out.print(input);
//                System.out.print(returnBoolean.doSomething(input));
//
//            }
//        });
        ENDAnAuctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sel = mainTable.getSelectedRow();
                String aid = mainTable.getValueAt(sel,0).toString();

                List input = new ArrayList();
                input.add("updateOrderStatus");
                input.add(aid);
          //      input.add(new);
                System.out.print(input);
                System.out.print(returnBoolean.doSomething(input));

            }
        });
    }


}
