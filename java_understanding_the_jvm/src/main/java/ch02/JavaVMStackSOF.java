package ch02;

import lombok.SneakyThrows;

/**
 * -Xss136k
 * java.lang.StackOverflowError
 */
public class JavaVMStackSOF {
    private int length = 1;

    public void stackLeak() {
        length++;
        long a,b,c,d; // 用来增加栈帧大小
        stackLeak();
    }

    @SneakyThrows
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("length " + oom.length);
            System.out.println(e.toString());
        }
    }
}
