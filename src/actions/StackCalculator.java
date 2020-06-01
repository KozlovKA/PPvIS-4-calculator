package src.actions;

import java.util.Stack;
import org.apache.commons.math3.util.ArithmeticUtils;

import src.converter.InfixToPostfix;

public class StackCalculator implements ActionInterface {

    private static StackCalculator calculator;

    public static StackCalculator getCalculator() {
        return calculator;
    }

    private double answer;

    public StackCalculator() {
        this.calculator = this;
    }

    private void calculate() {
        String input = ActionInterfaceText.getTextField().getText().getText();
        var operands = InfixToPostfix.Convert(input);
        Stack<Double> stack = new Stack<>();
        for (var operand : operands) {
            switch(operand) {
                case "+":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(firstOperand + secondOperand);
                }
                break;
                case "-":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand - firstOperand);
                }
                break;
                case "*":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(firstOperand * secondOperand);
                }
                break;
                case "/":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand / firstOperand);
                }
                break;
                case "%":
                {
                    double firstOperand = stack.pop();
                    double secondOperand = stack.pop();
                    stack.push(secondOperand % firstOperand);
                }
                break;
                case "!":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.log(firstOperand));
                }
                break;
                case "@":
                {
                    double firstOperand = stack.pop();
                    stack.push(ArithmeticUtils.factorialDouble((int) firstOperand));
                }
                break;
                case "#":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.log10(firstOperand));
                }
                break;
                case "":
                break;
                default:
                stack.push(Double.parseDouble(operand));
                break;
            }
        }
        answer = stack.pop();
    }

    public double getAnswer() {
        return answer;
    }

    @Override
    public void action() {
        calculate();
    }
}