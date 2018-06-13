package cs304_SuperBuy.MainFrame;



import cs304_SuperBuy.GUIframe.overviewAuction;
import cs304_SuperBuy.GUIframe.overviewOrder;
import cs304_SuperBuy.GUIframe.searchmerchant;
import cs304_SuperBuy.backend.returnResultSet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;



/**
 * Created by xingrex on 2017-11-17.
 */
public class managerMainForm {
    public JPanel panelMain;
    private JButton ordersOverviewButton;
    private JButton merchantsOverviewButton;
    private JButton customersOverviewButton;
    private JLabel IDvalue;
    private JButton button2;
    private JButton merchantsStatisticButton;
    private JButton customerStatisticButton;
    private JButton orderStatisticButton;
    private JButton auctionOverviewButton;
    private JButton auctionStatisticButton;

    public managerMainForm(String mid) {


        IDvalue.setText(mid);
        auctionStatisticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jt= new JTable();
                String column[]={"Acution ID","Item Name","Bid Price","Customer","Merchant Name"};
                List<List< Object>> rs = returnResultSet.auctionStats();
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);
                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();

                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);

                }

                JFrame f;
                f=new JFrame("Auction Statistic");
                jt.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);

            }
        });

        merchantsStatisticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable jt= new JTable();
                String column[]={ "merchant type","number of merchant"};
                List<List<Object>> rs = returnResultSet.merchantStats();
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);

                }

                JFrame f;
                f=new JFrame(" Merchant Statistic ");
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);
            }
        });


        orderStatisticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTable jt= new JTable();
                String column[]={"total price","Order ID","Customer Name"};
                List<List<Object>> rs = returnResultSet.orderStats();
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);

                }

                JFrame f;
                f=new JFrame(" Order Statistic");
                jt.setBounds(30,40,200,300);
                JScrollPane sp=new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);



            }
        });

        merchantsOverviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = new JFrame("Browse Merchant");
                frame.setLocation(600,300);
                frame.setContentPane(new searchmerchant().panel1);
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        customersOverviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jt= new JTable();
                String column[]={"Customer ID","NAME","phone number","address"};
                List<List< Object>> rs = returnResultSet.customerOverview();
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);



                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }


                JFrame f;
                f=new JFrame(" Customer Overview");
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);


            }
        });
        ordersOverviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame orderPanel = new JFrame(" Orders Overview ");
                orderPanel.setContentPane(new overviewOrder().ordersPanel);
                orderPanel.pack();
                orderPanel.setVisible(true);
            }
        });
        auctionOverviewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame orderPanel = new JFrame(" Auction Overview ");
                orderPanel.setContentPane(new overviewAuction().panel1);
                orderPanel.pack();
                orderPanel.setVisible(true);
            }
        });
        customerStatisticButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTable jt= new JTable();
                String column[]={"customer ID","NAME","expenditure"};
                List<List<Object>> rs = returnResultSet.customerStats();
                DefaultTableModel table = (DefaultTableModel) jt.getModel();
                table.setColumnIdentifiers(column);

                for (int i = 0; i < rs.size(); i++) {
                    Vector<Object> rowVector = new Vector<>();
                    rowVector.addAll(rs.get(i));
                    table.addRow(rowVector);
                }

                JFrame f;
                f=new JFrame(" Customer Statistic");
                JScrollPane sp = new JScrollPane(jt);
                f.add(sp);
                f.setSize(500,400);
                f.setVisible(true);


            }
        });
    }

//    public static void main(String[] args){
//        JFrame frame = new JFrame("Manager account");
//        frame.setContentPane(new managerMainForm("try").panelMain);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
