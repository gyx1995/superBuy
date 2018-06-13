package cs304_SuperBuy.GUIframe;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xingrex on 2017-11-18.
 */
public class overviewMerchants {
    public JPanel panel1;
    private JTextField textFieldSearchbyMname;
    private JList sortbyRatingmultiple;
    private JComboBox comboBoxSortby;
    private JList merchanttypemultiple;
    private JButton searchMerchant;
    private JTextField textFieldmid;
    private JTable returnmerchantstable;


    public overviewMerchants() {

        searchMerchant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame f;
                f=new JFrame("Auction Statistic");
                String data[][]={ {"101","Amit","670000"},
                        {"102","Jai","780000"},
                        {"101","Sachin","700000"}};
                System.out.print(data);
                String column[]={"Auction ID","winner","bid price"};
                JTable jt=new JTable(data,column);
                jt.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);
            }
        });
    }
}
