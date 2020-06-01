package src.actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import src.ExtraNumpad;

public class ActionInterfaceAdditionalNumpadButton implements ActionInterface {

    private Text inputField;
    private Button button;
    private boolean isCollapsed = true;
    private Composite parent;
    private ExtraNumpad extraNumpad;

    public ActionInterfaceAdditionalNumpadButton(String value, Composite parent, Text inputField) {
        this.inputField = inputField;
        this.parent = parent;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener(){
        
            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
        this.extraNumpad = new ExtraNumpad(parent, inputField);
    }

    @Override
    public void action() {
        if(isCollapsed) {
            extraNumpad.show();
            this.isCollapsed = false;
        } else {
            extraNumpad.hide();
            this.isCollapsed = true;
        }
    }

}