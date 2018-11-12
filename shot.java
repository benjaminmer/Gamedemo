package GameDemo;

import java.awt.Graphics;

import javax.swing.JLabel;

public class shot extends JLabel{

	public shot(int x, int y) {
		this.setLocation(x, y);
		this.setSize(10, 20);
		
		
	}
	
	public void paint (Graphics gr)
	{
		gr.fillOval(0, 0, this.getWidth()-1, this.getHeight());
	}
	
}
