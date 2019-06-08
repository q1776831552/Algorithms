package search;

import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BST {
    private Node root;

    private class Node {
        private char key;
        private int value;
        private Node left, right;
        private int N;

        Node(char key, int value) {
            this.key = key;
            this.value = value;

        }

        public String toString() {
            return "Node [key=" + key + ", value=" + value + "]";
        }
        }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return size(x.left) + size(x.right) + 1;
    }

    public void put(char key, int value) {
        root = put(root, key, value);
    }

    private Node put(Node x, char key, int value) {
        if (x == null) return new Node(key, value);
        if (key < x.key) x.left = put(x.left, key, value);
        else if (key > x.key) x.right = put(x.right, key, value);
        else x.value = value;

        return x;
    }

    public void putByIteration(char key, int value) {
        if (root == null) {
            root = new Node(key, value);
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            if (key < current.key) {
                current = current.left;
            } else if (key == current.key) {
                current.value = value;
                return;
            } else {
                current = current.right;
            }
        }

        if (key < parent.key) {
            parent.left = new Node(key, value);
        } else {
            parent.right = new Node(key, value);
        }
    }

    public int get(char key) {
        return get(root, key);
    }

    private int get(Node x, char key) {
        if (x == null) return -1;

        if (key == x.key) return x.value;
        else if (key < x.key) return get(x.left , key);
        else return get(x.right, key);
    }

    public int getByIteration(char key) {
        if (root == null) {
            return -1;
        }

        Node current = root;
        while (current != null) {
            if (key == current.key) {
                return current.value;
            } else if (key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return -1;
    }

    public void printPre() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                System.out.println(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    public void printMid() {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current);
                current = current.right;
            }
        }
    }

    public void printMid2() {
        if (root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                System.out.println(current);
                current = current.left;
            }

            current = stack.pop();
            current = current.right;
        }
    }

    public void printBack() {
        if(root == null) {
            return;
        }

        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Node> output = new LinkedList<>();
        stack.push(root);

        //存放数据
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            output.push(current);
            if(current.left != null) {
                stack.push(current.left);
            }
            if(current.right != null) {
                stack.push(current.right);
            }

        }

        //遍历数据
        while(!output.isEmpty()) {
            System.out.println(output.pop());
        }
    }

    public void printBack2() {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node pre = null;

        while(node != null || !stack.empty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.peek();
                if(node.right == null || node.right == pre) {
                    stack.pop();
                    res.add(node.value);
                    System.out.println(node.key);
                    pre = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
    }

    public char floor(char key) {
        Node node = floor(root, key);
        if (node == null) {
            return 0;
        }
        return node.key;
    }

    private Node floor(Node node, char key) {
        if (node == null) {
            return null;
        }

        if (key == node.key) {
            return node;
        }

        if (key <= node.key) {
            return floor(node.left, key);
        }

        Node t = floor(node.right, key);
        if (t == null) {
            return node;
        } else {
            return t;
        }
    }


    public Node select(Node node, int k) {
        if (node == null) {
            return null;
        }

        int t = size(node.left);
        if (k < t) {
            return select(node.left, k);
        } else if (k > t) {
            return select(node.right, k - t - 1);
        } else {
            return node;
        }
    }

    public Node min (Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public int rank(char key) {
        return rank(root, key);
    }

    private int rank(Node node, char key) {
        if (node == null) {
            return -1;
        }

        if (key < node.key) {
            return rank(node.left, key);
        } else if (key > node.key) {
            return size(node.left) + 1 + rank(node.right, key);
        } else {
            return size(node.left);
        }
    }

    public void  deleteMin() {
        deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    public void delete(char key) {
        delete(root, key);
    }

    private Node delete(Node x, char key) {
        if (x == null) {
            return null;
        }

        if (key < x.key) {
            return x.left = delete(x.left, key);
        } else if (key > x.key) {
            return x.right = delete(x.right, key);
        } else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        return x;
    }

    public static void main(String[] args) {
        BST bst = new BST();
       /* bst.put('e', 1);
        bst.put('a', 2);
        bst.put('g', 3);
        bst.put('c', 4);
        bst.put('h', 5);*/
        bst.putByIteration('e', 1);
        bst.putByIteration('m', 2);
        bst.putByIteration('g', 3);
        bst.putByIteration('c', 4);
        bst.putByIteration('h', 5);
        bst.putByIteration('n', 6);
        bst.putByIteration('d', 7);
        /*System.out.println(bst.size());
        System.out.println(bst.getByIteration('c'));
        bst.printBack();
        System.out.println(bst.rank('m'));
        bst.delete('m');
        System.out.println(bst.size());*/
        bst.printBack2();


    }
}

