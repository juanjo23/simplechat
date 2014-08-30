import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame {
	public MainWindow(){
		addComponentTo(null, null, 0, 0, 0, 0, 0, 0, 0);
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
