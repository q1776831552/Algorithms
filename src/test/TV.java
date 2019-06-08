package test;

import edu.princeton.cs.algs4.StdOut;

public class TV implements Cloneable{

    private Object clone;

    public void show() {
        System.out.println("tv");
    }


    public Object clone() throws CloneNotSupportedException {
        if (clone == null) {
            clone = super.clone();
            return clone;
        }
         else {
            System.out.print("只能复制一次");
            return null;
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TV tv1 = new TV();
        TV tv2 = (TV) tv1.clone();
        TV tv3 = (TV) tv1.clone();

        System.out.println(tv1);
        System.out.println(tv2);
        System.out.println(tv3);
    }
}


