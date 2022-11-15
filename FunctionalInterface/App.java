package FunctionalInterface;

@FunctionalInterface
interface Square {
    int calculate(int x);
}

public class App {
    public static void main(String[] args) {
        Square s = (int x) -> x*x; // (lambda function = Square instance)
        // basically we can't create instance to interface
        System.out.println(s.calculate(6));
        
    }
}
