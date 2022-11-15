package RoughWork;

class Hasan {
    public void finalize() {
        System.out.println("Garbage collected");
    }
}
public class Rough1 {
    public static void main(String[] args) {
        Hasan h = new Hasan() {
            public void finalize() { // overriding the finalize method
                System.out.println("Garbage collected from main");
            }
            // public void sayHi() { // you can't create new function in Hasan class from here
            //     System.out.println("Hi");
            // }
        };
        h.finalize();
    }   
}
