package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableColumn;

import Functions.Batch;


public class StartGUI{
	private final String path = "D:\\git\\ipa-test-perl\\db.pl";
	
	public StartGUI() {
		JFrame frame = new JFrame();
		frame.setSize(400, 200);
		frame.setTitle("IPA Test AWT11");
		
		
		
		JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	    container.add(panel());
	    
	    JScrollPane scrollPane = new JScrollPane(container);
	    frame.getContentPane().add(scrollPane);

	    frame.pack();
	    frame.setLocationRelativeTo(null);
	    frame.setVisible(true);
		//panel(frame);
		//frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
	}
	
	private JPanel panel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		Batch bat = new Batch(null, path);
		
		HashMap<Integer, List<String>> results = bat.getRecords();
		String data[][] = new String[results.size()][2];
		
		for(int i=0; i<results.size(); i++) {
			List<String> columns = results.get(i+1);
			String unterartname = columns.get(0);
			data[i][0] = i+1+"";
			data[i][1] = unterartname;
			
		}
		
		
		System.out.println(data[2][1]);
		
		
		String column[] = {"ID", "Name"};
		
		JTable table = new JTable(data, column);
		
		table.setBounds(50, 50, 200, 300);
		
		
		JLabel titel = new JLabel("Rechner:", JLabel.LEADING);
		titel.setBounds(0, 0, 0, 0);
		
		
		JTextField z1 = new JTextField();
		z1.setSize(100, 30);
		
		JTextField z2 = new JTextField();
		z2.setSize(100, 30);
		
		JTextField erg = new JTextField();
		erg.setSize(100, 30);
		erg.setEditable(false);
		
		
		//Action
		JButton button = new JButton();
		button.setText("Rechnen");
		button.setSize(150, 0);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println("clicked");
				String[] parameter = {z1.getText(), z2.getText()};
				
				Batch bat = new Batch(parameter,path);
				erg.setText(bat.getResult());
			}
		});
		
		
		panel.add(titel);
		panel.add(table);
		/*
		panel.add(z2);
		panel.add(erg);
		panel.add(button);
		*/
		return panel;
	}
	
	
}
