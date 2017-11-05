/**
 * Created by haoyuguo on 21/04/2017.
 */
public class Man {
    private  String name;
    private int hight;
    private int weight;
    private double bodyShape;
    public Man(String name,int hight,int weight){
        this.name=name;
        this.hight=hight;
        this.weight=weight;
        this.bodyShape=(double)weight/hight;
    }
    public double getShape(){
        return bodyShape;
    }
    public String getName(){
        return name;
    }
}