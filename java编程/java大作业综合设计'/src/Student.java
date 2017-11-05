/**
 * Created by haoyuguo on 23/05/2017.
 */
public class Student {
    private String sno;
    private String sname;
    private String ssex;
    private int sage;
    public String hobby;
    public String getSno(){
        return sno;
    }
    public String getHobby(){
        return hobby;
    }
    public void setHobby(String hobby){
        this.hobby=hobby;
    }
    public String getSname(){
        return sname;
    }
    public String getSsex(){
        return ssex;
    }
    public int getSage(){
        return sage;
    }
    public void setSno(String sno){
        this.sno=sno;
    }
    public void setSname(String sname){
        this.sname=sname;
    }
    public void setSsex(String ssex){
        this.ssex=ssex;
    }
    public void setSage(int sage){
        this.sage=sage;
    }

}
