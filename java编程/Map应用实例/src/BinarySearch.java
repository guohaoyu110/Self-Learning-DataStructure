/**
 * Created by haoyuguo on 23/04/2017.
 */
import java.util.Arrays;
public class BinarySearch{
    public static int rank(int key,int a[])
    {
        int lo=0;
        int hi=a.length-1;
        while(lo<=hi)
        {
            int mid=(lo+hi)/2;
            if(key<a[mid]) hi=mid-1;
            else if(key>a[mid]) hi=mid+1;
            else return mid;

        }
        return -1;
    }
    public static void main(String args[])
    {
        int w[]={1,3,4,5,6,7,10,11,12};
        Arrays.sort(w);
        System.out.print(rank(6,w));

    }
}