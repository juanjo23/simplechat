import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainWindow extends JFrame {
	public MainWindow(){
		
		this.setSize(400, 460);
		this.setTitle("Simple chat");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel contenedor = new JPanel(); 
		contenedor.setLayout(new GridBagLayout());
		
		JTextArea area = new JTextArea();
		area.setBackground(new Color(30, 30, 30));
		area.setForeground(Color.WHITE);
		
		addComponentTo(contenedor, area,   0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.BOTH);
		addComponentTo(contenedor, new JTextField(),   0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL);
		addComponentTo(contenedor, new JButton("Send"),1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.HORIZONTAL);
		this.getContentPane().add(contenedor);
		this.setVisible(true);
					
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
}
