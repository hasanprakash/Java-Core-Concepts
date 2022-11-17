package OtherConcepts.JavaKeywords;

public class VolatileKeyword {
    private static volatile int MYVALUE = 0; // volatile keyword is used to make sure that the value of the variable is always read from the main memory
    class ThreadToCatchUp extends Thread {
        @Override
        public void run() {
            int localValue = MYVALUE;
            while (localValue < 5) {
                if (localValue != MYVALUE) {
                    System.out.println("Got Change for MYVALUE : " + MYVALUE);
                    localValue = MYVALUE;
                }
            }
        }
    }
    class ThreadToIncrement extends Thread {
        @Override
        public void run() {
            int localValue = MYVALUE;
            while (localValue < 5) {
                MYVALUE = ++localValue;
                System.out.println("Value is incremented from " + (localValue-1) + " to " + MYVALUE);
                try {
                    Thread.sleep(569);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        VolatileKeyword obj = new VolatileKeyword();
        ThreadToCatchUp threadToCatchUp = obj.new ThreadToCatchUp();
        ThreadToIncrement threadToIncrement = obj.new ThreadToIncrement();
        threadToCatchUp.start();
        threadToIncrement.start();
    }
}
