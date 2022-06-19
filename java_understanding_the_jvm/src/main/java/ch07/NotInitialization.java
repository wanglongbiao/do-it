package ch07;

/**
 * -XX:+TraceClassLoading
 */
public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.class);
//        System.out.println(SubClass.value);
//        System.out.println(new SubClass());
//        SuperClass[] superClasses = new SuperClass[10];
//        System.out.println(superClasses);
        System.out.println(ConstClass.HELLO);
    }
}
