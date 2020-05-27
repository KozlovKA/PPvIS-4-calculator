package src;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import src.actions.ActionInterfaceAdditionalNumpadButton;
import src.actions.ActionInterfaceClearButton;
import src.actions.ActionInterfaceEqualsButton;
import src.actions.ActionInterfaceInputButton;
import src.actions.ActionInterfaceInvertButton;
import src.actions.ActionInterfaceText;
import src.actions.ControlStateInterfaceButton;

public class Numpad extends Composite {

    public Numpad(Composite parent, int style) {
        super(parent, style);
        Text inputField = ActionInterfaceText.getTextField().getText();
        this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
        this.setLayout(new GridLayout(5, true));
        
        ControlStateInterfaceButton undoButton = new ControlStateInterfaceButton(this, "<");
        
        ControlStateInterfaceButton redoButton = new ControlStateInterfaceButton(this, ">");
        
        ActionInterfaceClearButton clearButton = new ActionInterfaceClearButton(inputField, "C", this);

        ActionInterfaceInputButton leftBracketButton = new ActionInterfaceInputButton(inputField, "(", this);

        ActionInterfaceInputButton rightBracketButton = new ActionInterfaceInputButton(inputField, ")", this);
        
        ActionInterfaceInputButton nineButton = new ActionInterfaceInputButton(inputField, "9", this);
        
        ActionInterfaceInputButton eightButton = new ActionInterfaceInputButton(inputField, "8", this);
        
        ActionInterfaceInputButton sevenButton = new ActionInterfaceInputButton(inputField, "7", this);

        ActionInterfaceInputButton plusButton = new ActionInterfaceInputButton(inputField, "+", this);

        ActionInterfaceInputButton minusButton = new ActionInterfaceInputButton(inputField, "-", this);
        
        ActionInterfaceInputButton sixButton = new ActionInterfaceInputButton(inputField, "6", this);
        
        ActionInterfaceInputButton fiveButton = new ActionInterfaceInputButton(inputField, "5", this);
        
        ActionInterfaceInputButton fourButton = new ActionInterfaceInputButton(inputField, "4", this);

        ActionInterfaceInputButton multiplyButton = new ActionInterfaceInputButton(inputField, "*", this);
        
        ActionInterfaceInputButton divisionButton = new ActionInterfaceInputButton(inputField, "/", this);
        
        ActionInterfaceInputButton oneButton = new ActionInterfaceInputButton(inputField, "1", this);
        
        ActionInterfaceInputButton twoButton = new ActionInterfaceInputButton(inputField, "2", this);
        
        ActionInterfaceInputButton threeButton = new ActionInterfaceInputButton(inputField, "3", this);

        ActionInterfaceInputButton moduloButton = new ActionInterfaceInputButton(inputField, "%", this);
        
        ActionInterfaceInvertButton invertButton = new ActionInterfaceInvertButton(inputField, "1/x", this);
        
        ActionInterfaceInputButton zeroButton = new ActionInterfaceInputButton(inputField, "0", this);
        
        ActionInterfaceInputButton commButton = new ActionInterfaceInputButton(inputField, ".", this);

        ActionInterfaceEqualsButton equalsButton = new ActionInterfaceEqualsButton("=", this);

        ActionInterfaceAdditionalNumpadButton additionalButton = new ActionInterfaceAdditionalNumpadButton("Extra task", this, inputField);
    }

}