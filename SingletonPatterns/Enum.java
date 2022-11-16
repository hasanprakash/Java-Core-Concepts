package SingletonPatterns;

enum EnumSingleton {
    INSTANCE;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

public class Enum {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.setName("Hasan Prakash");
        System.out.println(EnumSingleton.INSTANCE.getName());
    }
}
