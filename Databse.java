
package database;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Database extends JFrame implements ActionListener{
    
        JLabel l1 = new JLabel("name:");
        JLabel l2 = new JLabel("city:");
        JLabel l3 = new JLabel("gender:");
        JLabel l4 = new JLabel("interest:");
        JLabel l5 = new JLabel("thank you");
        String c2[]={"surat","vapi","navasari","kim"};
        JComboBox c1=new JComboBox(c2);
        JTextField t1=new JTextField();
        
        JRadioButton ckb1=new JRadioButton("male");
        JRadioButton ckb2=new JRadioButton("female");
       ButtonGroup group = new ButtonGroup();
       
        JCheckBox ck1=new JCheckBox("dancing");
        JCheckBox ck2=new JCheckBox("singing");
        JButton b1=new JButton("Submit");
        
    Database() {
       group.add(ckb1);
        group.add(ckb2);
        add(l1);
        add(t1);
        add(l2);
        add(c1);
        add(l3);
        add(ck1);
        add(ck2);
        add(ckb1);
        add(ckb2);
        add(l4);
        add(b1);
        add(l5);
        l1.setBounds(30, 50, 100, 20);
        t1.setBounds(150, 50, 200, 20);
        l2.setBounds(30, 80, 100, 20);
        c1.setBounds(150, 80, 90, 20);
        l3.setBounds(30, 110, 100, 20);
        l4.setBounds(30, 140, 100, 20);
        l5.setBounds(150, 200, 100, 20);
        b1.setBounds(200, 170, 60, 20);
        b1.addActionListener(this);
        ck1.setBounds(150, 140, 60, 20);
        ck2.setBounds(220, 140, 60, 20);
        ckb1.setBounds(150, 110, 60, 20);
        ckb2.setBounds(210, 110, 60, 20);
    }

    public static void main(String[] args) {
        Database rf = new Database();
        rf.setVisible(true);
        rf.setSize(400, 400);
        rf.setTitle("REGISTRATION FORM");
       
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }return null;
    }
    public String getSelectedCheckBox(){
    String s="";
    if(ck1.isSelected()){
    s+=ck1.getText();}
    if(ck2.isSelected()){s+=ck2.getText();
    }
    return s;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
        String v=t1.getText();
        JFrame f=new JFrame();
        JLabel l=new JLabel("WELCOME"+v);
        l.setBounds(50, 50, 70, 30);      
        f.add(l);
        f.setSize(300,300);
        f.setTitle("welcome");
        f.setVisible(true);
         try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
        Statement st=con.createStatement();
        String query="insert into useri values ('"+t1.getText()+"','"+c1.getSelectedItem()+"','"+getSelectedButtonText(group)+"','"+getSelectedCheckBox()+"');";
        st.execute(query);
         st.close();
        con.close();
        }catch(Exception e1){
            System.out.println(e1);
        }
        
        
        
        }
    }
}

