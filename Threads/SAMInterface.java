package Threads;

public class SAMInterface {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override 
            public void run() {
                System.out.println("Thread is running");
                System.out.println("and the thread name is "+Thread.currentThread().getName());
            }
        });
        t.start();

        Thread t1 = new Thread(() -> { 
            System.out.println("Thread is running");
            System.out.println("and the thread name is "+Thread.currentThread().getName());
        });
        // here we can say lambda function is the instance of functional interface or SAM Interface (i.e., Runnable interface)
        t1.start();
    }
}
