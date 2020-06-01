package src.actions;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ActionInterfaceLabel implements ActionInterface {

    private static ActionInterfaceLabel actionLabel;

    public static ActionInterfaceLabel getLabel() {
        return actionLabel;
    }

    private Label label;

    public ActionInterfaceLabel(Composite parent) {
        this.label = new Label(parent, SWT.BORDER);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));
        this.actionLabel = this;
    }

    @Override
    public void action() {
        String answer = Double.toString(StackCalculator.getCalculator().getAnswer());
        label.setText(answer);
        label.getParent().layout();
    }

}