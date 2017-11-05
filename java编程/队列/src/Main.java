import java.util.*;
import java.lang.*;
public class Main<Item> implements Iterable<Item> {
    private Item[] a = (Item[])new Object[1];//栈元素
    private int N = 0;//元素数量

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void resize(int max){
        Item[] temp = (Item[])new Object[max];
        for(int i = 0;i<N;i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item){
        if(N == a.length) resize( 2 * a.length);
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N>0 && N == a.length/4) resize(a.length/2);
        return item;
    }

   // @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = N;
        public boolean hasNext() {
            return i > 0;
        }

        public Item next() {
            return a[--i];
        }

       // @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    public static void main(String args[])
    {
        Main<String> s=new Main<String>();
        Scanner cin=new Scanner(System.in);
        System.out.println("Input a String end with $:");
        while(cin.hasNext()){
            String item=cin.next();
            if(item.equals("$")){
                break;
            }
            else {
                s.push(item);
            }
        }
        // foreach语句是while语句的一种简写方式
        System.out.println("display by for:");
        for(String str : s){
            System.out.print(str+" ");
        }
        System.out.println();
        // which
        System.out.println("display by which:");
        Iterator<String> it=s.iterator();
        while(it.hasNext()){
            String i=it.next();
            System.out.print(i+" ");
        }
    }

}



