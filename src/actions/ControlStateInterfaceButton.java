package src.actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ControlStateInterfaceButton implements ControlStateInterface, ActionInterface {

    private String value;
    private Button button;

    public ControlStateInterfaceButton(Composite parent, String value) {
        this.value = value;
        this.button = new Button(parent, SWT.PUSH);
        button.setText(value);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.addListener(SWT.MouseDown, new Listener(){
        
            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
    }

    @Override
    public void action() {
        switch(value) {
            case "<":
            {
                previousState();
            }
            break;
            case ">":
            {
                nextState();
            }
            break;
            default:
            break;
        }
    }

    @Override
    public void nextState() {
        ActionInterfaceText.getTextField().nextState();
        ActionInterfaceTree.getTree().nextState();
    }

    @Override
    public void previousState() {
        ActionInterfaceText.getTextField().previousState();
        ActionInterfaceTree.getTree().previousState();
    }

}