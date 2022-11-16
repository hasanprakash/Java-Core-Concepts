package Singleton_Patterns;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializationSinglton implements Serializable {
    private static SerializationSinglton instance;
    private String name;
    private SerializationSinglton() {
        // private constructor
    }
    public static SerializationSinglton getInstance() {
        if(instance == null) {
            synchronized(SerializationSinglton.class) {
                if(instance == null) {
                    instance = new SerializationSinglton();
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

    // way to prevent singleton pattern from being broken by serialization
    protected Object readResolve() {
        return instance;
        // ObjectInputStream will call this method to get the singleton instance
        // it checks if the class of the object has this method or not, everytime
    }
}

public class Serialization {
    public static void main(String[] args) {
        SerializationSinglton instanceOne = SerializationSinglton.getInstance();
        instanceOne.setName("Hasan Prakash (from instanceOne)");
        SerializationSinglton instanceTwo = null;
        try {
            // serialize to a file
            FileOutputStream fos = new FileOutputStream("instance.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(instanceOne);
            oos.close();

            // de-serialize from file to object
            FileInputStream fis = new FileInputStream("instance.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            instanceTwo = (SerializationSinglton) ois.readObject();
            ois.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found, please check the path");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.out.println("Problem in writing/reading the object to/from file");
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            System.out.println("Class not found, please check the class name");
            e.printStackTrace();
        }

        // testing the instance two
        System.out.println(instanceOne.getName()+" and it's hash code is "+instanceOne.hashCode());
        System.out.println(instanceTwo.getName()+" and it's hash code is "+instanceTwo.hashCode());
        // same value and different hash code
    }
}

/**
 * OUTPUT:
 * Hasan Prakash (from instanceOne) and it's hash code is 189632880
 * Hasan Prakash (from instanceOne) and it's hash code is 125136159
 * 
 * got the same value with different hash code, i.e., we got new instance (singleton is broken)
 */

