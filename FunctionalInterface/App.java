package FunctionalInterface;

@FunctionalInterface
interface Square {
    int calculate(int x); // only 1 abstract method
}

class Operations {
    void callFunction(Square squ) {
        System.out.println(squ.calculate(5)); 
    }
}

public class App {
    public static void main(String[] args) {
        Square s = (int x) -> x*x; // (lambda function = Square instance)
        // basically we can't create instance to interface
        Operations ops = new Operations();
        ops.callFunction(s); // passing as parameter
    }
}
