package cs304_SuperBuy.GUIframe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.ArrayList;
import cs304_SuperBuy.backend.returnBoolean;
import cs304_SuperBuy.backend.returnResultSet;
import java.sql.*;


public class editprofileM {
    public JPanel mprofile_panel;
    private JLabel newname;
    private JTextField nametf;
    private JLabel address;
    private JTextField addresstf;
    private JButton editprofileM;
    private JLabel showaddr;
    private JLabel showname;
    private JButton showButton;

    public editprofileM(String id) {
        editprofileM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                returnResultSet r = new returnResultSet();


                // update my profile (for Customer)
                List updateCinfo = new ArrayList<String>();
                updateCinfo.add("updateMyAccountforM");
                updateCinfo.add(id);
                String newCname = nametf.getText();

                updateCinfo.add(newCname);
                String newCphone = addresstf.getText();

                updateCinfo.add(newCphone);


                ResultSet updated = r.doSomething(updateCinfo);

                try {
                    boolean temp = updated.next();
                    showname.setText(updated.getString(1));
                    showaddr.setText(updated.getString(2));

//                    JOptionPane.showMessageDialog(null, updated.getObject(1));
                } catch(Exception ex) {
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"failed");
                }




            }





        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnResultSet r = new returnResultSet();
                List showmyprofile = new ArrayList<String>();
                showmyprofile.add("viewMyAccountforM");
                showmyprofile.add(id);
                ResultSet rs = r.doSomething(showmyprofile);
                //
//                JTable table = new JTable(buildTableModel(rs));
                try {
                    boolean temp = rs.next();
                    showname.setText(rs.getString(1));
                    showaddr.setText(rs.getString(2));

//                    JOptionPane.showMessageDialog(null, rs.getObject(1));
                } catch(Exception ex) {
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"failed");
                }

            }

        });

    }
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

// names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

// data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }


}


