package stack;

import java.util.Stack;

public class MinStack {

    Stack<Integer> intStack;
    Stack<Integer> minIntStack;

    public MinStack(){
        intStack = new Stack<>();
        minIntStack = new Stack<>();
    }

    public void push(int val) {
        intStack.push(val);
        if(minIntStack.isEmpty()){
            minIntStack.push(val);
        } else {
            minIntStack.push(Math.min(minIntStack.peek(), val));
        }


    }

    public void pop() {
        intStack.pop();
        minIntStack.pop();

    }

    public int top() {
        int topInt = intStack.peek();
        return topInt;

    }

    public int getMin() {
        return minIntStack.peek();

    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(4);
        obj.push(2);
//        obj.pop();
//        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("param_4 " + param_4);
    }
}
