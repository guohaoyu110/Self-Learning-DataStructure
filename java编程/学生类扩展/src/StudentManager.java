/**
 * Created by haoyuguo on 21/04/2017.
 */
import java.util.*;
public class StudentManager {//管理学生的类
    String msg="\t编号\t姓名\t年龄\tjava\thtml\tsql\t总分\t平均分";
    public void print(Student[] arr){
        System.out.println(msg);

    }
    public boolean exist(int on,Student stu){//判断学生是否存在
        if(stu==null)
            return false;
        else
        if(stu.getNum()==on)
            return true;
        else
            return false;
    }
    public void create(String name,int age,Student[] arr){//添加学生的方法
        Student stu= new Student();
        stu.setName(name);
        stu.setAge(age);

        int i=this.setIndex(arr);
        stu.setOn(i);
        if(i==-1){
            System.out.println("学生人数已经添加到最大值，不能再添加");
        }else{
            arr[i]=stu;
        }
        this.print(arr);
    }

    public void select(int on,Student[] arr){//查询方法

        for(int i=0;i<arr.length;i++){
            if(this.exist(on, arr[i])){
                System.out.println(msg);
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println("--没有这个学生的存在--");
    }


    public int setIndex(Student[] arr){//返回数组里为空的下标
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==null){
                return i;
            }
        }
        return -1;
    }
    public void update(int on,String name,int age,Student[] arr){//更新学员信息
        for(int i=0;i<arr.length;i++){
            if(this.exist(on,arr[i])){
                arr[i].setName(name);
                arr[i].setAge(age);
                System.out.println("---更新学生信息成功---");
                this.print(arr);
                return ;
            }
        }
        System.out.println("没有找到这个学生，更新信息失败");
    }
    public void delete(int on,Student[] arr){
        for(int i=0;i<arr.length;i++){
            if(this.exist(on,arr[i])){
                arr[i]=null;
                this.print(arr);
                return ;
            }
        }
        System.out.println("您所指定编号的学生没有存在");
    }
    public void courseSort(int num,Student[] arr ){//根据指定的科目进行排序操作
        switch(num){
            case 1:
                for(int i=0;i<arr.length-1;i++){  //手写的选择排序
                    int k=i;
                    if(arr[i]==null)
                        continue;
                    for(int j=i+1;j<arr.length;j++){
                        if(arr[j]==null)
                            continue;
                        if(arr[j].getJava()>arr[k].getJava()){
                            k=j;
                        }
                    }
                    if(k!=i){
                        Student t=arr[k];
                        arr[k]=arr[i];
                        arr[i]=t;
                    }
                }break;
            case 2:
                for(int i=0;i<arr.length-1;i++){
                    int k=i;
                    if(arr[i]==null)
                        continue;
                    for(int j=i+1;j<arr.length;j++){
                        if(arr[j]==null)
                            continue;
                    }
                    if(k!=i){
                        Student t=arr[k];
                        arr[k]=arr[i];
                        arr[i]=t;
                    }
                }break;

            case 3:
                for(int i=0;i<arr.length-1;i++){
                    int k=i;
                    if(arr[i]==null)
                        continue;
                    for(int j=i+1;j<arr.length;j++){
                        if(arr[j]==null)
                            continue;
                        if(arr[j].getHtml()>arr[k].getHtml()){
                            k=j;
                        }
                    }
                    if(k!=i){
                        Student t=arr[k];
                        arr[k]=arr[i];
                        arr[i]=t;
                    }
                }break;

            case 4:
                for(int i=0;i<arr.length-1;i++){
                    int k=i;
                    if(arr[i]==null)
                        continue;
                    for(int j=i+1;j<arr.length;j++){
                        if(arr[j]==null)
                            continue;
                        if(arr[j].getSql()>arr[k].getSql()){
                            k=j;
                        }
                    }
                    if(k!=i){
                        Student t=arr[k];
                        arr[k]=arr[i];
                        arr[i]=t;
                    }
                }break;
        }

        this.print(arr);
    }
    public void input(int on,Student[] arr){//输入学生成绩的操作
        Scanner in=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            if(this.exist(on,arr[i])){
                System.out.println("请输入"+arr[i].getName()+"的java成绩");
                if(in.hasNextInt()){ //判断您是否输入的是整数
                    arr[i].setJava(in.nextInt());
                }
                System.out.println("请输入"+arr[i].getName()+"的html成绩");
                if(in.hasNextInt()){
                    arr[i].setHtml(in.nextInt());
                }
                System.out.println("请输入"+arr[i].getName()+"的sql成绩");
                if(in.hasNextInt()){
                    arr[i].setSql(in.nextInt());
                }
                this.print(arr);
                return ;
            }
        }
        System.out.println("没有找到您想找到的学生");
    }
}