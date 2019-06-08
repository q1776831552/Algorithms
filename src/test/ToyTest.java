package test;
interface Cat {}
interface Dog {}
interface Fish {}

class Toy{
    Toy() {}
    Toy(int i) {}
}

public class ToyTest extends Toy implements Cat, Dog, Fish{
    static void printInfo(Class c) {
        System.out.println("Class name:" + c.getName() + " is interface?" + c.isInterface());
        System.out.println("Simple name:" + c.getSimpleName());
        System.out.println("CanonicalName:" + c.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("test.ToyTest");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        for (Class face : c.getInterfaces()) {
            printInfo(face);
        }

        Class up = c.getSuperclass();
        try {
            Object obj = up.newInstance();
            printInfo(obj.getClass());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
