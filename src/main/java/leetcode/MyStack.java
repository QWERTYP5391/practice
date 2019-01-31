package leetcode;

public class MyStack<T> {

    private int initialCapacity = 10;
    T [] items = (T[]) new Object[initialCapacity];
    int top = 0;
    int minTop = 0;
    MyStack<T> minStack = new MyStack<T>();

    public void push(T item){
        if(items[top] == null){
            items[top] = item;
            minStack.push(item);
        }
        else{
           items[++top] = item;
        }

    }

    public T pop(){
        T item = null;
        if (top != 0) {
            item = items[top];
            items[top]= null;
            top--;
        }
        else{
            item = items[top];
            items[top] = null;

        }
        return item;
    }

}


