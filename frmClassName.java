
package javacoeditr.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;


public class frmClassName extends javax.swing.JFrame {
	String clsname;
        String error_msg;
	frmMain frm;

	public frmClassName() {
        initComponents();
   	}
    
	public frmClassName(frmMain _frm) {
        initComponents();
        frm = _frm;   
	}


    private void initComponents() {
        
        classNameArea = new javax.swing.JTextField();
	enterClassName=new javax.swing.JLabel();
	ok = new javax.swing.JButton("Ok");

	ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

	enterClassName.setText("Enter the Class Name:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

	javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(enterClassName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classNameArea, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ok)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterClassName)
                    .addComponent(classNameArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ok)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
					


    private void okActionPerformed(java.awt.event.ActionEvent evt){
	if(classNameArea.getText().equals(""))
	{
            JOptionPane.showMessageDialog(this, "Please enter the class name");
            return;
  	}

	if(textFieldValidate(classNameArea.getText()))
	{
            frm.setClassName(classNameArea.getText());
            this.dispose();
            return;
	}
    }


    public boolean textFieldValidate(String className){
	String clsname=className.trim();
	error_msg="";
	char ch[]=clsname.toCharArray();
        if(ch[0]>='0'&&ch[0]<='9')
	{
            error_msg+="\n\tnumeric values at first position of class name : Not Allowed ";
            System.out.println(error_msg);
												
	}
	for(int i=0;i<ch.length;i++)
	{
            if((ch[i]>=32&&ch[i]<=47)||(ch[i]>=58&&ch[i]<=64)||(ch[i]>=91&&ch[i]<=94)||(ch[i]>=123&&ch[i]<=126))
            {
                error_msg+="\n\tspecial character '"+ch[i]+"' in class name(except '_') : Not Allowed ";
            }
	}
                System.out.println(error_msg);
	if(Character.isLowerCase(ch[0]))
	{
            ch[0]=Character.toUpperCase(ch[0]);
            String changeName=new String(ch);
            classNameArea.setText(changeName);
	}
	if(!error_msg.equals(""))
	{
            JOptionPane.showMessageDialog(null,error_msg, "alert", JOptionPane.ERROR_MESSAGE);
            return(false);
	}
	else
        {
            error_msg="";
            return(true);
        }										
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmClassName().setVisible(true);
            }
        });
    }

    private javax.swing.JButton ok;
    private javax.swing.JTextField classNameArea;
    private javax.swing.JLabel enterClassName;
        
}



