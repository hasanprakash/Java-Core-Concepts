package OtherConcepts;

import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        String name = null;

        // using isPresent
        System.out.println(Optional.ofNullable(name).isPresent() ? name : "No Name");

        // using orElse
        System.out.println(Optional.ofNullable(name).orElse("No Name"));

        System.out.println(Optional.ofNullable(name).isPresent() ? Optional.ofNullable(name).get() : "No Name");
        String name2 = "Hasan Prakash";
        System.out.println();
        
        Optional<String> optionalName2 = Optional.ofNullable(name2);
        System.out.println(optionalName2.get());
        System.out.println(optionalName2.hashCode());
        System.out.println(optionalName2.isPresent());
        System.out.println();

        String name3 = null;
        Optional<String> optionalName3 = Optional.ofNullable(name3);
        System.out.println(optionalName3.isPresent());
        System.out.println();

        Optional<String> optionalName4 = Optional.of(name2); 
        // if there is change of getting null, use "ofNullable" instead of "of"
        System.out.println(optionalName4.isPresent());
    }
}
