package com.siemens.ch.ts.iltis.pg;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class Fde {

	public static void main(String[] args) {
		Display d = new Display();
		Shell shell = new Shell(d);
		shell.setText("Hello World");
		shell.setLayout(new FillLayout());
		FileDialog fd = new FileDialog(shell, SWT.OPEN);
		fd.setText("Open");
		String[] filterExt = { "*.txt;*.TXT" };
		String[] filterNames = { "TXT files" };
		fd.setFilterExtensions(filterExt);
		fd.setFilterNames(filterNames);
		fd.open();
		
		System.out.println(fd.getFilterPath());
		Text txt = new Text(shell, SWT.SINGLE);
		Button btn = new Button(shell, SWT.NONE);
		btn.setText("BUTTON");
		btn.addListener(SWT.Selection, new Listener() {
			
			@Override
			public void handleEvent(Event arg0) {
				System.out.println(txt.getText());
				
			}
		});
		
		
		shell.open();
		
		while (!shell.isDisposed()) {
			if (!d.readAndDispatch()) {
				d.sleep();
			}
		}

	}

}
