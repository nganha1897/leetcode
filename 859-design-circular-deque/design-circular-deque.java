class MyCircularDeque {
    private int size;
    private int maxSize;
    private int front;
    private int end;
    private int[] deque;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = 0;
        maxSize = k;
        front = k-1;
        end = 0;
        deque = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        deque[front] = value;
        front = (front - 1 + maxSize) % maxSize;
        size++;        
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        deque[end] = value;
        end = (end+1) % maxSize;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        front = (front+1)%maxSize;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        end = (end - 1 + maxSize) % maxSize;
        size--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())
            return -1;
        return deque[(front+1)%maxSize];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty())
            return -1;
        return deque[(end-1+maxSize)%maxSize];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == maxSize;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */