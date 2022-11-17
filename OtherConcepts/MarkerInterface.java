package OtherConcepts;
interface AICloneable {
}
class Hasan implements Cloneable {
    private static Hasan instance = new Hasan();
    private String name;
    private Hasan() {}
    public static Hasan getInstance() {
        return instance;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
        /* 
         * here super.clone() indicates the clone method of the Object class (not abstract method in Cloneable Interface)
         * 
         * where is this Object class extended?
         * "Object" class is extended by the Cloneable interface (by default)
         * if you extend or implement something, you will get the "Object" class indirectly
         * else you will get the "Object" class directly (by default)
         * 
         * Then why we have to implement the Cloneable interface?
         * To get the permission to clone the object. (same applies for serialization)
         * the protected method of clone throws the CloneNotSupportedException otherwise.
         */
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
public class MarkerInterface {
    public static void main(String[] args) {
        Hasan instanceOne = Hasan.getInstance();
        Hasan instanceTwo = null;
        instanceOne.setName("Hasan Prakash from instanceOne");
        try {
            instanceTwo = (Hasan)instanceOne.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.getName() + " with hashcode " + instanceOne.hashCode());
        System.out.println(instanceTwo.getName() + " with hashcode " + instanceTwo.hashCode());
    }
}
