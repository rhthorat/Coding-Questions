import java.util.*;

class Main {
  Main() {}
  public static void pushAtBottom(Stack<Integer> toStack, Stack<Integer> fromStack) {
    while(!fromStack.isEmpty()) {
      toStack.push(fromStack.pop());
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();
    stack.push(5);
    stack.push(1);
    stack.push(3);
    stack.push(6);
    Main.pushAtBottom(tempStack, stack);
    stack.push(10);
    pushAtBottom(stack, tempStack);
    while(!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }
}