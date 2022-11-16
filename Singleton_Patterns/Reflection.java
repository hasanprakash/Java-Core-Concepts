package Singleton_Patterns;
import java.lang.reflect.Constructor;
class ReflectionSingleton
{
    // public instance initialized when loading the class
    public static ReflectionSingleton instance;
    private String name;
     
    private ReflectionSingleton()
    {
        // private constructor
    }
    public static ReflectionSingleton getInstance() {
        if(instance == null) {
            synchronized(ReflectionSingleton.class) {
                if(instance == null) {
                    instance = new ReflectionSingleton();
                }
            }
        }
        return instance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Reflection {
    public static void main(String[] args) {
        ReflectionSingleton instanceOne = ReflectionSingleton.getInstance();
        instanceOne.setName("Hasan Prakash set with Instance one");
        ReflectionSingleton instanceTwo = null;
        try {
            Constructor<?>[] constructors = ReflectionSingleton.class.getDeclaredConstructors();
            // got the constructors
            System.out.println("Constructors length: " + constructors.length);
            for (Constructor<?> constructor : constructors) {
                // Below code will destroy the singleton pattern
                System.out.println("Printing contructor "+constructor);
                constructor.setAccessible(true); // here is the reflection takes the lead over singleton
                instanceTwo = (ReflectionSingleton) constructor.newInstance(); // so it's the other way to create an instance
                System.out.println("New Instance is created");
                instanceTwo.setName("Hasan Prakash set from instance two");
                System.out.println(instanceTwo.getName());
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.getName()+" and it's hash code is "+instanceOne.hashCode());
        System.out.println(instanceTwo.getName()+" and it's hash code is "+instanceTwo.hashCode());
    }    
}
