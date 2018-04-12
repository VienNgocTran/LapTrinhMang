/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuoikylaptrinhmang;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TNV
 */
public class ReadMail extends javax.swing.JFrame {
   
    Vector column, rows, temp;
    
    ArrayList<Mail> arrayList = new ArrayList<>();
    ArrayList<String> list = new ArrayList<>();
    
    public ReadMail() {
        initComponents();
    }
    
    public void dataColumn(){
        column = new Vector();
        column.add("No.");
        column.add("Subject");
        column.add("From");
        column.add("Date");
        column.add("Content");
    }

    public void dataRow(){
        rows = new Vector();
        list.add("No.");
        list.add("Subject");
        list.add("From");
        list.add("Date");
        list.add("Content");
        for (Mail mail : arrayList) {
            temp = new Vector();
            for (int i = 0; i < list.size(); i++) {
                temp.add(i);
            }
            rows.add(temp);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUser = new javax.swing.JLabel();
        lbPass = new javax.swing.JLabel();
        tfUser = new javax.swing.JTextField();
        tfPass = new javax.swing.JPasswordField();
        btnRecevie = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMail = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");
        setResizable(false);

        lbUser.setText("User:");

        lbPass.setText("Pass:");

        tfPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPassKeyPressed(evt);
            }
        });

        btnRecevie.setText("Receivie");
        btnRecevie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecevieActionPerformed(evt);
            }
        });

        tableMail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No.", "Subject", "From", "Date", "Content"
            }
        ));
        tableMail.setFocusable(false);
        tableMail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMail);
        if (tableMail.getColumnModel().getColumnCount() > 0) {
            tableMail.getColumnModel().getColumn(0).setMaxWidth(30);
            tableMail.getColumnModel().getColumn(2).setMaxWidth(200);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnRecevie, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecevie))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnRecevie, lbPass, lbUser, tfPass, tfUser});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRecevieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecevieActionPerformed
        
       
        
        
    }//GEN-LAST:event_btnRecevieActionPerformed

    private void tfPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPassKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             if (tfUser.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long nhap ten tai khoan");
        }else
        if (tfPass.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui long nhap mat khau");
        }else{
            readMail(tfUser.getText().trim(),tfPass.getText().trim());
        }
        }
    }//GEN-LAST:event_tfPassKeyPressed

    private void tableMailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMailMouseClicked
        int number = 0;
        number = tableMail.getSelectedRow();
        JOptionPane.showMessageDialog(this, "Row : "+number);
    }//GEN-LAST:event_tableMailMouseClicked

    public void readMail(String userName, String passWord){
        ReadMail readMail = new ReadMail();
        try {
            String host = "pop.gmail.com";// change accordingly
            //String mailStoreType = "pop3";            

            Properties properties = new Properties();
            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", "995");
            properties.put("mail.pop3.starttls.enable", "true");
            Session session = Session.getInstance(properties,new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    try {
                        return new PasswordAuthentication(userName, passWord);
                    } catch (Exception e) {
                        JOptionPane.showConfirmDialog(ReadMail.this, "Xin chao"+e.getMessage());
                        return null;
                    }
                }
            });
            //create the POP3 store object and connect with the pop server
            Store store = session.getStore("pop3s");
            try {
                store.connect(host, userName, passWord);    
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Tai khoan khong ton tai !");
            }
            

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = 2; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Content: " +getTextFromMessage(message) );
                arrayList.add(new Mail(i+1, message.getSubject(), String.valueOf(message.getFrom()[0]),
                        String.valueOf(message.getSentDate()),readMail.getTextFromMessage(message) ));                
            }
                
            DefaultTableModel model = (DefaultTableModel) tableMail.getModel();
            ArrayList<Mail> mails = arrayList;
            Object rowData[] = new Object[5];
            for (int i = 0; i < mails.size(); i++) {
                rowData[0] = mails.get(i).getId();
                rowData[1] = mails.get(i).getSubject();
                rowData[2] = mails.get(i).getFrom();
                rowData[3] = mails.get(i).getDate();
                rowData[4] = mails.get(i).getContent();
                model.addRow(rowData);
            }
            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        
        } catch (NoSuchProviderException ex) {
            JOptionPane.showConfirmDialog(this, "Error");
        } catch (MessagingException ex) {
            Logger.getLogger(ReadMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private  String getTextFromMessage(Message message) {
        String result = "";
        try {
            
            if (message.isMimeType("text/plain")) {
                result = message.getContent().toString();
            } else if (message.isMimeType("multipart/*")) {
                MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
                result = getTextFromMimeMultipart(mimeMultipart);
            }
            
        } catch (MessagingException | IOException ex) {
        }
        return result;
    }
    private String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }
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
            java.util.logging.Logger.getLogger(ReadMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadMail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRecevie;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbUser;
    private javax.swing.JTable tableMail;
    private javax.swing.JPasswordField tfPass;
    private javax.swing.JTextField tfUser;
    // End of variables declaration//GEN-END:variables
}
