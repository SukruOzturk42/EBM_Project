package Records.Event_Records;

import Structuretypes.Location;
import Structuretypes.Old_Location;
import Structuretypes.Pdp_info;

import static Records.Event_Records.Activate_Event.bcd_decode;
import static Records.Event_Records.Activate_Event.concatenateDigits;

/**
 * Created by sukru on 7.03.2017.
 */
public class Attach_Event extends Event_Records{
    private int rat;
    private int attach_type;
    private int cause_code;
    private int sub_cause_code;
    private Location location;
    private String imsi;
    private int ptmsi_val;
    private String ptmsi;
    private int imeisv_val;
    private String imeisv;
    private String hlr;
    private String msisd;
    private int cause_prot_type;

    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public int getAttach_type() {
        return attach_type;
    }

    public void setAttach_type(int attach_type) {
        this.attach_type = attach_type;
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

    public String getImsi() {
        return imsi;
    }

    public void setImsi(int...values) {
        String result = concatenateDigits(values);

        this.imsi =result;
    }

    public int getPtmsi_val() {
        return ptmsi_val;
    }

    public void setPtmsi_val(int ptmsi_val) {
        this.ptmsi_val = ptmsi_val;
    }

    public String getPtmsi() {
        return ptmsi;
    }

    public void setPtmsi(int...values) {
        String result = concatenateDigits(values);
        this.ptmsi = result;
    }

    public int getImeisv_val() {
        return imeisv_val;
    }

    public void setImeisv_val(int imeisv_val) {
        this.imeisv_val = imeisv_val;
    }

    public String getImeisv() {
        return imeisv;
    }

    public void setImeisv(int...values) {
        String result = concatenateDigits(values);

        this.imeisv =result;
    }

    public String getHlr() {
        return hlr;
    }

    public void setHlr(int...values) {
        String result=concatenateDigits(values);
        this.hlr = result;
    }

    public String getMsisd() {
        return msisd;
    }

    public void setMsisd(int...values) {
        String msisdn_withZore;
        String result=concatenateDigits(values);
        if(result.length()<11){
            msisdn_withZore="0"+result.substring(0,0);
        }
        else {
            msisdn_withZore = "0" + result.substring(0, 11);
        }
        this.msisd=bcd_decode(msisdn_withZore);
    }

    public int getCause_prot_type() {
        return cause_prot_type;
    }

    public void setCause_prot_type(int cause_prot_type) {
        this.cause_prot_type = cause_prot_type;
    }
}
