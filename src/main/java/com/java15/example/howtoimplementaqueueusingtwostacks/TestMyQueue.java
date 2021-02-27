package com.java15.example.howtoimplementaqueueusingtwostacks;

public class TestMyQueue {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();

        // enqueue integers 1..3
        for(int i = 1; i <= 3; i++)
            queue.enqueue(i);

        // execute 2 dequeue operations
        for(int i = 0; i < 2; i++)
            System.out.println("Dequeued: " + queue.dequeue());

        // enqueue integers 4..5
        for(int i = 4; i <= 5; i++)
            queue.enqueue(i);

        // dequeue the rest
        while(!queue.isEmpty())
            System.out.println("Dequeued: " + queue.dequeue());
    }

}
