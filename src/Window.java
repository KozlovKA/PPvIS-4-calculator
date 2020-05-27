package src;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import src.actions.ActionInterfaceLabel;
import src.actions.ActionInterfaceText;
import src.actions.ActionInterfaceTree;
import src.actions.StackCalculator;

public class Window {
    private Display display = new Display();
    private Shell shell = new Shell(display);

    public Window() {
        GridLayout layout = new GridLayout(7, true);
        shell.setLayout(layout);
        
        ActionInterfaceLabel answer = new ActionInterfaceLabel(shell);
        
        ActionInterfaceText input = new ActionInterfaceText(shell);
        
        ActionInterfaceTree tree = new ActionInterfaceTree(shell);

        Numpad numpad = new Numpad(shell, SWT.BORDER);

        StackCalculator calculator = new StackCalculator();
    }

    public void startWindow() {
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) display.sleep();
        }
        display.dispose();
    }
}