import java.util.*;
public class Main
{

    public static void main(String[] args)
    {
        List<Person> li = new ArrayList<Person>();
        Person p = new Person("Tom");
        li.add(p);
        for(Person ap: li)
        {
            ap.setName("Jerry");
        }

        System.out.println(li.get(0).getName());     //Jerry  not Tom
    }

}
class Person
{

    public Person(String name)
    {
        this.name = (name==null?"":name);

    }

    private  String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        if(name == null)
            name = "";
        this.name = name;
    }
}