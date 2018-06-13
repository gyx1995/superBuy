package cs304_SuperBuy.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cs304_SuperBuy.GUIframe.Merchant_checkstock;
import cs304_SuperBuy.GUIframe.editprofileM;
import cs304_SuperBuy.GUIframe.merchantCheckOrder;

import cs304_SuperBuy.GUIframe.checkAuctionsM;

/**
 * Created by ouyangma on 2017-11-18.
 */
public class MerchantUI extends JFrame {
    private JButton m_viewAccount;
    private JButton m_checkItems;
    public JPanel mmain;
    private JButton m_checkAuctions;
    private JButton viewOrdersButton;
    private JButton editMyAccountButton;

    public MerchantUI(String id) {

        m_viewAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame view_account = new JFrame("View My Account");
                view_account.setLocation(600, 300);
                view_account.setContentPane(new editprofileM(id).mprofile_panel);
                view_account.setSize(800, 600);
                view_account.setDefaultCloseOperation(HIDE_ON_CLOSE);
                view_account.pack();
                view_account.setVisible(true);

            }
        });

        m_checkItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame check_items = new JFrame("Check my Stocks");
                check_items.setLocation(600, 300);
                check_items.setContentPane(new Merchant_checkstock(id).panel1);
                check_items.setSize(800, 600);
                check_items.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                check_items.pack();
                check_items.setVisible(true);
            }
        });
//
//
        m_checkAuctions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame check_auctions = new JFrame("Check My Auctions");
                check_auctions.setLocation(600, 300);
                check_auctions.setContentPane(new checkAuctionsM(id).checkauctions);
                check_auctions.setSize(800, 600);
                check_auctions.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                check_auctions.pack();
                check_auctions.setVisible(true);

            }
        });
//
//
        viewOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame view_orders = new JFrame("View My Orders");
                view_orders.setLocation(600, 300);
                view_orders.setContentPane(new merchantCheckOrder(id).mainPanel);
                view_orders.setSize(800, 600);
                view_orders.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                view_orders.pack();
                view_orders.setVisible(true);
            }
        });
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Merchant");
//        frame.setContentPane(new MerchantUI().mmain);               //***************
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }

}
