package GameDemo;


import java.awt.Color;

import javax.swing.JPanel;

public class schiff extends JPanel{


	
	
	public schiff(int x,int y,int lx,int ly) {
	this.setLayout(null);
	this.setSize(x, y);
	this.setBackground(Color.black);
	this.setLocation(lx, ly);
	
	}

}
