package Structuretypes;

import static Records.Event_Records.Activate_Event.concatenateDigits;

/**
 * Created by sukru on 20.02.2017.
 */
public class Ipaddress {
    private String  IPV4;
    private String IPV6;

    public String getIPV4() {
        return IPV4;
    }

    public void setIPV4(int...values) {

        if((values.length==0)&&(values[1]==0)){
            this.IPV4="undefined";
        }
        String result = concatenateIp_Digits(values);
        this.IPV4 = IPV4;
    }

    public String getIPV6() {
        return IPV6;
    }

    public void setIPV6(int...values) {
        if((values.length==0)&&(values[1]==0)){
            this.IPV6="undefined";
        }
        String result = concatenateIp_Digits(values);
        this.IPV6 = result;
    }
    public static String concatenateIp_Digits(int... digits)
    {

        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < digits.length; i++)
        {
            stringBuilder.append(digits[i]);
            stringBuilder.append(".");

        }

        String result=stringBuilder.substring(0,stringBuilder.length()-1).toString();
        return result;
    }

    @Override
    public String toString() {
        return "Ipaddress_ıpv4:"+getIPV4()+",Ipaddress_ıpv6:"+getIPV6();
    }
}
