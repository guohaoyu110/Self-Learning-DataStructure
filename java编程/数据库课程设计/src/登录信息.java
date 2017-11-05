import com.mysql.fabric.proto.xmlrpc.InternalXmlRpcMethodCaller;

/**
 * Created by haoyuguo on 25/06/2017.
 */
public class 登录信息 {
    private String ID;
    private String PASSWORD;
    private int INDEX;
    public String getID()
    {
        return ID;
    }
    public String getPASSWORD()
    {
        return PASSWORD;
    }
    public int getINDEX()
    {
        return INDEX;
    }
    public void setID(String ID)
    {
        this.ID=ID;
    }
    public void setPASSWORD(String PASSWORD)
    {
        this.PASSWORD=PASSWORD;
    }
    public void setINDEX(int INDEX)
    {
        this.INDEX= INDEX;
    }
}
