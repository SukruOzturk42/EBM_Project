package Records.Event_Records;

import Structuretypes.Location;
import Structuretypes.Old_Location;
import Structuretypes.Pdp_info;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.util.HashMap;

import static Records.Event_Records.Activate_Event.bcd_decode;
import static Records.Event_Records.Activate_Event.concatenateDigits;

/**
 * Created by sukru on 20.02.2017.
 */
public class Rau_Event extends Event_Records {


    private int RAT;
    private int INTRA_RAU_TYPE;
    private int UPDATE_TYPE;
    private Location LOCATİON;
    private String IMSI;
    private int ptmsi_val;
    private String PTMSI;
    private int imeisv_val;
    private String IMEISV;
    private Old_Location OLD_LOCATİON;
    private int TRANSFERRED_PDP;
    private int DROPPED_PDP;
    private int HOMEZONE_IDENTITY;
    private String MSISD;
    private Pdp_info PDP_INFO;
    private int CAUSE_PROT_TYPE;
    private String HLR;

    public int getRAT() {
        return RAT;
    }

    public void setRAT(int RAT) {
        this.RAT = RAT;
    }

    public int getINTRA_RAU_TYPE() {
        return INTRA_RAU_TYPE;
    }

    public void setINTRA_RAU_TYPE(int INTRA_RAU_TYPE) {
        this.INTRA_RAU_TYPE = INTRA_RAU_TYPE;
    }

    public int getUPDATE_TYPE() {
        return UPDATE_TYPE;
    }

    public void setUPDATE_TYPE(int UPDATE_TYPE) {
        this.UPDATE_TYPE = UPDATE_TYPE;
    }

    public Location getLOCATİON() {
        return LOCATİON;
    }

    public void setLocation(int...values) {
        Location location=new Location(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7]);
        this.LOCATİON = location;
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

    public Old_Location getOLD_LOCATİON() {
        return OLD_LOCATİON;
    }

    public void setOLD_LOCATİON(int...values) {
        Old_Location old_location=new Old_Location(values[0],values[1],values[2],values[3]);
        this.OLD_LOCATİON = old_location;
    }

    public int getTRANSFERRED_PDP() {
        return TRANSFERRED_PDP;
    }

    public void setTRANSFERRED_PDP(int TRANSFERRED_PDP) {
        this.TRANSFERRED_PDP = TRANSFERRED_PDP;
    }

    public int getDROPPED_PDP() {
        return DROPPED_PDP;
    }

    public void setDROPPED_PDP(int DROPPED_PDP) {
        this.DROPPED_PDP = DROPPED_PDP;
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

    public Pdp_info getPDP_INFO() {
        return PDP_INFO;
    }

    public void setPDP_INFO(Pdp_info PDP_INFO) {
        this.PDP_INFO = PDP_INFO;
    }

    public int getCAUSE_PROT_TYPE() {
        return CAUSE_PROT_TYPE;
    }

    public void setCAUSE_PROT_TYPE(int CAUSE_PROT_TYPE) {
        this.CAUSE_PROT_TYPE = CAUSE_PROT_TYPE;
    }

    public String getHLR() {
        return HLR;
    }

    public void setHLR(int...values) {
        String result=concatenateDigits(values);
        this.HLR = result;
    }
   @Override
    public String toString(){
      String report_Rau = "Event_id"+getHEADER().getEvent_id()+";\n"+
                "event_result"+event_Result(getHEADER().getEvent_result())+";\n"+
                "start_time="+getHEADER().getTime_hour()+":"+getHEADER().getTime_minute()+":"+getHEADER().getTime_second()+";\n"+
                "rat="+getRAT()+";\n"+
                "int_rau_type="+Intra_Rau_Type(getINTRA_RAU_TYPE())+";\n"+
                "update_type="+update_Type(getUPDATE_TYPE())+";\n"+
                "cause_code="+getCAUSE_CODE()+";\n"+
                "sub_cause_code="+getSUB_COUSE_CODE()+";\n"+
                "Location="+getLOCATİON().toString()+";\n"+
                "imsi="+getIMSI()+";\n"+
               "ptms="+getPTMSI()+";\n"+
                "imeisv="+getIMEISV()+";\n"+
               "old_location="+getOLD_LOCATİON().toString()+";\n"+
               "homezone_Identity="+getHOMEZONE_IDENTITY()+
               "msisdn="+getMSISD()+"\n;"+
               "pdp_info="+getPDP_INFO()+";\n"+
               "cause_prot_type="+getCAUSE_PROT_TYPE()+";\n"+
               "hlr="+getHLR()+"";
      return report_Rau;

    }
    public String event_Result(int value){
        HashMap eventResults=new HashMap();
        eventResults.put(0,"SUCCESS");
        eventResults.put(1,"REJECT");
        eventResults.put(2,"ABORT");
        eventResults.put(3,"IGNORE");
              return (String) eventResults.get(value);
    }

    public String update_Type(int value){
        HashMap update_Type=new HashMap();
        update_Type.put(0,"Ra_Updating");
        update_Type.put(1,"Combined_Ra_La");
        update_Type.put(2,"Combined_Ra_La_With_Imsi");
        update_Type.put(3,"Combined_Periodic");
        return (String)update_Type.get(value);
    }
    public String Intra_Rau_Type(int value){
        String ınt_rau_type;
        if(value==0){
          ınt_rau_type= "INTRA_RAU";}
        else {
            ınt_rau_type = "INTRA_RAU_ISC";
        }
        return ınt_rau_type;
    }
    public enum INTRA_RAU_TYPE{
        INTRA_RAU,
        INTRA_RAU_ISC
    }
    public enum Update_Type{
        Ra_Updating,
        Combined_Ra_LA,
        Combined_Ra_LA_With_Imsi,
        Combined_Periodic

    }
}
