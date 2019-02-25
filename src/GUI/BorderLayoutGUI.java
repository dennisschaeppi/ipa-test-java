package GUI;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class BorderLayoutGUI {
	public BorderLayoutGUI() {
		JFrame frame = new JFrame();
		frame.setSize(250, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(new BoxLayout(buttons, BoxLayout.Y_AXIS));
		
		int blocks = 20;
		for(int i=0; i<blocks; i++) {
			JButton button = new JButton();
			button.setText("Scroll Button No. "+(i+1));
			//button.setSize(400, 100);
			buttons.add(button);
		}
		
		JScrollPane scroll = new JScrollPane(buttons);
		scroll.getVerticalScrollBar().setUnitIncrement(5);
		
		
		
		
		
		
		frame.getContentPane().add(scroll);
		//frame.add(buttons);
		frame.setVisible(true);
	}
}
