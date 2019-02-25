package Controller;


import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import GUI.BorderLayoutGUI;
import GUI.StartGUI;
import GUI.TabMenu;
import GUI.Test;

public class Controller {
	
	public static void main(String[] args) {
		/*
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TabMenu TEST");
		shell.setSize(400, 700);
		shell.setLayout(new FillLayout());
		*/
		
		//StartGUI gui = new StartGUI();
		//BorderLayoutGUI gui = new BorderLayoutGUI();
		//Test test = new Test(shell, SWT.NONE);
		TabMenu tab = new TabMenu();
		
		/*shell.open();
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		*/
	}
	
	

}
