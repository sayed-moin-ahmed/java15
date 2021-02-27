package com.java15.example.howtoimplementaqueueusingtwostacks;

public class MyQueue<T> {

    private MyStack<T> inputStack;      // for enqueue
    private MyStack<T> outputStack;     // for dequeue
    private int size;

    public MyQueue() {
        inputStack = new MyStack<>();
        outputStack = new MyStack<>();
    }

    public void enqueue(T e) {
        inputStack.push(e);
        size++;
    }

    public T dequeue() {
        // fill out all the Input if output stack is empty
        if(outputStack.isEmpty())
            while(!inputStack.isEmpty())
                outputStack.push(inputStack.pop());

        T temp = null;
        if(!outputStack.isEmpty()) {
            temp = outputStack.pop();
            size--;
        }

        return temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}