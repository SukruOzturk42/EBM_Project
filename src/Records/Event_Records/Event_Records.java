package Records.Event_Records;

import Records.Records;
import Structuretypes.Header;

/**
 * Created by sukru on 19.02.2017.
 */
public class Event_Records extends Records {
    private Header HEADER;
    private int CAUSE_CODE;
    private int SUB_COUSE_CODE;

    public Header getHEADER() {
        return HEADER;
    }

    public void setHEADER(Header HEADER) {
        this.HEADER = HEADER;
    }

    public int getCAUSE_CODE() {
        return CAUSE_CODE;
    }

    public void setCAUSE_CODE(int COUSE_CODE) {
        this.CAUSE_CODE = COUSE_CODE;
    }

    public int getSUB_COUSE_CODE() {
        return SUB_COUSE_CODE;
    }

    public void setSUB_COUSE_CODE(int SUB_COUSE_CODE) {
        this.SUB_COUSE_CODE = SUB_COUSE_CODE;
    }
}
