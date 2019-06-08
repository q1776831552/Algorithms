package test;

import java.util.Random;

interface Generator<T> {
    T next();
}

class Coffee {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class A extends Coffee{}
class B extends Coffee{}
class C extends Coffee{}
class D extends Coffee{}
class E extends Coffee{}

public class CoffeeGenerator implements Generator<Coffee>{
    private Class[] types = {A.class, B.class, C.class, D.class, E.class};
    private int size;

    CoffeeGenerator() {}

    CoffeeGenerator(int size) {
        this.size = size;
    }

    @Override
    public Coffee next() {
        Random rand = new Random();
        try {
            return (Coffee) types[rand.nextInt(types.length)].newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0 ; i < 5 ; i++) {
            System.out.println(gen.next());
        }


    }
}
