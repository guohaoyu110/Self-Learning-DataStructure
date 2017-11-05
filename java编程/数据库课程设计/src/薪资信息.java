/**
 * Created by haoyuguo on 23/06/2017.
 */
//针对薪资信息表
public class 薪资信息 {
    private String ID;
    private int BASIC_PAY;
    private int BONUS;
    private String SEASON;
    public String getSEASON()
    {
        return SEASON;
    }
    public String getID()
    {
        return ID;
    }
    public int getBasic_pay()
    {
        return BASIC_PAY;
    }
    public int getBonus()
    {
        return BONUS;
    }
    public void setID(String ID)
    {
        this.ID=ID;
    }
    public void setSEASON(String SEASON)
    {
        this.SEASON=SEASON;
    }

    public void setBasic_pay(int BASIC_PAY)
    {
        this.BASIC_PAY=BASIC_PAY;
    }
    public void setBonus(int BONUS)
    {
        this.BONUS=BONUS;
    }
}
