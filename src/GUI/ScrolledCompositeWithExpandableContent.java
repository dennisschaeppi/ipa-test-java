package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class ScrolledCompositeWithExpandableContent {
  
  public static void main( String[] args ) {
    new ScrolledCompositeWithExpandableContent().run();
  }
  
  private Shell shell;
  private ScrolledComposite scrolledComposite;

  void run() {
    createControls();
    layoutControls();
    openShell();
    runEventLoop();
  }

  private void createControls() {
    shell = new Shell( new Display() );
    shell.setText( "Contact Details Form" );
    shell.addListener( SWT.Dispose, event -> event.display.dispose() );
    //shell.setLayout(new FillLayout());
    
    //TabFolder t = new TabFolder(shell, SWT.NONE);
    //TabItem t1 = new TabItem(t, SWT.NONE);
    //t1.setText("T1");
    
    
    scrolledComposite = new ScrolledComposite( shell, SWT.V_SCROLL );
    Composite content = createContent();
    scrolledComposite.setContent( content );
    scrolledComposite.setExpandVertical( true );
    scrolledComposite.setExpandHorizontal( true );
    scrolledComposite.addListener( SWT.Resize, event -> computeMinSize( content ) );
    
    //t1.setControl(content);
  }

  private void computeMinSize( Composite content ) {
    int width = scrolledComposite.getClientArea().width;
    scrolledComposite.setMinSize( content.computeSize( width, SWT.DEFAULT ) );
  }

  private void layoutControls() {
    shell.setLayout( new GridLayout( 1, false ) );
    GridData gridData = new GridData( SWT.FILL, SWT.FILL, true, true );
    scrolledComposite.setLayoutData( gridData );
  }

  private void openShell() {
    shell.pack();
    shell.open();
  }

  private void runEventLoop() {
    while( !shell.isDisposed() ) {
      if( !shell.getDisplay().readAndDispatch() ) {
        shell.getDisplay().sleep();
      }
    }
  }

  private Composite createContent() {
    Composite composite = new Composite( scrolledComposite, SWT.NONE );
    composite.setLayout( new GridLayout( 1, false ) );
    for( int i = 0; i < 10; i++ ) {
      Button button = new Button( composite, SWT.PUSH );
      button.setData( "expanded", Boolean.FALSE );
      button.setText( "Select to expand/collapse" );
      button.setLayoutData( new GridData( SWT.FILL, SWT.FILL, false, false ) );
      button.addListener( SWT.Selection, new Listener() {
        @Override
        public void handleEvent( Event event ) {
          boolean expanded = ( ( Boolean )button.getData( "expanded" ) ).booleanValue();
          expanded = !expanded;
          button.setData( "expanded", Boolean.valueOf( expanded ) );
          GridData gridData = new GridData( SWT.FILL, SWT.FILL, false, false );
          if( expanded ) {
            gridData.heightHint = 150;
          }
          button.setLayoutData( gridData );
          computeMinSize( button.getParent() );
        }
      } );
    }
    return composite;
  }

}
