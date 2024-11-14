package org.example;
import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack;
    private int size;
    private int maxSize;

    public Stack(int maxSize) {
        stack = new ArrayList<>();
        size = 0;
        this.maxSize = maxSize;
    }

    public boolean push(T value){
        if(size >= maxSize){
            throw new StackOverflowError("Stack overflow");
        }

        for (int i =0; i<size; i++){
            if(value.equals(stack.get(i))){
                return false;
            }
        }

        stack.add(value);
        size += 1;

        return true;
    }

    public T pop(){
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }else if (size <= 0){
            throw new RuntimeException("Stack underflow");
        }

        size -= 1;
        return stack.remove(stack.size()-1);
    }

    public T peek(){
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size()-1);
    }

    public int size(){
        return size;
    }

    public int getMaxSize(){
        return maxSize;
    }
}
