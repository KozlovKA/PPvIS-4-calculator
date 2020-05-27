package src.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.apache.commons.math3.util.ArithmeticUtils;

import src.converter.InfixToPostfix;
import src.converter.In;

public class ActionInterfaceText implements ActionInterface, ControlStateInterface {

    private static ActionInterfaceText text;

    public static ActionInterfaceText getTextField() {
        return text;
    }

    private List<String> states;
    private int stateIndex = 0;
    private Text inputField;

    public ActionInterfaceText(Composite parent) {
        this.inputField = new Text(parent, SWT.BORDER);
        inputField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
        this.states = new ArrayList<>();
        this.text = this;
    }

    public Text getText() {
        return inputField;
    }

    @Override
    public void action() {
        states.clear();
        states.add(inputField.getText());
        calculateStates();
    }

    private void calculateStates() {
        String input = inputField.getText();
        var operands = InfixToPostfix.Convert(input);
        for(int i = 0; i < operands.size(); i++) {
            switch(operands.get(i)) {
                case "+":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand + secondOperand));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "-":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand - secondOperand));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "*":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand * secondOperand));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "/":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand / secondOperand));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "%":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand % secondOperand));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "!":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(Math.log(firstOperand)));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "@":
                {
                    int firstOperand = Integer.parseInt(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(ArithmeticUtils.factorial(firstOperand)));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
                case "#":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf((Math.log10(firstOperand))));
                    String nextState = In.convert(operands);
                    states.add(nextState);
                }
                break;
            }
        }
    }

    @Override
    public void nextState() {
        if(stateIndex + 1 < states.size()) {
            stateIndex++;
            inputField.setText(states.get(stateIndex));
        }
    }

    @Override
    public void previousState() {
        if(stateIndex - 1 >= 0) {
            stateIndex--;
            inputField.setText(states.get(stateIndex));
        }
    }
    
}