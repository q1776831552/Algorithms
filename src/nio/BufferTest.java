package nio;

import java.nio.CharBuffer;

public class BufferTest {
    public static void main(String[] args) {
        CharBuffer buff = CharBuffer.allocate(8);
        System.out.println(buff.capacity());
        System.out.println(buff.limit());
        System.out.println(buff.position());
        buff.put('a');
        buff.put('b');
        buff.put('c');
        System.out.println("加入三个元素后, position=" + buff.position());
        buff.flip();
        System.out.println("limit = " + buff.limit() + ", position=" + buff.position());
        System.out.println("第一个元素" + buff.get());
        System.out.println("取出一个元素后,position=" + buff.position());
        buff.clear();
        System.out.println("执行clear后,position=" + buff.position() + "limit=" + buff.limit());
        System.out.println("并没有清除" + buff.get());
    }
}
