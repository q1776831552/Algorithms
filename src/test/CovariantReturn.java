package test;

import edu.princeton.cs.algs4.StdOut;

class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
        return "wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        System.out.println(m.process());
        WheatMill w = new WheatMill();
        System.out.println(w.process());
    }
}
