package variety;

import sun.misc.Unsafe;

public class LinkedStack<T> {
    private class Node {
        private T item;
        private Node next;

        public Node() {
            this.item = null;
            this.next = null;
        }

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        public boolean isEnd() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.isEnd()) {
            top = top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();

        for (String item : "! You Love I".split(" ")) {
            linkedStack.push(item);
        }
        String item;
        while ((item = linkedStack.pop()) != null) {
            System.out.print(item + " ");
        }
    }
}
