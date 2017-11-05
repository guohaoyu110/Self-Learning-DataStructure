import java.util.*;
public class Main {
    private static final String colors[]={"red","white","blue"};
    public Main() {
        Vector vector = new Vector();
        printVector(vector);
        vector.add("magenta");
        for (int count = 0; count < colors.length; count++) {
            vector.add(colors[count]);
        }
        vector.add("cyan");
        printVector(vector);
        System.out.println("First element:" + vector.firstElement());
        System.out.println("last element:" + vector.lastElement());
        if (vector.contains("red"))
            System.out.println("\"red\"found at index" + vector.indexOf("red"));
        else
            System.out.println("\"red\"not found\n");
        vector.remove("red");
        System.out.println("\"red\"has been removed");
        printVector(vector);
        if (vector.contains("red"))
            System.out.println("\"red\"found at index" + vector.indexOf("red"));
        else {
            System.out.println("\"red\"found at index");
        }
        System.out.println("Size:" + vector.size() + "\nCapacity:" + vector.capacity());
    }
    private void printVector(Vector vectorToOutput){
        if(vectorToOutput.isEmpty())//判断vector是否为空
            System.out.print("vector is empty");
        else {
            System.out.print("vector contains:");
            //vector的罗列元素需要用到枚举类型
            Enumeration items=vectorToOutput.elements();
            while(items.hasMoreElements())
                System.out.print(items.nextElement()+" ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
	// write your code here
        new Main();
    }
}
