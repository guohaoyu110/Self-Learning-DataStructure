import java.util.List;
import java.util.Arrays;
import java.util.Collections;
public class Main{
    public static void main(String args[])
    {
        Integer[]ints={4,2,1,5};
        List<Integer>list=Arrays.asList(ints);
        System.out.println("Before sorted:");
        output(list);
        System.out.println("\nAfter sorted:");
        Collections.sort(list);
        output(list);
        Collections.sort(list,Collections.reverseOrder());//用降序排列列表
        System.out.printf("\nMax: %d   Min:  %d",Collections.max(list),Collections.min(list));
        int key=4;
        System.out.printf("\n Searching for %d,found at index %d",key,Collections.binarySearch(list,key));

    }
    private static void output(List<Integer>listRef)
    {
        for(Integer element:listRef)
            System.out.printf("%d ",element);
    }
}
