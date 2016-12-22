
package javacoeditr.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javacoeditor.rmi.*;
import java.rmi.*;
import java.util.*;


public class frmOnlineUsers extends javax.swing.JFrame{
	EditorService service;
	frmMain frm;
	int invokeAnyChange=0;
        int i=0;
        String user="";
        String nick;
        
	ArrayList<String> getClientList;
        
        
        

    public frmOnlineUsers() {
        initComponents();
    }
    
    public frmOnlineUsers(frmMain _frm, EditorService _service) {
        initComponents();
        frm = _frm;
	service=_service;
    }


    private void initComponents() {
        setSize(300,300);
        jScrollPane1 = new javax.swing.JScrollPane();
        onlineUserArea = new javax.swing.JTextArea();
        
        onlineUserArea.setBounds(50,0,300,250);
        onlineUserArea.setFont(new Font("Arial",Font.BOLD,15));
        onlineUserArea.setForeground(new Color(12,156,6));
        jScrollPane1.setViewportView(onlineUserArea);
        
        refresh = new javax.swing.JButton("Refresh Client List");
        refresh.setBounds(0,0,300,50);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(refresh,BorderLayout.NORTH);
        add(onlineUserArea,BorderLayout.CENTER);

    }
					


    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {
            try
            {
                getClientList=service.getClientList();
                invokeAnyChange=service.getInvokeAnyChange();
            }catch(RemoteException ex)
            {
                System.out.println(ex.getMessage());        
            }
       
        while(i<getClientList.size())
        {
            try
            {
                onlineUserArea.setText("");
                System.out.println(getClientList+" "+getClientList.size());
            for (String clientList : getClientList)
            {
                user = clientList;
                System.out.println("here"+user);
                onlineUserArea.append(user+"\n");
            }
                i++;  
                if(invokeAnyChange==1)
                {
                    i=0;
                    invokeAnyChange=0;
                    getClientList=service.getClientList();
                }
            }catch(RemoteException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
            
	return;               
    }

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
            java.util.logging.Logger.getLogger(frmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form*/
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmOnlineUsers().setVisible(true);
            }
        });
    }

    private javax.swing.JButton refresh;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea onlineUserArea;
        
}