package Singleton_Patterns;
class Singleton {
    private static Singleton instance = null;
    private String name;
    private Singleton() {
        System.out.println("Singleton created");
    }
    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
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
public class App {
    public static void main(String[] args) {
        // retriving the name variable of Singleton class with static instance;
        System.out.println(Singleton.getInstance().getName());
        Singleton.getInstance().setName("Hasan Prakash");
        System.out.println(Singleton.getInstance().getName());
    }
}
