package Structuretypes;

/**
 * Created by sukru on 20.02.2017.
 */
public class Location {
    private int MCC;
    private int MNC;
    private int LAC;
    private int RAC;
    private int val_CI;
    private int CI;
    private int val_SAC;
    private int SAC;

    public Location() {
    }

    public Location(int MCC, int MNC, int LAC, int RAC, int val_CI, int CI, int val_SAC, int SAC) {
        this.MCC = MCC;
        this.MNC = MNC;
        this.LAC = LAC;
        this.RAC = RAC;
        this.val_CI = val_CI;
        this.CI = CI;
        this.val_SAC = val_SAC;
        this.SAC = SAC;
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

    public int getCI() {
        return CI;
    }

    public void setCI(int CI) {
        this.CI = CI;
    }

    public int getSAC() {
        return SAC;
    }

    public void setSAC(int SAC) {
        this.SAC = SAC;
    }

    public int getVal_CI() {
        return val_CI;
    }

    public void setVal_CI(int val_CI) {
        this.val_CI = val_CI;
    }

    public int getVal_SAC() {
        return val_SAC;
    }

    public void setVal_SAC(int val_SAC) {
        this.val_SAC = val_SAC;
    }

    public String toString(){
        return "mcc="+Integer.toHexString(getMCC())+" mnc="+Integer.toHexString(getMNC())+" lac="+Integer.toHexString(getLAC())+" rac="+Integer.toHexString(getRAC())+" ci="+getCI();
    }
}
