/**
 * Created by haoyuguo on 21/04/2017.
 */

import java.util.Comparator;
public class SortByShape implements Comparator{

    public int compare(Object o1,Object o2){
        Man man1=(Man)o1;
        Man man2=(Man)o2;
        if(man1.getShape()>man2.getShape())
            return 1;
        else return 0;
    }
}