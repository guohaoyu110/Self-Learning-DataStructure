/**
 * Created by haoyuguo on 29/06/2017.
 */
public class 奖惩信息 {
    private String ID;
    private String JC_ID;
    private String JC_DATE;
    private String JC_REASON;
    public String getID()
    {
        return ID;
    }
    public String getJC_ID()
    {
        return JC_ID;
    }
    public String getJC_DATE()
    {
        return JC_DATE;
    }
    public String getJC_REASON()
    {
        return JC_REASON;
    }
    public void setID(String ID)
    {
        this.ID=ID;
    }
    public void setJC_ID(String JC_ID)//奖惩的记录编号
    {
        this.JC_ID=JC_ID;
    }
    public void setJC_DATE(String JC_DATE)
    {
        this.JC_DATE=JC_DATE;
    }
    public void setJC_REASON(String JC_REASON)
    {
        this.JC_REASON=JC_REASON;
    }

}
