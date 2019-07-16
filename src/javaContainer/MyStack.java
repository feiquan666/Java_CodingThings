package javaContainer;


import org.junit.Test;

import java.util.*;

public class MyStack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v){
        storage.addFirst(v);
    }
    public T peek(){
        return storage.getFirst();
    }
    public T pop(){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    public String toString(){
        return storage.toString();
    }
    @Test
    public void test_stack(){
        MyStack<String> stringStack = new MyStack<>();
        for(String string:"My dog has fleas".split(" "))
            stringStack.push(string);
        while (!stringStack.empty())
            System.out.print(stringStack.pop()+" ");
    }
    @Test
    public void test_expression(){
        String[] value = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---".split("");
        List<String> list = new ArrayList<>();
        for(String item:value)
            list.add(item);
        MyStack myStack = new MyStack();
        String flag;
        for(int i = 0, size = list.size(); i < size; i++){
            if(list.get(i).equals("+")){
                flag = list.get(i+1);
                if(!("+".equals(flag) || "-".equals(flag))){
                    myStack.push(flag);
                }
            }
            if(list.get(i).equals("-")){
                if(!myStack.empty()){
                    System.out.print(myStack.pop()+" ");
                }
            }
        }

    }
}
