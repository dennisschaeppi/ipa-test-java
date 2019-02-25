
package GUI;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;

public class TabMenu {
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	
	public TabMenu() {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setText("TabMenu TEST");
		shell.setSize(450, 350);
		//shell.setLayout(new FillLayout());
		
		
		
		
		bsp3(shell);
		//TabFolder t = tab(shell);
		
		//ScrolledComposite scroller = new ScrolledComposite(shell, SWT.V_SCROLL);
		/*Composite c = new Composite(shell, SWT.NONE);
		c.setLayout(new GridLayout(1, false));
		
		Color col = new Color(null, 255, 1, 1);
		c.setBackground(col);
		
		Button b1 = new Button(c, SWT.NONE);
		b1.setText("Button");
		b1.setSize(300, 100);
		
		
		Button b2 = new Button(c, SWT.NONE);
		b2.setText("Button 2");
		b2.setSize(300, 100);
		*/
		
		//scroller.setExpandVertical(true);
		
		
		shell.open();
		
		while(!shell.isDisposed()) {
			if(!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
		
	}
	
	public Listener ls = new Listener() {
		public void handleEvent(Event e) {
			System.out.println(e.button);
		}
	};
	
	public Listener Action(String command, List[] list) {
		
		Listener ls = new Listener() {
			public void handleEvent(Event e) {
				
				
				
				for(int i=0; i<list.length; i++) {
						//System.out.println();
						try {
							int[]items = list[i].getSelectionIndices();
							System.out.println(items[0]+" => "+list[i].getItem(items[0]));
						}catch(Exception f) {
							continue;
						}
						
				
				}
				
				//String buttonText = items[0]+"";
				
			}
		};
		return ls;
	}
	
	public SelectionListener ActionList(List list, Button start) {
		
		
		SelectionListener ls = new SelectionListener() {
			String commandOption = "";
			
			
			
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			
			public void widgetSelected(SelectionEvent arg0) {
				// TODO Auto-generated method stub
				int[]items = list.getSelectionIndices();
				
				
				
				//String buttonText = items[0]+"";
				//System.out.println(items[0]+" => "+list.getItem(items[0]));
				
				start.setText("Start Option "+list.getItem(items[0]));
				start.setEnabled(true);
				
				commandOption = items[0]+";"+list.getItem(items[0]);
				
				
				//setCommandOption(items[0]+";"+list.getItem(items[0]));
				//System.out.println(getCommandOption());
				
				
				
			}
		};
		return ls;
	};
	
	
	
	public TabFolder tab(Shell shell) {
		TabFolder menu = new TabFolder(shell, SWT.NONE);
		menu.setLayout(new GridLayout());
		
		TabItem tab1 = new TabItem(menu, SWT.NONE);
		tab1.setText("UIA");
		
		TabItem tab2 = new TabItem(menu, SWT.NONE);
		tab2.setText("USERT");
		
		return menu;
	}
	
	public void bsp2(Shell shell) {
		shell.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label lblTitle = new Label(shell, SWT.NONE);
		lblTitle.setText("Title");
		
		Composite composite_3 = new Composite(shell, SWT.NONE);
		composite_3.setLayout(new GridLayout(3, false));
		
		Label label_2 = new Label(composite_3, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("Test1");
		
		text_3 = new Text(composite_3, SWT.BORDER);
		GridData gd_text_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_3.widthHint = 216;
		text_3.setLayoutData(gd_text_3);
		
		Button button_2 = new Button(composite_3, SWT.NONE);
		button_2.setText("New Button");
		//button_2.addListener(SWT.Selection, Action("button_2"));
		
		Composite composite_2 = new Composite(shell, SWT.NONE);
		composite_2.setLayout(new GridLayout(3, false));
		
		Label label_1 = new Label(composite_2, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("Test1");
		
		text_2 = new Text(composite_2, SWT.BORDER);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_2.widthHint = 216;
		text_2.setLayoutData(gd_text_2);
		
		Button button_1 = new Button(composite_2, SWT.NONE);
		button_1.setText("New Button");
		//button_1.addListener(SWT.Selection, Action("button_1"));
		
		Composite composite_1 = new Composite(shell, SWT.NONE);
		composite_1.setLayout(new GridLayout(3, false));
		
		Label label = new Label(composite_1, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("Test1");
		
		text_1 = new Text(composite_1, SWT.BORDER);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text_1.widthHint = 216;
		text_1.setLayoutData(gd_text_1);
		
		Button button = new Button(composite_1, SWT.NONE);
		button.setText("New Button");
		//button.addListener(SWT.Selection, Action("button"));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		
		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Test1");
		
		text = new Text(composite, SWT.BORDER);
		GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 216;
		text.setLayoutData(gd_text);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setText("New Button");
		//btnNewButton.addListener(SWT.Selection, Action("btnNewButton"));
		//setLayout(new RowLayout(SWT.VERTICAL));
		System.out.println("Test.java");
	}
	
	public void bsp3(Shell shell) {
		shell.setLayout(new GridLayout(1, false));
		
		Label lblTitel = new Label(shell, SWT.NONE);
		GridData gd_lblTitel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTitel.widthHint = 423;
		lblTitel.setLayoutData(gd_lblTitel);
		lblTitel.setAlignment(SWT.CENTER);
		lblTitel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblTitel.setText("Titel");
		
		Composite composite = new Composite(shell, SWT.NONE);
		GridData gd_composite = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite.heightHint = 237;
		gd_composite.widthHint = 422;
		composite.setLayoutData(gd_composite);
		composite.setLayout(new GridLayout(1, false));
		
		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		GridData gd_tabFolder = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_tabFolder.widthHint = 309;
		gd_tabFolder.heightHint = 171;
		tabFolder.setLayoutData(gd_tabFolder);
		
		TabItem tbtmNewItem = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem.setText("New Item");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem.setControl(composite_1);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		String[] items = {
				"1: Option A", 
				"2: Option B", 
				"3: Option C", 
				"4: Option D", 
				"5: Option E",
				"6: Option F",
				"7: Option G",
				"8: Option H",
				"9: Option I",
				"10: Option J",
				"11: Option K",
				"12: Option L",
				"13: Option M",
				"14: Option N",
				"15: Option O",
				"16: Option P",
				"17: Option Q",
				"18: Option R"};
		
		List list = new List(composite_1, SWT.BORDER | SWT.V_SCROLL);
		list.setItems(items);
		
		
		
		//list.addFocusListener(listener);
		
		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("Tab2");
		
		Composite composite_2 = new Composite(tabFolder, SWT.NONE);
		tbtmNewItem_1.setControl(composite_2);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		String[] items2 = {
				"19: Option S", 
				"20: Option T", 
				"21: Option U", 
				"22: Option V", 
				"23: Option W",
				"24: Option X",
				"25: Option Y",
				"26: Option Z"
				};
		
		List list2 = new List(composite_2, SWT.BORDER | SWT.V_SCROLL);
		list2.setItems(items2);
		
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.setText("No option selected");
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 250;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setEnabled(false);
		
		//setLayout(new RowLayout(SWT.VERTICAL));
		//System.out.println("Test.java");
		//SelectionListener t = ActionList(list, btnNewButton);
		
		
		list.addSelectionListener(ActionList(list, btnNewButton));
		list2.addSelectionListener(ActionList(list2, btnNewButton));
		
		List[] lists = {list, list2};
		
		TabItem[] tabs = tabFolder.getSelection();
		HashMap<String, List> pairs = new HashMap<String, List>();
		
		//System.out.println(tabFolder.getSelection()[0]);
		
		for(int i=0; i<tabs.length; i++) {
			pairs.put(tabs[i].getText(), lists[i]);
		}
		
		
		System.out.println(tabFolder.getSelectionIndex());
		
		btnNewButton.addListener(SWT.Selection, Action("", lists));
		
	}


}
