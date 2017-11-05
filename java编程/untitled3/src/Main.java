import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Collections;
public class Main {

    public static void main(String[] args) {
	// write your code here
        String schools[]={"江南大学","北京大学","清华大学","江南大学","北京大学","南京大学"};
        List<String>list=Arrays.asList(schools);
        System.out.printf("List: %s\n",list);
        printNonDuplicates(list);
    }
    //从list集合对象为内容，创建Set对象，以达到去除集合中的重复元素
    private static void printNonDuplicates(List<String>values)
    {
        Set<String>set=new HashSet<String>(values);
        System.out.printf("Nonduplicate set:");
        for(String value: set)
            System.out.printf("%s ",value);
        System.out.println();
    }
}
