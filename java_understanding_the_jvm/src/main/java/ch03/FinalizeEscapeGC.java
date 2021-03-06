package ch03;

import lombok.SneakyThrows;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    @SneakyThrows
    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.out.println(SAVE_HOOK == null);// true
        System.out.println(SAVE_HOOK != null);// false
        System.gc();
        Thread.sleep(1000);
        System.out.println(SAVE_HOOK != null);// false
        if (SAVE_HOOK != null) {// ?
            SAVE_HOOK.isAlive();
            System.out.println("为什么这里执行了？");
        } else {
            System.out.println("no, I'm dead!");
        }

        // second time
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(1000);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, I'm dead at last!");
        }
    }

    void isAlive() {
        System.out.println("yes, I'm still alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed.");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }
}
