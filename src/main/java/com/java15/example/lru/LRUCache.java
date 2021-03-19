package com.java15.example.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V>  {
    // Variable to store the least recently used element
    private Node<K, V> lruElement;

    // Variable to store the most recently used element
    private Node<K, V> mruElement;

    private Map<K, Node<K, V>> container;
    private int capacity;
    private int currentSize;

    // Constructor for setting the values in instance variables
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        lruElement = new Node<K, V>(null, null, null, null);
        mruElement = lruElement;
        container = new HashMap<K, Node<K, V>>();
    }

    // The get method to perform the retrieve operations on data
    public V get(K key) {
        Node<K, V> tempNode = container.get(key);
        if (tempNode == null) {
            return null;
        }
        // In case the MRU leave the list as it is :
        else if (tempNode.key == mruElement.key) {
            return mruElement.value;
        }

        // Getting the Next and Previous Nodes
        Node<K, V> nextNode = tempNode.next;
        Node<K, V> prevNode = tempNode.prev;

        // If LRU is updated at the left-most
        if (tempNode.key == lruElement.key) {
            nextNode.prev = null;
            lruElement = nextNode;
        }

        // In case we are in the middle, we are required to update the items before and
        // after our item
        else if (tempNode.key != mruElement.key) {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // And here we are finally moving our item to MRU
        tempNode.prev = mruElement;
        mruElement.next = tempNode;
        mruElement = tempNode;
        mruElement.next = null;

        return tempNode.value;

    }

    // The put method to perform the insert operations on cache

    public void put(K key, V value) {
        if (container.containsKey(key)) {
            return;
        }

        // Inserting the new Node at the right-most end position of the linked-list
        Node<K, V> myNode = new Node<K, V>(mruElement, null, key, value);
        mruElement.next = myNode;
        container.put(key, myNode);
        mruElement = myNode;

        // Deleting the entry of position left-most of LRU cache and also updating the
        // LRU pointer
        if (currentSize == capacity) {
            container.remove(lruElement.key);
            lruElement = lruElement.next;
            lruElement.prev = null;
        }

        // Updating the size of container for the firstly added entry and updating the
        // LRU pointer
        else if (currentSize < capacity) {
            if (currentSize == 0) {
                lruElement = myNode;
            }
            currentSize++;
        }
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "lruElement=" + lruElement +
                ", mruElement=" + mruElement +
                ", container=" + container +
                ", capacity=" + capacity +
                ", currentSize=" + currentSize +
                '}';
    }
}
