/**
 * Created by haoyuguo on 21/04/2017.
 */

public class Student {//学生类
    private int num;
    private String name;
    private int age;
    private double java;
    private double html;
    private double sql;
    public int getNum() {
        return num;
    }

    public void setOn(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getHtml() {
        return html;
    }

    public void setHtml(double html) {
        this.html = html;
    }

    public double getSql() {
        return sql;
    }

    public void setSql(double sql) {
        this.sql = sql;
    }

    public String toString(){ //定义toString
        String n="\t"+num+"\t"+name+"\t"+age+"\t"+java+"\t"+"\t"+html+"\t"+sql+"\t";
        return n;
    }
}