package Records.Event_Records;

import Structuretypes.Ipaddress;
import Structuretypes.Location;

import java.util.Arrays;

/**
 * Created by sukru on 21.02.2017.
 */
public class Activate_Event extends Event_Records {
    private int ACTIVATION_TYPE;
    private int RAT;
    private int CAUSE_PROT_TYPE;
    private Location LOCATION;
    private String IMSI;
    private int imeisv_val;
    private String IMEISV;
    private int val_GSN;
    private String GSN;
    private int APN;
    private int HOMEZONE_IDENTITY;
    private String MSISD;
    private int NSAPI;
    private int L_NSAPI;
    private Ipaddress IPADDRESS;

    public int getACTIVATION_TYPE() {
        return ACTIVATION_TYPE;
    }

    public void setACTIVATION_TYPE(int ACTIVATION_TYPE) {
        this.ACTIVATION_TYPE = ACTIVATION_TYPE;
    }

    public int getRAT() {
        return RAT;
    }

    public void setRAT(int RAT) {
        this.RAT = RAT;
    }

    public int getCAUSE_PROT_TYPE() {
        return CAUSE_PROT_TYPE;
    }

    public void setCAUSE_PROT_TYPE(int CAUSE_PROT_TYPE) {
        this.CAUSE_PROT_TYPE = CAUSE_PROT_TYPE;
    }

    public Location getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(Location LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(int...values) {
        String result = concatenateDigits(values);

        this.IMSI = result;
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

        this.IMEISV = result;
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

    public int getAPN() {
        return APN;
    }

    public void setAPN(int APN) {
        this.APN = APN;
    }

    public int getHOMEZONE_IDENTITY() {
        return HOMEZONE_IDENTITY;
    }

    public void setHOMEZONE_IDENTITY(int HOMEZONE_IDENTITY) {
        this.HOMEZONE_IDENTITY = HOMEZONE_IDENTITY;
    }

    public String getMSISD() {
        return MSISD;
    }

    public void setMSISD(int...values) {
        String result=concatenateDigits(values);
        String msisdn_withZore="0"+result.substring(0,11);
        this.MSISD=bcd_decode(msisdn_withZore);
    }

    public int getNSAPI() {
        return NSAPI;
    }

    public void setNSAPI(int NSAPI) {
        this.NSAPI = NSAPI;
    }

    public int getL_NSAPI() {
        return L_NSAPI;
    }

    public void setL_NSAPI(int l_NSAPI) {
        L_NSAPI = l_NSAPI;
    }

    public Ipaddress getIPADDRESS() {
        return IPADDRESS;
    }

    public void setIPADDRESS(Ipaddress IPADDRESS) {
        this.IPADDRESS = IPADDRESS;
    }

    public static String concatenateDigits(int... digits)
    {

       StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i < digits.length; i++)
        {
            String str = Integer.toHexString(digits[i]);
           stringBuilder.append(str);
        }
        String result=stringBuilder.toString();
        return result;
    }
    public static int convert(int n) {
        return Integer.valueOf(String.valueOf(n), 16);
    }

    public static String bcd_decode(String value){
        char[] myArray=value.toCharArray();
        int index=0;
        char stm = 0;

        while(index<myArray.length)
        {
        stm=myArray[index];
        myArray[index]=myArray[index+1];
        myArray[index+1]=stm;
        index+=2;

        }
return String.valueOf(myArray);
    }
}
