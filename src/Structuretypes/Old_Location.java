package Structuretypes;

/**
 * Created by sukru on 20.02.2017.
 */
public class Old_Location {

    private int MCC;
    private int MNC;
    private int LAC;
    private int RAC;

    public Old_Location() {
    }

    public Old_Location(int MCC, int MNC, int LAC, int RAC) {
        this.MCC = MCC;
        this.MNC = MNC;
        this.LAC = LAC;
        this.RAC = RAC;
    }

    public int getMCC() {
        return MCC;
    }

    public void setMCC(int MCC) {
        this.MCC = MCC;
    }

    public int getMNC() {
        return MNC;
    }

    public void setMNC(int MNC) {
        this.MNC = MNC;
    }

    public int getLAC() {
        return LAC;
    }

    public void setLAC(int LAC) {
        this.LAC = LAC;
    }

    public int getRAC() {
        return RAC;
    }

    public void setRAC(int RAC) {
        this.RAC = RAC;
    }

    public String toString(){
        return "mcc="+Integer.toHexString(getMCC())+" mnc="+Integer.toHexString(getMNC())+" lac="+Integer.toHexString(getRAC())+" rac="+Integer.toHexString(getLAC());

    }
}
