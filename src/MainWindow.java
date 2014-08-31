import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;


public class MainWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextArea areaChat;
	private JTextField  txtSend;
	private JButton btnSend;
	private JButton btnClient;
	private JButton btnServer;
	
	public MainWindow(){
		
		this.setSize(400, 460);
		this.setTitle("Simple chat");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setComponents();	
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		txtSend.requestFocusInWindow();
		btnClient.addActionListener(this);
		btnServer.addActionListener(this);
		btnSend.addActionListener(this);
					
	}
	
	private void setComponents(){			
		JPanel contenedor = new JPanel(); 		
		contenedor.setLayout(new GridBagLayout());
		
		areaChat = new JTextArea();
		areaChat.setForeground(Color.WHITE);
		areaChat.setBackground(new Color(40, 40, 40));
		
		txtSend = new JTextField();
		txtSend.setBackground(new Color(215, 220, 218));
		
		btnSend = new JButton("Send");
		btnSend.setBackground(new Color(51, 181, 229));
		btnSend.setForeground(Color.WHITE);


		addComponentTo(contenedor, areaChat,0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.BOTH);
		addComponentTo(contenedor, txtSend, 0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.BOTH);
		addComponentTo(contenedor, btnSend, 1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH);
		this.getContentPane().add(contenedor);
		
		JToolBar mBar = new JToolBar();
		mBar.setFloatable(false);
		ImageIcon imgClient = new ImageIcon(this.getClass().getResource("images/client.png"));
		ImageIcon imgServer = new ImageIcon(this.getClass().getResource("images/server.png"));
		btnClient = new JButton("Client", imgClient);
		btnServer = new JButton("Server", imgServer);
		
		mBar.add(btnServer);
		mBar.add(btnClient);
		this.getContentPane().add(mBar, BorderLayout.NORTH);		
		
	}
	
	private void addComponentTo(JPanel panel, Component comp, int posX, int posY,
			int width, int height, double weightX, double weightY, int fill){
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = posX;
		gbc.gridy = posY;
		gbc.gridheight = height;
		gbc.gridwidth = width;
		gbc.weightx = weightX;
		gbc.weighty = weightY;
		gbc.fill = fill;
		panel.add(comp, gbc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnServer){
			Thread t = new Thread(new Server(areaChat));
			t.start();
		}else if(e.getSource() == btnClient){
			Thread t = new Thread(new Client(areaChat));
			t.start();
		}
		
		
	}	
}