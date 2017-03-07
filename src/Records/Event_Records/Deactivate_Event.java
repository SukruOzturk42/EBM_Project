package Records.Event_Records;

import Structuretypes.Ipaddress;
import Structuretypes.Location;

import static Records.Event_Records.Activate_Event.bcd_decode;
import static Records.Event_Records.Activate_Event.concatenateDigits;

/**
 * Created by sukru on 7.03.2017.
 */
public class Deactivate_Event extends Event_Records {
    private int rat;
    private int deactivation_trigger;
    private int cause_code;
    private int sub_cause_code;
    private Location location;
    private String imsi;
    private int imeisv_val;
    private String imeisv;
    private int val_GSN;
    private String GSN;
    private int apn_length;
    private String apn;
    private int homezone_identity_length;
    private int homezone_identity;
    private String msisdn;
    private int nsapi;
    private Ipaddress ipaddress;
    private int cause_prot_type;


    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public int getDeactivation_trigger() {
        return deactivation_trigger;
    }

    public void setDeactivation_trigger(int deactivation_trigger) {
        this.deactivation_trigger = deactivation_trigger;
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

    public int getVal_GSN() {
        return val_GSN;
    }

    public void setVal_GSN(int val_GSN) {
        this.val_GSN = val_GSN;
    }

    public String getGSN() {
        return GSN;
    }

    public void setGSN(int...values) {
        String result = concatenateDigits(values);

        this.GSN = result;
    }

    public int getApn_length() {
        return apn_length;
    }

    public void setApn_length(int apn_length) {
        this.apn_length = apn_length;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public int getHomezone_identity_length() {
        return homezone_identity_length;
    }

    public void setHomezone_identity_length(int homezone_identity_length) {
        this.homezone_identity_length = homezone_identity_length;
    }

    public int getHomezone_identity() {
        return homezone_identity;
    }

    public void setHomezone_identity(int homezone_identity) {
        this.homezone_identity = homezone_identity;
    }
    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisd(int...values) {
        String result=concatenateDigits(values);
        String msisdn_withZore="0"+result.substring(0,11);
        this.msisdn=bcd_decode(msisdn_withZore);
    }

    public int getNsapi() {
        return nsapi;
    }

    public void setNsapi(int nsapi) {
        this.nsapi = nsapi;
    }

    public Ipaddress getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(Ipaddress ipaddress) {
        this.ipaddress = ipaddress;
    }

    public int getCause_prot_type() {
        return cause_prot_type;
    }

    public void setCause_prot_type(int cause_prot_type) {
        this.cause_prot_type = cause_prot_type;
    }
}
