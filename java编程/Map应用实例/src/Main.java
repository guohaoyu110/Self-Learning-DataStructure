import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,Integer>map=new HashMap<String, Integer>();
        buildMap(map);//生成map内容
        displayMap(map);//显示map内容
    }
    private static void buildMap(Map<String,Integer>map)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a line:");
        String input=scanner.nextLine();
        String tokens[]=input.split("");
        for(String token:tokens)
        {
            String word=token.toLowerCase();
            if(map.containsKey(word)){
                int count=map.get(word);
                map.put(word,count+1);

            }
            else
                map.put(word,1);
        }
    }
    private static void displayMap(Map<String,Integer>map)
    {
        Set<String>keys=map.keySet();
        TreeSet<String>sortedKeys=new TreeSet<String>(keys);
        System.out.printf("% nmap contains:\n%-10s%-10s\n","key","value");
        for(String key:sortedKeys)
            System.out.printf("Map size: %d\n",map.size());
    }
}
