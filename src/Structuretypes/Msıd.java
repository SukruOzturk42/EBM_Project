package Structuretypes;

import static Records.Event_Records.Activate_Event.bcd_decode;
import static Records.Event_Records.Activate_Event.concatenateDigits;

/**
 * Created by sukru on 1.03.2017.
 */
public class Msıd {

    private String IMSI;
    private int ptmsi_val;
    private String PTMSI;
    private int imeisv_val;
    private String IMEISV;
    private String MSISD;

    public Msıd() {
    }

    public Msıd(String IMSI, String PTMSI, String IMEISV, String MSISD) {
        this.IMSI = IMSI;
        this.PTMSI = PTMSI;
        this.IMEISV = IMEISV;
        this.MSISD = MSISD;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(int...values) {
        String result = concatenateDigits(values);

        this.IMSI =result;
    }

    public int getPtmsi_val() {
        return ptmsi_val;
    }

    public void setPtmsi_val(int ptmsi_val) {
        this.ptmsi_val = ptmsi_val;
    }

    public String getPTMSI() {
        return PTMSI;
    }

    public void setPTMSI(int...values) {
        String result = concatenateDigits(values);
        this.PTMSI = result;
    }

    public int getImeisv_val() {
        return imeisv_val;
    }

    public void setImeisv_val(int imeisv_val) {
        this.imeisv_val = imeisv_val;
    }

    public String getIMEISV() {
        return IMEISV;
    }

    public void setIMEISV(int...values) {
        String result = concatenateDigits(values);

        this.IMEISV =result;
    }
    public String getMSISD() {
        return MSISD;
    }

    public void setMSISD(int...values) {
        String result=concatenateDigits(values);
        String msisdn_withZore="0"+result.substring(0,11);
        this.MSISD=bcd_decode(msisdn_withZore);
    }
}
