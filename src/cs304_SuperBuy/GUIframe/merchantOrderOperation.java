package cs304_SuperBuy.GUIframe;

import cs304_SuperBuy.backend.returnBoolean;
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
public class merchantOrderOperation {
    public JTable mainTable;
    public JPanel panel1;
    private JButton updateTheStatusToButton;
    private JComboBox comboBox1;
    private JScrollPane JSP;

    public merchantOrderOperation(String mid,String oid,Integer st){
        String column[]={"Order ID","Order Status", "Item ID"};
        Integer mmid = Integer.valueOf((String) mid);
        List<List<Object>> rs = returnResultSet.checkOrderforM(0,mmid,oid,st);
        DefaultTableModel table = (DefaultTableModel) mainTable.getModel();
        table.setColumnIdentifiers(column);
        for (int i = 0; i < rs.size(); i++) {
            Vector<Object> rowVector = new Vector<>();
            rowVector.addAll(rs.get(i));
            table.addRow(rowVector);
        }


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
    }


}