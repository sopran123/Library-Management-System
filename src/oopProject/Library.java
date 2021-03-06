/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oopProject;


import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Seth
 */
public class Library extends javax.swing.JFrame {

    /**
     * Creates new form Library
     */
    public Library() { //mga design lang toh hahaha
        initComponents();
        JFrame aFrame = new JFrame("Library Management System");
        aFrame.setSize(961,553);
        aFrame.setResizable(false);
        setLocation(230,100);
        display();
        sionoBorrow.setEnabled(false);
        sionoReturn.setEnabled(false);
    }
    public void empty(){ // nag eempty ng mga textfields ata toh...
        Siono1.setText("");
        Siono2.setText("");
        Siono3.setText("");
        Siono5.setText("");
        Siono7.setText("");
    }
    public Connection sionoConnect(){ //syntax para mag connect sa wamp.
        Connection con;
        try{    
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please open your Wamp Server...", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public ArrayList<Siono> sionoList(){ //pang execute ng Siono.java
        ArrayList<Siono> ulist = new ArrayList<Siono>();
        Connection con = sionoConnect();
        
        String query = "SELECT * FROM `library` ";
        Statement st;
        ResultSet rs;
        try{
            st = con.createStatement();
            rs = st.executeQuery(query);
            Siono user;
            while(rs.next()){
                user = new Siono(rs.getString("ISBN"), rs.getString("Title"), rs.getString("Author"), rs.getString("Status"), rs.getInt("Quantity"));
                ulist.add(user);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Please open your Wamp Server...", "Error Message",JOptionPane.ERROR_MESSAGE);
        }
        return ulist;
    }
    
    public void display(){ //pang display ng table ng mga list
        ArrayList<Siono> ulist = sionoList();
        DefaultTableModel table = (DefaultTableModel)SionoTable.getModel();
        Object[] row = new Object[5];
        for(int i=0; i<ulist.size(); i++){
            row[0] = ulist.get(i).getISBN();
            row[1] = ulist.get(i).getTITLE();
            row[2] = ulist.get(i).getAUTHOR();
            row[3] = ulist.get(i).getSTATUS();
            row[4] = ulist.get(i).getQUANTITY();
            table.addRow(row);
        }
    }
    
    public void sionoExecute(String query, String message){ //execute ng bawat buttons
        Connection con = sionoConnect();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query) == 1){
                DefaultTableModel mod = (DefaultTableModel)SionoTable.getModel();
                mod.setRowCount(0);
                display();
                JOptionPane.showMessageDialog(null, "Successfully "+message+"" );
                empty();
            }
            else{
                JOptionPane.showMessageDialog(null, "Failed. None "+message, "ERROR",JOptionPane.ERROR_MESSAGE);
                empty();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "             ~ERROR~"+"\n"+"*Please fill in all the necessary informations!\n*ISBN should be unique!\n*ISBN should be an integer!\n*Quantity should be an integer!", "ERRORe",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void sionoExecute(String query, String message, String mess){
        Connection con = sionoConnect();
        Statement st;
        try{
            st = con.createStatement();
            if(st.executeUpdate(query) == 1){
                DefaultTableModel mod = (DefaultTableModel)SionoTable.getModel();
                mod.setRowCount(0);
                display();
                JOptionPane.showMessageDialog(null,message,mess,JOptionPane.ERROR_MESSAGE );
                empty();
            }
            else{
                JOptionPane.showMessageDialog(null, "Failed to "+message, "ERROR",JOptionPane.ERROR_MESSAGE);
                empty();
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "                                      ~ERROR~"+"\n"+"*Please make sure to fill in all the necessary informations!"+"\n"+"*Please make sure that the ISBN input is unique!", "ERRORe",JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Siono1 = new javax.swing.JTextField();
        Siono2 = new javax.swing.JTextField();
        Siono3 = new javax.swing.JTextField();
        Siono5 = new javax.swing.JTextField();
        SionoADD = new javax.swing.JButton();
        SionoUPDATE = new javax.swing.JButton();
        SionoDELETE = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SionoTable = new javax.swing.JTable();
        Siono4 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        Siono6 = new javax.swing.JComboBox<>();
        Siono7 = new javax.swing.JTextField();
        SionoSEARCH = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        sionoClear = new javax.swing.JButton();
        sionoBorrow = new javax.swing.JButton();
        sionoReturn = new javax.swing.JButton();
        sionoX = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(244, 244, 220));
        setMinimumSize(new java.awt.Dimension(957, 593));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setText("*ISBN:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 190, 60, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("*Title:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 240, 37, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 51));
        jLabel3.setText("*Author:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 290, 55, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("*Status:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 330, 60, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 51));
        jLabel5.setText("*Quantity:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 367, 70, 30);

        Siono1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Siono1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        Siono1.setFocusCycleRoot(true);
        Siono1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Siono1MouseClicked(evt);
            }
        });
        Siono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siono1ActionPerformed(evt);
            }
        });
        getContentPane().add(Siono1);
        Siono1.setBounds(130, 190, 220, 30);
        getContentPane().add(Siono2);
        Siono2.setBounds(130, 240, 220, 30);

        Siono3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siono3ActionPerformed(evt);
            }
        });
        getContentPane().add(Siono3);
        Siono3.setBounds(130, 290, 220, 30);

        Siono5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siono5ActionPerformed(evt);
            }
        });
        getContentPane().add(Siono5);
        Siono5.setBounds(130, 370, 55, 30);

        SionoADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/add.jpg"))); // NOI18N
        SionoADD.setText("ADD");
        SionoADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SionoADDActionPerformed(evt);
            }
        });
        getContentPane().add(SionoADD);
        SionoADD.setBounds(30, 420, 83, 35);

        SionoUPDATE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/edit.jpg"))); // NOI18N
        SionoUPDATE.setText("EDIT");
        SionoUPDATE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SionoUPDATEActionPerformed(evt);
            }
        });
        getContentPane().add(SionoUPDATE);
        SionoUPDATE.setBounds(130, 420, 85, 33);

        SionoDELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/delete.jpg"))); // NOI18N
        SionoDELETE.setText("DELETE");
        SionoDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SionoDELETEActionPerformed(evt);
            }
        });
        getContentPane().add(SionoDELETE);
        SionoDELETE.setBounds(230, 420, 120, 33);

        jLabel6.setFont(new java.awt.Font("Garamond", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 51));
        jLabel6.setText("      LIBRARY MANAGEMENT SYSTEM");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 20, 952, 57);

        SionoTable.setBackground(new java.awt.Color(244, 244, 220));
        SionoTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        SionoTable.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        SionoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Title", "Author", "Status", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SionoTable.setSelectionBackground(new java.awt.Color(102, 153, 255));
        SionoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SionoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SionoTable);
        if (SionoTable.getColumnModel().getColumnCount() > 0) {
            SionoTable.getColumnModel().getColumn(0).setResizable(false);
            SionoTable.getColumnModel().getColumn(1).setResizable(false);
            SionoTable.getColumnModel().getColumn(2).setResizable(false);
            SionoTable.getColumnModel().getColumn(3).setResizable(false);
            SionoTable.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(360, 130, 590, 420);

        Siono4.setBackground(new java.awt.Color(244, 164, 96));
        Siono4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Unavailable" }));
        Siono4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siono4ActionPerformed(evt);
            }
        });
        getContentPane().add(Siono4);
        Siono4.setBounds(130, 330, 100, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 51));
        jLabel7.setText("Search by:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(360, 80, 70, 40);

        Siono6.setBackground(new java.awt.Color(244, 164, 96));
        Siono6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Title", "Author" }));
        Siono6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siono6ActionPerformed(evt);
            }
        });
        getContentPane().add(Siono6);
        Siono6.setBounds(430, 80, 78, 40);

        Siono7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Siono7ActionPerformed(evt);
            }
        });
        getContentPane().add(Siono7);
        Siono7.setBounds(510, 80, 223, 40);

        SionoSEARCH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/search.jpg"))); // NOI18N
        SionoSEARCH.setText("SEARCH");
        SionoSEARCH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SionoSEARCHActionPerformed(evt);
            }
        });
        getContentPane().add(SionoSEARCH);
        SionoSEARCH.setBounds(740, 80, 120, 40);

        jLabel8.setFont(new java.awt.Font("Garamond", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 153, 51));
        jLabel8.setText("  Book Information");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 93, 300, 50);

        sionoClear.setBackground(new java.awt.Color(204, 255, 255));
        sionoClear.setText("CLEAR FIELDS");
        sionoClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sionoClearActionPerformed(evt);
            }
        });
        getContentPane().add(sionoClear);
        sionoClear.setBounds(230, 160, 120, 30);

        sionoBorrow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/borrow.jpg"))); // NOI18N
        sionoBorrow.setText("BORROW");
        sionoBorrow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sionoBorrowActionPerformed(evt);
            }
        });
        getContentPane().add(sionoBorrow);
        sionoBorrow.setBounds(60, 470, 130, 35);

        sionoReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/return.jpg"))); // NOI18N
        sionoReturn.setText("RETURN");
        sionoReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sionoReturnActionPerformed(evt);
            }
        });
        getContentPane().add(sionoReturn);
        sionoReturn.setBounds(210, 470, 120, 35);

        sionoX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/x.jpg"))); // NOI18N
        sionoX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sionoXActionPerformed(evt);
            }
        });
        getContentPane().add(sionoX);
        sionoX.setBounds(870, 80, 63, 40);

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 153, 51));
        jLabel9.setText("Required Fields");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 160, 121, 18);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 102));
        jLabel11.setText("Credits to the owner of the icons");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(790, 550, 210, 14);

        background.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        background.setForeground(new java.awt.Color(204, 153, 0));
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/oopProject/bg.jpg"))); // NOI18N
        getContentPane().add(background);
        background.setBounds(0, 0, 960, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Siono3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siono3ActionPerformed
        // TODO add your handling code here:1
    }//GEN-LAST:event_Siono3ActionPerformed

    private void Siono5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siono5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Siono5ActionPerformed

    private void SionoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SionoTableMouseClicked
        // TODO add your handling code here:
        Siono1.setEnabled(false);
        SionoADD.setEnabled(false);
        sionoBorrow.setEnabled(true);
        sionoReturn.setEnabled(true);
        int i = SionoTable.getSelectedRow();
        TableModel mod = SionoTable.getModel();
        Siono1.setText(mod.getValueAt(i,0).toString());
        Siono2.setText(mod.getValueAt(i,1).toString());
        Siono3.setText(mod.getValueAt(i,2).toString());
        Siono5.setText(mod.getValueAt(i,4).toString());
    }//GEN-LAST:event_SionoTableMouseClicked

    private void SionoADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SionoADDActionPerformed
        // TODO add your handling code here:
        try{
            if(Siono1.getText().equals("")){
                String query = "INSERT INTO `library`(`Title`, `Author`, `Status`, `Quantity`) VALUES ('"+Siono2.getText()+"','"+Siono3.getText()+"','"+Siono4.getSelectedItem()+"',"+Siono5.getText()+")";
                sionoExecute(query,"added!");
                }
            else{
                String query = "INSERT INTO `library`(`ISBN`, `Title`, `Author`, `Status`, `Quantity`) VALUES ('"+Siono1.getText()+"','"+Siono2.getText()+"','"+Siono3.getText()+"','"+Siono4.getSelectedItem()+"',"+Siono5.getText()+")";
                sionoExecute(query,"added!\nISBN: "+Siono1.getText());
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: in the Add Button");
        }
    }//GEN-LAST:event_SionoADDActionPerformed

    private void SionoUPDATEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SionoUPDATEActionPerformed
        // TODO add your handling code here:
        Siono1.setEnabled(true);
        try{
            String query = "UPDATE `library` SET `Title`='"+Siono2.getText()+"',`Author`='"+Siono3.getText()+"',`Status`='"+Siono4.getSelectedItem()+"',`Quantity`="+Siono5.getText()+" WHERE `ISBN` = '"+Siono1.getText()+"'";
            sionoExecute(query,"updated!\nISBN: "+Siono1.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: in the Update Button");
        }
    }//GEN-LAST:event_SionoUPDATEActionPerformed

    private void SionoDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SionoDELETEActionPerformed
        // TODO add your handling code here:
        Siono1.setEnabled(true);
        try{
            String query = "DELETE FROM `library` WHERE ISBN ='"+Siono1.getText()+"'";
            sionoExecute(query,"deleted!\nISBN: "+Siono1.getText()); 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"ERROR: in the Delete Button");
        }
    }//GEN-LAST:event_SionoDELETEActionPerformed

    private void Siono1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Siono1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Siono1MouseClicked

    private void Siono7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siono7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Siono7ActionPerformed

    private void Siono4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siono4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Siono4ActionPerformed

    private void SionoSEARCHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SionoSEARCHActionPerformed
        // TODO add your handling code here:
        String combo = Siono6.getSelectedItem().toString();
        ArrayList<Siono> ulist = sionoList();
        DefaultTableModel table = (DefaultTableModel)SionoTable.getModel();
        Object[] row = new Object[5];
        table.getDataVector().removeAllElements();
        revalidate();
        for(int i=0; i<ulist.size(); i++){
            row[0] = ulist.get(i).getISBN();
            row[1] = ulist.get(i).getTITLE();
            row[2] = ulist.get(i).getAUTHOR();
            row[3] = ulist.get(i).getSTATUS();
            row[4] = ulist.get(i).getQUANTITY();
            String isbn =row[0].toString().toUpperCase();
            String title =row[1].toString().toUpperCase();
            String author =row[2].toString().toUpperCase();
            if(combo == "ISBN" && isbn.indexOf(Siono7.getText().toUpperCase()) != -1 && !Siono7.getText().equals("") )
                table.addRow(row);
            else if(combo == "Title" && title.indexOf(Siono7.getText().toUpperCase()) != -1 && !Siono7.getText().equals("") )
                table.addRow(row);
            else if(combo == "Author" && author.indexOf(Siono7.getText().toUpperCase()) != -1 && !Siono7.getText().equals("") )
                table.addRow(row);
        }
            if (SionoTable.getModel().getRowCount()==0){
                table.getDataVector().removeAllElements();
                revalidate();
                display();
                JOptionPane.showMessageDialog(null, "No Results Found", "Information Message",JOptionPane.INFORMATION_MESSAGE);
            }
        
    }//GEN-LAST:event_SionoSEARCHActionPerformed

    private void Siono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Siono1ActionPerformed

    private void sionoClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sionoClearActionPerformed
        // TODO add your handling code here:
        empty();
        Siono1.setEnabled(true);
        SionoADD.setEnabled(true);
    }//GEN-LAST:event_sionoClearActionPerformed

    private void sionoBorrowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sionoBorrowActionPerformed
        // TODO add your handling code here:
        Siono1.setEnabled(true);
        try{
            
            String stat = Siono4.getItemAt(1);
            String stats = Siono4.getItemAt(0);
            String qty = Siono5.getText();
            int qt = Integer.parseInt(qty);
            qt -= 1;
            if(qt > 0){
                String query = "UPDATE `library` SET `Title`='"+Siono2.getText()+"',`Author`='"+Siono3.getText()+"',`Status`='"+stats+"',`Quantity`="+qt+" WHERE `ISBN` = '"+Siono1.getText()+"'";
                sionoExecute(query,"borrowed:\n"+Siono2.getText());
            }
            else if(qt == 0){
                qt = 0;
                String query = "UPDATE `library` SET `Status`='"+stat+"',`Quantity`="+qt+" WHERE `ISBN` = '"+Siono1.getText()+"'";
                sionoExecute(query,"borrowed:\n"+Siono2.getText());
            }
            else{
                qt = 0;
                String query = "UPDATE `library` SET `Status`='"+stat+"',`Quantity`="+qt+" WHERE `ISBN` = '"+Siono1.getText()+"'";
                sionoExecute(query,"Failed to borrow:\n"+Siono2.getText(),"Error Message");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please choose a book!","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sionoBorrowActionPerformed

    private void sionoReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sionoReturnActionPerformed
        // TODO add your handling code here:
        Siono1.setEnabled(true);
        try{
            String qty = Siono5.getText();
            int qt = Integer.parseInt(qty);
            qt += 1;
            String query = "UPDATE `library` SET `Title`='"+Siono2.getText()+"',`Author`='"+Siono3.getText()+"',`Status`='"+Siono4.getSelectedItem()+"',`Quantity`="+qt+" WHERE `ISBN` = '"+Siono1.getText()+"'";
            sionoExecute(query,"returned:\n"+Siono2.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Please choose a book!","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_sionoReturnActionPerformed

    private void sionoXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sionoXActionPerformed
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel)SionoTable.getModel();
        table.getDataVector().removeAllElements();
        revalidate();
        display();
    }//GEN-LAST:event_sionoXActionPerformed

    private void Siono6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Siono6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Siono6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Library.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Library().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Siono1;
    private javax.swing.JTextField Siono2;
    private javax.swing.JTextField Siono3;
    private javax.swing.JComboBox<String> Siono4;
    private javax.swing.JTextField Siono5;
    private javax.swing.JComboBox<String> Siono6;
    private javax.swing.JTextField Siono7;
    private javax.swing.JButton SionoADD;
    private javax.swing.JButton SionoDELETE;
    private javax.swing.JButton SionoSEARCH;
    private javax.swing.JTable SionoTable;
    private javax.swing.JButton SionoUPDATE;
    private javax.swing.JLabel background;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sionoBorrow;
    private javax.swing.JButton sionoClear;
    private javax.swing.JButton sionoReturn;
    private javax.swing.JButton sionoX;
    // End of variables declaration//GEN-END:variables
}
