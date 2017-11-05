import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String args[]){
        List<Man> manList = new ArrayList();
        Man p1 = new Man ("郭浩宇",170,60);
        manList.add(p1);
        Man p2 = new Man ("温明阳",182,72);
        manList.add(p2);
        Man p3 = new Man ("刘庆",176,69);
        manList.add(p3);
        Man p4 = new Man ("孙山",190,70);
        manList.add(p4);
        System.out.println("排序前：");
        for(Man element: manList)
            System.out.printf("%s  ",element.getName());
        SortByShape mc = new SortByShape();
        Collections.sort(manList,mc);
        System.out.println("\n按（由瘦到胖）排序后：");
        for(Man element: manList)
            System.out.printf("%s  ",element.getName());

    }
}