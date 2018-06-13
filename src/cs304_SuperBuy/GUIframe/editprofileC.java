package cs304_SuperBuy.GUIframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import cs304_SuperBuy.backend.returnResultSet;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class editprofileC extends JFrame{


    public JPanel panel1;
    private JLabel label1;
    private JTextField textFieldnewCname;
    private JLabel label2;
    private JTextField textFieldnewphoneC;
    private JLabel label3;
    private JTextField textFieldnewCaddr;
    private JButton submitCprofileButton;
    private JButton showCinfo;
    private JLabel cname;
    private JLabel Cphone;
    private JLabel Caddr;

    public editprofileC(String cid) throws HeadlessException {


        submitCprofileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                returnResultSet r = new returnResultSet();


                // update my profile (for Customer)
                List updateCinfo = new ArrayList<String>();
                updateCinfo.add("updateMyAccountforC");
                updateCinfo.add(cid);
                String newCname = textFieldnewCname.getText();
                System.out.println(newCname);
                updateCinfo.add(newCname);
                String newCphone = textFieldnewphoneC.getText();
                System.out.println(newCphone);
                updateCinfo.add(newCphone);
                String newaddr = textFieldnewCaddr.getText();
                System.out.println(newaddr);
                updateCinfo.add(newaddr);


                ResultSet updated = r.doSomething(updateCinfo);

                try {
                    boolean temp = updated.next();
                    cname.setText(updated.getString(1));
                    Cphone.setText(updated.getString(2));
                    Caddr.setText(updated.getString(3));
//                    JOptionPane.showMessageDialog(null, updated.getObject(1));
                } catch(Exception ex) {
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"failed");
                }




            }
        });
        showCinfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                returnResultSet r = new returnResultSet();
                List showmyprofile = new ArrayList<String>();
                showmyprofile.add("viewMyAccountforC");
                showmyprofile.add(cid);
                ResultSet rs = r.doSomething(showmyprofile);
                //
//                JTable table = new JTable(buildTableModel(rs));
                try {
                    boolean temp = rs.next();
                    cname.setText(rs.getString(1));
                    Cphone.setText(rs.getString(2));
                    Caddr.setText(rs.getString(3));
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
