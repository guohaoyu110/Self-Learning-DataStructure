import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Main {
    public static void main(String args[]){
        List<man> manList = new ArrayList();
        man p1 = new man ("王洋",170,60);
        manList.add(p1);
        man p2 = new man ("李明",182,72);
        manList.add(p2);
        man p3 = new man ("赵华",176,69);
        manList.add(p3);
        man p4 = new man ("孙山",190,70);
        manList.add(p4);
        System.out.println("排序前：");
        for(man element: manList)
            System.out.printf("%s  ",element.getName());
        SortByShape mc = new SortByShape();
        Collections.sort(manList,mc);
        System.out.println("\n按体型（由瘦到胖）排序后：");
        for(man element: manList)
            System.out.printf("%s  ",element.getName());

    }
}