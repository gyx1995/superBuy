package cs304_SuperBuy.MainFrame;

import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import cs304_SuperBuy.MainFrame.CustomerUI;
import cs304_SuperBuy.backend.returnBoolean;
import jdk.nashorn.internal.scripts.JO;
import cs304_SuperBuy.MainFrame.MerchantUI;


public class LoginMain extends JFrame {

    private JPanel panel1;
    private JPanel ManagerLogin;
    private JPanel CustomerLogin;
    private JButton loginCustomer;
    private JButton loginMerchant;
    private JPanel MercahntLogin;

    private JTextField textFieldCID;
    private JTextField textFieldCpass;
    private JTextField textFieldMerchantID;
    private JTextField textFieldMerchantPASS;
    private JTextField textFieldManagerID;
    private JTextField textFieldManagerpass;
    private JButton newmanager;
    private JButton newC;
    private JButton newmerchant;
    private JPanel MerchantLogin;
    private JButton loginManager;


    public LoginMain(){


        loginMerchant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //
                returnBoolean rb = new returnBoolean();
                String merchantid = textFieldMerchantID.getText();
                String merchantpass = textFieldMerchantPASS.getText();
                List sd = new ArrayList<String>();
                sd.add("merchantLogInSubmit");
                sd.add(merchantid);
                sd.add(merchantpass);

                    boolean exist = rb.doSomething(sd);

                if (exist) {
                    JFrame frame = new JFrame("Merchant UI");
                    frame.setLocation(600,300);
                    frame.setContentPane(new MerchantUI(merchantid).mmain);
                    frame.setSize(800,600);
                    frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Sorry, wrong password or user id!");
                }

            }
        });
        newmerchant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // register a new manager account
                returnBoolean rb = new returnBoolean();
                String merid = textFieldMerchantID.getText().toString();
                String mpass = textFieldMerchantPASS.getText().toString();
                System.out.println(merid);
                System.out.println(mpass);

                List sd = new ArrayList<String>();
                sd.add("addNewMerchant");
                sd.add(merid);
                sd.add(mpass);

                boolean newMerchantcreated = false;
                newMerchantcreated = rb.doSomething(sd);
                if (newMerchantcreated){
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"You are now in!");
                }
                else {
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"Sorry, we failed to register your account!");
                }
            }
        });
        loginCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBoolean rb = new returnBoolean();
                String cid = textFieldCID.getText();
                String cpass = textFieldCpass.getText();
                List sd = new ArrayList<String>();
                sd.add("customerLogInSubmit");
                sd.add(cid);
                sd.add(cpass);


                boolean exist = false;
                exist = rb.doSomething(sd);

                if (exist) {
                    JFrame frame = new JFrame("Customer UI");
                    frame.setLocation(600,300);
                    frame.setContentPane(new CustomerUI(cid).panel1);
                    frame.setSize(800,600);
                    frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    System.out.print("failed!");
                }
            }
        });
        newC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBoolean rb = new returnBoolean();
                String cid = textFieldCID.getText();
                String cpass = textFieldCpass.getText();
                List sd = new ArrayList<String>();
                sd.add("addNewCustomer");
                sd.add(cid);
                sd.add(cpass);

                boolean newCcreated = false;
                newCcreated = rb.doSomething(sd);
                if (newCcreated){
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"You are now in!");
                }
                else {
                    JFrame f = new JFrame();
                    f.setVisible(true);
//                    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    JOptionPane.showMessageDialog(f,"Sorry, we are failed to register your account!");
                }
            }
        });
        loginManager.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnBoolean rb = new returnBoolean();
                String cid = textFieldManagerID.getText();
                String cpass = textFieldManagerpass.getText();
                List sd = new ArrayList<String>();
                sd.add("managerLogInSubmit");
                sd.add(cid);
                sd.add(cpass);


                boolean exist = false;
                exist = rb.doSomething(sd);

                if (exist) {
                    JFrame frame = new JFrame("Manager UI");
                    frame.setLocation(600,300);
                    frame.setContentPane(new managerMainForm(cid).panelMain);
                    frame.setSize(800,600);
                    frame.setDefaultCloseOperation(HIDE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                } else {
                    System.out.print("failed!");
                }


            }
        });

    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginMain");
        frame.setContentPane(new LoginMain().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(600,300);
        frame.pack();
        frame.setVisible(true);
    }


}
