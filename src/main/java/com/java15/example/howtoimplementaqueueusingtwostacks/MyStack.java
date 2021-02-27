package com.java15.example.howtoimplementaqueueusingtwostacks;

public class MyStack<T> {

    // inner generic Node class
    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    public void push(T e) {
        Node<T> newElem = new Node(e);

        if(head == null) {
            head = newElem;
        } else {
            newElem.next = head;
            head = newElem;     // new elem on the top of the stack
        }

        size++;
    }

    public T pop() {
        if(head == null)
            return null;

        T elem = head.data;
        head = head.next;   // top of the stack is head.next

        size--;

        return elem;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printStack() {
        System.out.print("Stack: ");

        if(size == 0)
            System.out.print("Empty !");
        else
            for(Node<T> temp = head; temp != null; temp = temp.next)
                System.out.printf("%s ", temp.data);

        System.out.printf("\n");
    }
}