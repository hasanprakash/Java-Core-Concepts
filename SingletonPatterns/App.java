package SingletonPatterns;
class Singleton {
    // lazy initialization using double-checked locking (thread safe)
    private static Singleton instance = null;
    private String name;
    private Singleton() {
        System.out.println("Singleton created");
    }
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized(Singleton.class) { // multiple threads can't access this block at the same time
                if(instance == null) { // double checking for multiple threads which were able to make it into this method at same time
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
class BillPughSingleton {
    private String name;
    // lazy initialization using inner static class (thread safe)
    private BillPughSingleton() {
        System.out.println("BillPughSingleton created");
    }
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}
public class App {
    public static void main(String[] args) {
        // retriving the name variable of Singleton class with static instance;
        // lazy double check singleton
        System.out.println(Singleton.getInstance().getName());
        Singleton.getInstance().setName("Hasan Prakash from Singleton");
        System.out.println(Singleton.getInstance().getName() + "\n");
        
        // lazy bill pugh singleton
        System.out.println(BillPughSingleton.getInstance().getName());
        BillPughSingleton.getInstance().setName("Hasan Prakash from BillPughSingleton");
        System.out.println(BillPughSingleton.getInstance().getName());
    }
}
