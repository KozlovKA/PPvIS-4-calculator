package src.converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Java implementation to convert infix expression to postfix*/
// Note that here we use Stack class for Stack operations 
  
import java.util.Stack; 
  
public class InfixToPostfix 
{ 
    // A utility function to return precedence of a given operator 
    // Higher returned value means higher precedence 
    static int Prec(char ch) 
    { 
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
        case '%': 
            return 2; 
       
        case '^': 
        case '!':
        case '@':
        case '#':
        case '$':
            return 3; 
        } 
        return -1; 
    } 
       
    // The main method that converts given infix expression 
    // to postfix expression.  
    public static List<String> Convert(String exp) 
    { 
        // initializing empty String for result 
        String result = new String("");

        exp = exp.replaceAll("(ln|fact!|log|\\*|/|\\+|-|%)", " $1 ");
        exp = exp.replaceAll("ln", "!");
        exp = exp.replaceAll("fact!", "@");
        exp = exp.replaceAll("log", "#");
          
        // initializing empty stack 
        Stack<Character> stack = new Stack<>(); 
          
        for (int i = 0; i<exp.length(); ++i) 
        { 
            char c = exp.charAt(i); 
              
             // If the scanned character is an operand, add it to output. 
            if (Character.isLetterOrDigit(c) || c == '.' || c == ' ') 
                result += c; 
               
            // If the scanned character is an '(', push it to the stack. 
            else if (c == '(') 
                stack.push(c); 
              
            //  If the scanned character is an ')', pop and output from the stack  
            // until an '(' is encountered. 
            else if (c == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result += " ";
                    result += stack.pop(); 
                }
                  
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return null; // invalid expression        
                }         
                else {
                    stack.pop(); 
                }
            } 
            else // an operator is encountered 
            { 
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){ 
                    if(stack.peek() == '(') 
                        return null; 
                    result += stack.pop(); 
             } 
                stack.push(c); 
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek() == '(') 
                return null; 
            result += " ";
            result += stack.pop(); 
         }
         var operands = new ArrayList<String>(Arrays.asList(result.split(" ")));
         operands.removeIf(i -> i.isBlank());
        return operands; 
    }
   }