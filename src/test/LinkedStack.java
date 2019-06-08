package test;

import java.util.LinkedList;

public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node(){}
        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        public boolean end() {
            return item != null && next != null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (! top.end()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<String> stack = new LinkedList<>();
        for (String s : "one two three".split(" ")) {
            stack.push(s);
        }
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
