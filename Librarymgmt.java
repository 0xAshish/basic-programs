
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author global
 */


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LibraryManagement extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t4;
    JComboBox c1;
    JRadioButton r1, r2;
    ButtonGroup grp;

    public LibraryManagement() {
        l1 = new JLabel("catagory:");
        l2 = new JLabel("ISBN no:");
        l3 = new JLabel("Book Title:");
        l4 = new JLabel("Author:");
        l5 = new JLabel("");
        l6 = new JLabel("serch by:");
        l7 = new JLabel("you can serch the book:");
        String c2[] = {"story", "novel", "history", "science", "G.K"};
        c1 = new JComboBox(c2);
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        b1 = new JButton("submit");
        b2 = new JButton("reset");
        b3 = new JButton("search");
        r1 = new JRadioButton("title", true);
        add(r1);
        r2 = new JRadioButton("author");
        add(r2);
        grp = new ButtonGroup();
        grp.add(r1);
        grp.add(r2);
        add(l1);
        add(t1);
        add(l2);
        add(c1);
        add(l3);
        add(t2);
        add(t3);
        add(t4);
        add(l4);
        add(b1);
        add(b2);
        add(b3);
        add(l6);
        add(l7);
        b1.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        add(l5);
     
        l1.setBounds(30, 50, 100, 20);
        c1.setBounds(150, 50, 200, 20);
        l2.setBounds(30, 80, 100, 20);
        t1.setBounds(150, 80, 90, 20);
        l3.setBounds(30, 110, 100, 20);
        l4.setBounds(30, 140, 100, 20);
        l5.setBounds(150, 200, 100, 20);
        b1.setBounds(150, 170, 100, 20);
        b2.setBounds(250, 170, 100, 20);
        b3.setBounds(200, 290, 100, 20);
        l7.setBounds(30, 210, 200, 20);
        l6.setBounds(30, 250, 100, 20);
        t2.setBounds(150, 140, 60, 20);
        r1.setBounds(150, 250, 80, 20);
        t3.setBounds(150, 110, 60, 20);
        t4.setBounds(30, 290, 150, 20);
        r2.setBounds(250, 250, 80, 20);
    }


   
    //@Override
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
             if (e.getSource() == b2) {
             t1.setText("");
             t2.setText("");
             t3.setText("");
             }
            if (e.getSource() == b1) {
                String s1, s2, s3, s4 ,s5,sql="";
                s1 = (String) c1.getSelectedItem();
                s2 = t1.getText();
               s3 = t2.getText();
                s4 = t3.getText();
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libman", "root", "root");
                Statement st=con.createStatement();
             String query="insert into book values ('"+s1+"','"+s2+"','"+s3+"','"+s4+"');";
            st.execute(query);
            
            }
            
            if (e.getSource() == b3) {
                String s1, s2, s3, s4 ,s5,sql="";
               s5 = t4.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libman", "root", "root");
               // String res;
                ResultSet res;
                Statement st=con.createStatement();
              
                
                if(r1.isSelected())
                {
                    sql= "select * from book where booktitle='"+s5+"'";
                }
                else if(r2.isSelected())
                {
                    sql= "select * from book where bookauthor='"+s5+"'";
                }
                res=st.executeQuery(sql);System.out.println(res+"hhhh");
               res.last();
               int n=res.getRow();
               res.beforeFirst();
               int i=1;
                
               JFrame f = new JFrame();
               JTable t1;
               f.setLayout(new FlowLayout());
             
              String ar[][]=new String[n+1][4];
              
               while(res.next()){
               // String ds=res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4);
             ar[i][0]=res.getString(1);
           ar[i][1]=res.getString(2);
           ar[i][2]=res.getString(3);
           ar[i][3]=res.getString(4);i++;
             
               }
               
           
              String ss[]={"name","Isbn","author","title"};
              ar[0][0]="Name";
              ar[0][1]="Isbn";ar[0][2]="Author";ar[0][3]="Title";
              t1=new JTable(ar,ss);
               f.add(t1);
              
              
               
                f.setSize(200, 200);
                f.setVisible(true);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        LibraryManagement rf = new LibraryManagement();
        rf.setVisible(true);
        rf.setSize(500, 500);
        rf.setTitle("LIBRARY MANAGEMENT SYSTEM");
    }

}
