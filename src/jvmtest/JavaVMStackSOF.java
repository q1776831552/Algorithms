package jvmtest;

public class JavaVMStackSOF {
    public static final int _1MB = 1024 * 1024;
    private int stackLength = 1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
