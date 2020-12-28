package com.java15.example.concurrency;

public class Data {

    private String message;
    private boolean consumed = true;

    public synchronized String getMessage() {
        while (consumed){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        consumed = true;
        notifyAll();
        return message;
    }

    public synchronized void setMessage(String message) {
        while(!consumed){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        consumed = false;
        this.message = message;
        notifyAll();
    }


    @Override
    public String toString() {
        return "Data{" +
                "message='" + message + '\'' +
                ", isconsumed=" + consumed +
                '}';
    }
}
