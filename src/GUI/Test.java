package GUI;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

public class Test extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Test(Composite parent, int style) {
		super(parent, SWT.NONE);
		setLayout(new GridLayout(1, false));
		
		Label lblTitel = new Label(this, SWT.NONE);
		GridData gd_lblTitel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_lblTitel.widthHint = 423;
		lblTitel.setLayoutData(gd_lblTitel);
		lblTitel.setAlignment(SWT.CENTER);
		lblTitel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblTitel.setText("Titel");
		
		Composite composite = new Composite(this, SWT.NONE);
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
		
		List list = new List(composite_1, SWT.BORDER | SWT.V_SCROLL);
		
		TabItem tbtmNewItem_1 = new TabItem(tabFolder, SWT.NONE);
		tbtmNewItem_1.setText("New Item");
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 138;
		btnNewButton.setLayoutData(gd_btnNewButton);
		btnNewButton.setText("New Button");
		//setLayout(new RowLayout(SWT.VERTICAL));
		System.out.println("Test.java");
		
		/*ScrolledComposite scrolledComposite = new ScrolledComposite(tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		Composite composite = new Composite(scrolledComposite, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.VERTICAL));
		
		Button btnButton = new Button(composite, SWT.PUSH);
		btnButton.setLayoutData(new RowData(228, SWT.DEFAULT));
		btnButton.setText("Button");
		
		Button btnButton_1 = new Button(composite, SWT.PUSH);
		btnButton_1.setLayoutData(new RowData(228, SWT.DEFAULT));
		btnButton_1.setText("Button");
		
		Button btnButton_2 = new Button(composite, SWT.PUSH);
		btnButton_2.setLayoutData(new RowData(225, SWT.DEFAULT));
		btnButton_2.setText("Button");
		
		Button btnButton_3 = new Button(composite, SWT.PUSH);
		btnButton_3.setLayoutData(new RowData(227, SWT.DEFAULT));
		btnButton_3.setText("Button");
		
		Button btnButton_4 = new Button(composite, SWT.PUSH);
		btnButton_4.setLayoutData(new RowData(225, SWT.DEFAULT));
		btnButton_4.setText("Button");
		
		Button btnButton_5 = new Button(composite, SWT.PUSH);
		btnButton_5.setLayoutData(new RowData(230, SWT.DEFAULT));
		btnButton_5.setText("Button");
		scrolledComposite.setContent(composite);
		tbtmTab_2.setControl(scrolledComposite);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		*/
		
		/*Label label = new Label(tabFolder, SWT.NONE);
		
		Button button_8 = new Button(tabFolder, SWT.NONE);
		button_8.setText("New Button");
		label.setText("New Label");
		*/
		
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
