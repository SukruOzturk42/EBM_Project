package Records.Event_Records;

import Structuretypes.Header;
import Structuretypes.L_Header;
import Structuretypes.Location;
import Structuretypes.Msıd;

/**
 * Created by sukru on 5.03.2017.
 */
public class Detach_Event extends Activate_Event {
    private L_Header l_header;
    private int rat;
    private int detach_trigger;
    private int detach_type;
    private int cause_prot_type;
    private int cause_code;
    private int sub_cause_code;
    private Location location;
    private Msıd msıd;
    private String hlr;

    public L_Header getL_header() {
        return l_header;
    }

    public void setL_header(int...values) {
        L_Header l_header=new L_Header();
        Header header=new Header();
        header.setEvent_result(values[0]);
        header.setTime_hour(values[1]);
        header.setTime_minute(values[2]);
        header.setTime_second(values[3]);
        l_header.setHeader(header);
        l_header.setTime_milisecond(values[4]);
        l_header.setDuration(values[5]);

        this.l_header = l_header;
    }

    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public int getDetach_trigger() {
        return detach_trigger;
    }

    public void setDetach_trigger(int detach_trigger) {
        this.detach_trigger = detach_trigger;
    }

    public int getDetach_type() {
        return detach_type;
    }

    public void setDetach_type(int detach_type) {
        this.detach_type = detach_type;
    }

    public int getCause_prot_type() {
        return cause_prot_type;
    }

    public void setCause_prot_type(int cause_prot_type) {
        this.cause_prot_type = cause_prot_type;
    }

    public int getCause_code() {
        return cause_code;
    }

    public void setCause_code(int cause_code) {
        this.cause_code = cause_code;
    }

    public int getSub_cause_code() {
        return sub_cause_code;
    }

    public void setSub_cause_code(int sub_cause_code) {
        this.sub_cause_code = sub_cause_code;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(int...values) {
       Location location=new Location(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7]);
        this.location = location;
    }

    public Msıd getMsıd() {
        return msıd;
    }

    public void setMsıd(int...values) {
        Msıd msıd=new Msıd();
        msıd.setIMSI(values[0],values[1],values[2]);
        msıd.setPtmsi_val(values[3]);
        msıd.setPTMSI(values[4],values[5]);
        msıd.setImeisv_val(values[6]);
        msıd.setIMEISV(values[7],values[8],values[9]);
        msıd.setMSISD(values[10],values[11],values[12]);

        this.msıd = msıd;
    }

    public String getHLR() {
        return hlr;
    }

    public void setHLR(int...values) {
        String result=concatenateDigits(values);
        this.hlr = result;
    }
}
