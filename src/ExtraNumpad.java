package src;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import src.actions.ActionInterfaceInputButton;

public class ExtraNumpad {

    private Text inputField;
    private Composite parent;
    private List<ActionInterfaceInputButton> buttons = new ArrayList<>();
    private Point prevSize;

    public ExtraNumpad(Composite parent, Text inputField) {
        this.parent = parent;
        this.inputField = inputField;
    }

    public void show() {
        buttons.add(new ActionInterfaceInputButton(inputField, "ln", parent));

        buttons.add(new ActionInterfaceInputButton(inputField, "fact!", parent));
            
        buttons.add(new ActionInterfaceInputButton(inputField, "log", parent));

        this.prevSize = parent.getSize();
        parent.pack();
        parent.setSize(prevSize);
    }

    public void hide() {
        for(int i = 0; i < buttons.size(); i++) {
            buttons.get(i).DisposeButton();
        }
        buttons.clear();
        parent.pack();
        parent.setSize(prevSize);
    }
}