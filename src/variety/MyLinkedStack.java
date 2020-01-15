package variety;

public class MyLinkedStack<T>{
    private class Node{
        private T item;
        private Node next;
        public Node(){
            this.item  =null;
            this.next = null;
        }
        public Node(T item,Node next){
            this.item  =item;
            this.next = next;
        }
        public boolean isEnd(){
            return this.item == null && this.next == null;
        }
    }
    private Node top=new Node();
    public void push(T item){
        top = new Node(item,top);
    }
    public T pop(){
        T result = top.item;
        if(!top.isEnd()){
            top = top.next;
        }
        return result;
    }
    public static void main(String[] args) {
        MyLinkedStack<String> linkedStack = new MyLinkedStack<>();
        for (String item : "! You Love I".split(" ")) {
            linkedStack.push(item);
        }
        String item;
        while ((item = linkedStack.pop()) != null) {
            System.out.print(item + " ");
        }
    }
}
