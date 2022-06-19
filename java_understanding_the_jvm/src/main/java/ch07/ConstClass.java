package ch07;

public class ConstClass {
    public final static String HELLO = "hello world";

    static {
        System.out.println("const class init");
    }
}
