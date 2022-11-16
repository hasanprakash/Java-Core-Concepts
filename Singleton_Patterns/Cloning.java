package Singleton_Patterns;
class CloningSingleton implements Cloneable {
    private static CloningSingleton instance;
    private String name;
    private CloningSingleton() {
        // private constructor
    }
    public static CloningSingleton getInstance() {
        if(instance == null) {
            synchronized(CloningSingleton.class) {
                if(instance == null) {
                    instance = new CloningSingleton();
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
    // way to prevent singleton pattern from being broken by cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();

        throw new CloneNotSupportedException();
        // this will throw an exception if someone tries to clone the singleton instance
        // or
        // return instance;
    }
}
public class Cloning {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloningSingleton instanceOne = CloningSingleton.getInstance();
        instanceOne.setName("Hasan Prakash (from instanceOne)");
        CloningSingleton instanceTwo = null;
        instanceTwo = (CloningSingleton) instanceOne.clone();

        // testing the instancetwo
        System.out.println(instanceOne.getName()+" and it's hash code is "+instanceOne.hashCode());
        System.out.println(instanceTwo.getName()+" and it's hash code is "+instanceTwo.hashCode());

        // same name with differenct hashcode
    }
}

/*
 * OUTPUT:
 * Hasan Prakash (from instanceOne) and it's hash code is -1954182022
 * Hasan Prakash (from instanceOne) and it's hash code is 556594289
 * 
 * NOTE:
 * The hashcode of the two instances are different, which means that they are two different objects.
 * The class is not singleton anymore.
 * 
 */