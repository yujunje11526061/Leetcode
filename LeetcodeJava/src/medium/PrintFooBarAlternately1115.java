package medium;

public class PrintFooBarAlternately1115 {

    public static class PrintTool implements Runnable {

        private String sentence;

        public PrintTool(String sentence) {
            this.sentence = sentence;
        }

        @Override
        public void run() {
            System.out.print(sentence);
        }
    }

    public static class MyThreadFoo extends Thread {
        private FooBar instance;
        private PrintTool tool;

        public MyThreadFoo(FooBar instance, PrintTool tool) {
            this.instance = instance;
            this.tool = tool;
        }

        @Override
        public void run() {
            try {
                instance.foo(tool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class MyThreadBar extends Thread {
        private FooBar instance;
        private PrintTool tool;

        public MyThreadBar(FooBar instance, PrintTool tool) {
            this.instance = instance;
            this.tool = tool;
        }

        @Override
        public void run() {
            try {
                instance.bar(tool);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintTool printFoo = new PrintTool("foo");
        PrintTool printBar = new PrintTool("bar");
        FooBar instance = new FooBar(5);
        MyThreadFoo threadFoo = new MyThreadFoo(instance, printFoo);
        MyThreadBar threadBar = new MyThreadBar(instance, printBar);
        threadFoo.start();
        threadBar.start();
    }

    static class FooBar {
        private int n;
        private volatile boolean flag = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            synchronized (this) {
                for (int i = 0; i < n; i++) {
                    while (!flag) {
                        wait();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = false;
                    notifyAll();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            synchronized (this) {
                for (int i = 0; i < n; i++) {
                    while(flag){
                        wait();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = true;
                    notifyAll();
                }
            }
        }
    }
}
