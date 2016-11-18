package GUIs;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

//import org.opencv.core.Core;

import CONSTANTs.ConfigConstant;
import CONTROLLERs.ControlLiveStreamUI;
import CONTROLLERs.PubSub;
import CONTROLLERs.RecordAudio;
import CONTROLLERs.RecordCam;
import MODELs.PackageData;
import MODELs.User;
import UTILs.Utility;

/**
 *
 * @author HuynhSang
 */
@SuppressWarnings("serial")
public class LiveStream extends javax.swing.JFrame implements ControlLiveStreamUI{
	
	private RecordCam recordCam;
	private RecordAudio recordAudio;
	private PubSub pubsub;
	private String type = "";
	private int subscribeId;
	private User owner;
    /**
     * Creates new form LiveStream
     */
	/*static{
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}*/
	
    public LiveStream(PubSub pubsub, User owner, int subscribeId) {
    	this.pubsub = pubsub;
    	this.owner = owner;
    	this.subscribeId = subscribeId;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void setType(String type){
    	this.type = type;
    }
    
    public void initLiveStreamDevice(String topic, String type){
    	this.type = type;
    	if(type.equals("SaliStream")){
    		recordCam = new RecordCam(pubsub, topic, lblImageCam);
    	}else{
    		recordCam = new RecordCam(pubsub, topic);
    	}
    	recordAudio = new RecordAudio(pubsub, topic);
    	recordAudio.runnable = true;
        recordCam.runnable = true;
        recordCam.start();
        recordAudio.start();
    }
                      
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaChatbox = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaInput = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        lblImageCam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1100, 600));
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (dimension.getWidth()/2) - 550,(int) (dimension.getHeight()/2) - 300);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 600));

        txtAreaChatbox.setEditable(false);
        txtAreaChatbox.setColumns(20);
        txtAreaChatbox.setLineWrap(true);
        txtAreaChatbox.setRows(5);
        jScrollPane1.setViewportView(txtAreaChatbox);

        txtAreaInput.setColumns(20);
        txtAreaInput.setRows(5);
        jScrollPane2.setViewportView(txtAreaInput);

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_END);

        getContentPane().add(lblImageCam, java.awt.BorderLayout.CENTER);

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
    }// </editor-fold>                        

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	String str = owner.getUserName() + ": "+txtAreaInput.getText() + "\n";
        PackageData data = new PackageData("chat", str, " ", subscribeId, owner.getId()+"");
        txtAreaInput.setText("");
        if(type.equals("call")){
        	Utility.sendMsg(pubsub, Utility.constructJSON(data).getBytes(), ConfigConstant.prefixTopic + "chat" + subscribeId, 0);
        	Utility.sendMsg(pubsub, Utility.constructJSON(data).getBytes(), ConfigConstant.prefixTopic + "chat" + owner.getId(), 0);
        }else{
        	Utility.sendMsg(pubsub, Utility.constructJSON(data).getBytes(), ConfigConstant.prefixLiveStream + "chat" + subscribeId, 0);
        }
        
    }                                       
    
    private void handleCloseWindow(WindowEvent e){
    	int res = javax.swing.JOptionPane.showConfirmDialog(LiveStream.this, "Are you sure you want to close?", "Close?", javax.swing.JOptionPane.YES_NO_OPTION);
    	if ( res == 0 ) {
            // dispose method issues the WINDOW_CLOSED event
    		if(type.equals("watching")){
    			pubsub.unSubscribe(ConfigConstant.prefixLiveStream + "video" + subscribeId);
    			pubsub.unSubscribe(ConfigConstant.prefixLiveStream + "chat" + subscribeId);
    		}
    		else{
    			recordCam.runnable = false;
        		recordAudio.runnable = false;
        		if(type.equals("call")){
        			pubsub.unSubscribe(ConfigConstant.prefixTopic + "call" + subscribeId);
        			pubsub.unSubscribe(ConfigConstant.prefixTopic + "chat" + subscribeId);
        		}else{
        			pubsub.unSubscribe(ConfigConstant.prefixLiveStream + "chat" + subscribeId);
        			PackageData data = new PackageData("notice", "off", " ", 0, subscribeId + "");
        			Utility.sendMsg(pubsub, Utility.constructJSON(data).getBytes(), ConfigConstant.liveStreamNotice, 0);
        		}
    		}
        	LiveStream.this.dispose();
        }
    }
    
    public javax.swing.JLabel getLblImageCam(){
    	return this.lblImageCam;
    }
    
    public javax.swing.JTextArea getTxtAreaChatbox(){
    	return this.txtAreaChatbox;
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnSend;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImageCam;
    private javax.swing.JTextArea txtAreaChatbox;
    private javax.swing.JTextArea txtAreaInput;
    private JDialog dialog;
    // End of variables declaration                   
    
    /**
     * @Method showDialog 
     */
    @Override
    public void showWaitDialog(){
    	dialog = new JDialog(new javax.swing.JFrame(), "Waiting for accept to call");
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
    
	@Override
	public void closeWaitDialog() {
		// TODO Auto-generated method stub
		dialog.dispose();
	}

	@Override
	public void closeAll() {
		// TODO Auto-generated method stub
		if(!type.equals("watching")){
			if(type.equals("SaliStream")){
				recordCam.runnable = false;
				recordAudio.runnable = false;
				pubsub.unSubscribe(ConfigConstant.prefixLiveStream + "chat" + subscribeId);
			}else{
				closeWaitDialog();
			}
		}
		LiveStream.this.dispose();
	}

	@Override
	public void closeLiveStream() {
		// TODO Auto-generated method stub
		LiveStream.this.dispose();
	}
}