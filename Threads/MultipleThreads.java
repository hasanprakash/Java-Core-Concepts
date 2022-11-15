package Threads;
class MyThread implements Runnable {
    String name;
    MyThread(String threadName) {
        Thread t = new Thread(this, threadName);
        this.name = threadName;
        System.out.println("Executing new thread named "+name);
        t.start();
    }
    public void run() {
        try {
            for(int i=0;i<5;i++) {
                System.out.println(name + i);
                Thread.sleep(1000);
            }
        }
        catch(InterruptedException e) {
            System.out.println("Thread "+name+" interrupted");
        }
    }
}

public class MultipleThreads {
    public static void main(String[] args) {
        new MyThread("first");
        new MyThread("second");
        new MyThread("third");
        System.out.println("All threads are started from main");
    }
}
