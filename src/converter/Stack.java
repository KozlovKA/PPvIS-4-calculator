package src.converter;


class CustomStack {
   private int maxSize;
   private char[] stackArray;
   private int top;
   
   public CustomStack(int max) {
      this.maxSize = max;
      this.stackArray = new char[maxSize];
      top = -1;
   }
   public void push(char j) {
      stackArray[++top] = j;
   }
   public char pop() {
      return stackArray[top--];
   }
   public char peek() {
      return stackArray[top];
   }
   public boolean isEmpty() {
      return (top == -1);
   }
}