package queue;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public ImplementQueueUsingStacks(){

    }

    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();

    public void push(int x) {
        firstStack.push(x);
        System.out.println("void push firstStack " + firstStack);

    }

    public int pop() {
        shiftStacksIfNeeded();
//        System.out.println("secondStack" + secondStack);
        System.out.println("firstStack peek" + firstStack);
        return secondStack.pop();
    }

    public int peek() {
        shiftStacksIfNeeded();
        return secondStack.peek();
    }

    public boolean empty() {
        return firstStack.isEmpty() && secondStack.isEmpty();

    }

    public void shiftStacksIfNeeded(){
       if(secondStack.isEmpty()){
           while(!firstStack.isEmpty()){
               secondStack.push(firstStack.pop());
           }
       }
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks myQueue = new ImplementQueueUsingStacks();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}
