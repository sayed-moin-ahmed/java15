package com.java15.example.lru;

//The Node class for doubly linked list
class Node<K, V> {

    K key;
    V value;
    Node<K, V> next;
    Node<K, V> prev;

    public Node(Node<K, V> prev, Node<K, V> next, K key, V value) {
        this.prev = prev;
        this.next = next;
        this.key = key;
        this.value = value;
    }

}