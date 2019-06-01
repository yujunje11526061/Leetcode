package medium;

public class DesignCircularDeque641 {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        boolean param_1 = obj.insertLast(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.insertFront(3);
        boolean param_4 = obj.insertFront(4);
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();

    }

    static class MyCircularDeque {
        private int[] deque;
        private int capacity;
        private int front = 0;
        private int rear = 0;
        int cnt = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.deque = new int[k];
            this.capacity = k;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            } else {
                if (cnt == 0) {
                    front=0;
                    rear=0;
                } else {
                    front = (front + 1) % capacity;
                }
                deque[front] = value;
                cnt++;
                return true;
            }
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            } else {
                if(cnt==0){
                    front=0;
                    rear=0;
                }else{
                    rear = (rear - 1 + capacity) % capacity;
                }
                deque[rear] = value;
                cnt++;
                return true;
            }
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            } else {
                front = (front - 1 + capacity) % capacity;
                cnt--;
                return true;
            }
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            } else {
                rear = (rear + 1) % capacity;
                cnt--;
                return true;
            }
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            return isEmpty()?-1:deque[front];
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            return isEmpty()?-1:deque[rear];
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return cnt==0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return cnt==capacity;
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
}
