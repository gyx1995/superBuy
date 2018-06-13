package cs304_SuperBuy.MainFrame;

import cs304_SuperBuy.GUIframe.editprofileC;
import cs304_SuperBuy.GUIframe.searchmerchant;
import cs304_SuperBuy.GUIframe.checkorderbyc;
import cs304_SuperBuy.GUIframe.customerViewAuction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import cs304_SuperBuy.GUIframe.customerCheckOrder;

public class CustomerUI extends JFrame{
    private JButton viewMyAccountButton;
    public JPanel panel1;
    private JButton searchMerchantButton;
    private JButton viewAuctionButton;
    private JButton checkOrderButton;

    public CustomerUI(String cid){
        viewMyAccountButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {


               setVisible(false);
               JFrame frame = new JFrame("editprofileC");
               frame.setLocation(600,300);

               frame.setContentPane(new editprofileC(cid).panel1);
               frame.setSize(800,600);
               frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
               frame.pack();
               frame.setVisible(true);


            }
        });
        searchMerchantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame = new JFrame("Browse Merchant");
                frame.setLocation(600,300);
                frame.setContentPane(new customerCheckOrder(cid).panel1);
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        viewAuctionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame = new JFrame("View Current Auctions");
                frame.setLocation(600,300);
                frame.setContentPane(new customerViewAuction(cid).panel1);
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });
        checkOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JFrame frame = new JFrame("Check my Orders");
                frame.setLocation(600,300);
                frame.setContentPane(new checkorderbyc(cid).panel1);
                frame.setSize(800,600);
                frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);

            }
        });

    }

//
//    public static void main(String[] args) {
//        JFrame framemain = new JFrame("CustomerUI");
//        framemain.setLocation(600,300);
//        framemain.setSize(800,600);
//        int i = 5;
//        String cid = ""+ i;
//        framemain.setContentPane(new CustomerUI(cid).panel1);
//        framemain.setDefaultCloseOperation(HIDE_ON_CLOSE);
//        framemain.pack();
//        framemain.setVisible(true);
//    }
}
