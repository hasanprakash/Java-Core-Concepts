package OtherConcepts.JavaKeywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // now class is not linked, while de-serializing the object
    private String name;
    private String company;
    transient private String wifeName; // transient in here give null when we deserialize 
    // for privacy reasons, we don't want to serialize the wifeName😂
    transient private static String strongAt;
    transient private final String weakAt = "Scala";
    
    private static Employee instance = new Employee();
    private Employee() {
        System.out.println("Private constructor called");
    }
    public static Employee getInstance() {
        return instance;
    }
    public static String getStrongAt() {
        return strongAt;
    }
    public static void setStrongAt(String strongAt) {
        Employee.strongAt = strongAt;
    }
    public String getWeakAt() {
        return weakAt;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getWifeName() {
        return wifeName;
    }
    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }
}

public class TransientKeyword {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("SingletonPatterns/instance.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Employee empObj = Employee.getInstance();
        empObj.setName("Hasan Prakash");
        empObj.setCompany("Copart");
        empObj.setWifeName("Sneha");
        Employee.setStrongAt("Java");
        oos.writeObject(empObj);
        oos.close();

        FileInputStream fis = new FileInputStream("SingletonPatterns/instance.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Employee empObj2 = (Employee) ois.readObject();
        ois.close();

        System.out.println(empObj2.getName());
        System.out.println(empObj2.getCompany());
        System.out.println(empObj2.getWifeName()); // null
        // System.out.println(empObj2.getStrongAt()); // Java // But should be accessed in a static way
        System.out.println(empObj2.getWeakAt()); // Scala // final variables are not serialized
        // transiate doesn't impact anything on static and final variables
    }
}
