package Structuretypes;

import static Records.Event_Records.Activate_Event.concatenateDigits;

/**
 * Created by sukru on 20.02.2017.
 */
public class Pdp_info {
    private int NSAPI;
    private String GSN;
    private Ipaddress ipaddress;

    public int getNSAPI() {
        return NSAPI;
    }

    public void setNSAPI(int NSAPI) {
        this.NSAPI = NSAPI;
    }
    public String getGSN() {
        return GSN;
    }

    public void setGSN(int...values) {
        String result = concatenateDigits(values);

        this.GSN = result;
    }

    public Ipaddress getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(Ipaddress ipaddress) {
        this.ipaddress = ipaddress;
    }
}
