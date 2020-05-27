package src.actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ActionInterfaceInvertButton implements ActionInterface {

    private Text inputField;
    private Button button;

    public ActionInterfaceInvertButton(Text inputField, String value, Composite parent) {
        this.inputField = inputField;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener(){
        
            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
    }

    public void DisposeButton() {
        button.dispose();
    }

    @Override
    public void action() {
        inputField.setText("1/(" + inputField.getText() + ")");
    }
}