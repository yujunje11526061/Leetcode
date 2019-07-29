package easy;

import java.util.concurrent.CountDownLatch;

public class PrintinOrder1114 {


    class Foo1 {
        private volatile boolean first = false;
        private volatile boolean second = false;

        public Foo1() {

        }

        public void first(Runnable printFirst) throws InterruptedException {
            synchronized (this) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
                first = true;
                notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this) {
                while (!first) {
                    wait();
                }
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
                second = true;
                notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this) {
                while (!second) {
                    wait();
                }
                // printThird.run() outputs "third". Do not change or remove this line.
                printThird.run();
                first = second = false;
            }
        }
    }

    class Foo {
        // CountDownLatch

        private CountDownLatch latchA;
        private CountDownLatch latchB;

        public Foo() {
            latchA = new CountDownLatch(1);
            latchB = new CountDownLatch(1);
        }

        public void first(Runnable printFirst) throws InterruptedException {
            try {
                // printFirst.run() outputs "first". Do not change or remove this line.
                printFirst.run();
            }finally {
                latchA.countDown();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            try {
                latchA.await();
                // printSecond.run() outputs "second". Do not change or remove this line.
                printSecond.run();
            }finally {
                latchB.countDown();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            latchB.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
