package lambda;

class ProcessArray {
    public void process(int[] target, Command cmd) {
        cmd.process(target);
    }
}

interface Command {
    void process(int[] target);
}

public class CommandTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        ProcessArray ps = new ProcessArray();
        ps.process(array, target->{
            int sum = 0;
            for (int tmp : target) {
                sum += tmp;
            }
            System.out.println("数组元素的总和是" + sum);
        });
    }
}
