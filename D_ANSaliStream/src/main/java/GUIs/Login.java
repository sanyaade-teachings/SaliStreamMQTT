package GUIs;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import CONTROLLERs.VerifyLogin;

/**
 *
 * @author HuynhSang
 */
@SuppressWarnings("serial")
public class Login extends javax.swing.JFrame {

	private String broker;
    /**
     * Creates new form Login
     */
    public Login(String broker) {
    	this.broker = broker;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        panelLoginForm = new javax.swing.JPanel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        cboxRemember = new javax.swing.JCheckBox();
        lblForgotPW = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        lblFB = new javax.swing.JLabel();
        lblGPlus = new javax.swing.JLabel();
        lblTwitter = new javax.swing.JLabel();
        lblLinkedin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 600));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth()/2) - 200,(int) (dimension.getHeight()/2) - 300);
        
        lblLogo.setIcon(new ImageIcon(getClass().getResource("/icon/logo.png")));

        lblUsername.setText("Username:");

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        lblPassword.setText("Password:");

        cboxRemember.setText("Remember Me");
        cboxRemember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxRememberActionPerformed(evt);
            }
        });

        lblForgotPW.setText("Forgot Password?");
        lblForgotPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblForgotPWMouseClicked(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblRegister.setText("Don't have an account? ");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegisterMouseClicked(evt);
            }
        });

        lblFB.setIcon(new ImageIcon(getClass().getResource("/icon/fb.png")));

        lblGPlus.setIcon(new ImageIcon(getClass().getResource("/icon/googleplus.png")));

        lblTwitter.setIcon(new ImageIcon(getClass().getResource("/icon/twitter.png")));

        lblLinkedin.setIcon(new ImageIcon(getClass().getResource("/icon/linkedin.png")));

        javax.swing.GroupLayout panelLoginFormLayout = new javax.swing.GroupLayout(panelLoginForm);
        panelLoginForm.setLayout(panelLoginFormLayout);
        panelLoginFormLayout.setHorizontalGroup(
            panelLoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUsername)
                    .addComponent(txtPassword)
                    .addGroup(panelLoginFormLayout.createSequentialGroup()
                        .addComponent(cboxRemember)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblForgotPW))
                    .addGroup(panelLoginFormLayout.createSequentialGroup()
                        .addComponent(lblFB)
                        .addGap(42, 42, 42)
                        .addComponent(lblGPlus)
                        .addGap(40, 40, 40)
                        .addComponent(lblTwitter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(lblLinkedin))
                    .addGroup(panelLoginFormLayout.createSequentialGroup()
                        .addGroup(panelLoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUsername)
                            .addComponent(lblPassword)
                            .addComponent(lblRegister))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLoginFormLayout.setVerticalGroup(
            panelLoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginFormLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUsername)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboxRemember)
                    .addComponent(lblForgotPW))
                .addGap(18, 18, 18)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRegister)
                .addGap(18, 18, 18)
                .addGroup(panelLoginFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFB)
                    .addComponent(lblLinkedin)
                    .addComponent(lblGPlus)
                    .addComponent(lblTwitter))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(panelLoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(panelLoginForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        
        this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosed(e);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				handleCloseWindow(e);
			}
       	
		});

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void cboxRememberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxRememberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboxRememberActionPerformed

    private void lblForgotPWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblForgotPWMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblForgotPWMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
    	showDialogLogin();
    	VerifyLogin verifyLogin = new VerifyLogin();
    	MODELs.User user = verifyLogin.checkUser(txtUsername.getText(), txtPassword.getText());
    	if(user != null){;
	    	new MainApp(user, verifyLogin.getUsers(), broker).setVisible(true);
	    	dialog.dispose();
	    	this.dispose();
    	}else{
    		txtUsername.setText("");
    		txtPassword.setText("");
    		dialog.dispose();
    	}
    	
    	
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRegisterMouseClicked

    private void handleCloseWindow(WindowEvent e) {
		// TODO Auto-generated method stub
    	int res = javax.swing.JOptionPane.showConfirmDialog(Login.this, "Are you sure you want to close?", "Close?", javax.swing.JOptionPane.YES_NO_OPTION);
    	if ( res == 0 ) {
    		this.dispose();
    		System.exit(0);
    	}
	}
    
    /**
     * @Method showDialog 
     */
    private void showDialogLogin(){
    	dialog = new JDialog(new javax.swing.JFrame(), "Verifying");
    	dialog.setResizable(false);
    	javax.swing.JLabel circle = new javax.swing.JLabel();
    	circle.setPreferredSize(new Dimension(150, 150));
    	ImageIcon img = new ImageIcon(getClass().getResource("/icon/circle.gif"));
    	img.setImage(img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    	circle.setIcon(img);
    	dialog.add(circle);
    	dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    	
    	dialog.pack();
        dialog.setAlwaysOnTop(true);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JCheckBox cboxRemember;
    private javax.swing.JLabel lblFB;
    private javax.swing.JLabel lblForgotPW;
    private javax.swing.JLabel lblGPlus;
    private javax.swing.JLabel lblLinkedin;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblTwitter;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPanel panelLoginForm;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    private JDialog dialog;
    // End of variables declaration//GEN-END:variables
}