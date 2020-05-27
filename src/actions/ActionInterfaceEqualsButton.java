package src.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ActionInterfaceEqualsButton implements ActionInterface {

    private String value;
    private Button button;

    private List<ActionInterface> listeners = new ArrayList<>();

    public ActionInterfaceEqualsButton(String value, Composite parent) {
        this.value = value;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
    }

    @Override
    public void action() {
        if (!ActionInterfaceText.getTextField().getText().getText().isEmpty()) {
            listeners.add(StackCalculator.getCalculator());
            listeners.add(ActionInterfaceLabel.getLabel());
            listeners.add(ActionInterfaceText.getTextField());
            listeners.add(ActionInterfaceTree.getTree());
            for (ActionInterface listener : listeners) {
                listener.action();
            }
        }
        listeners.clear();
    }

}