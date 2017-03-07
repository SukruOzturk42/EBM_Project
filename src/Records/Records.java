package Records;

/**
 * Created by sukru on 19.02.2017.
 */
public class Records {
    private int record_length;
    private int record_type;

    public Records() {
    }

    public Records(int record_length, int record_type) {
        this.record_length = record_length;
        this.record_type = record_type;
    }

    public int getRecord_length() {
        return record_length;
    }

    public void setRecord_length(int record_length) {
        this.record_length = record_length;
    }

    public int getRecord_type() {
        return record_type;
    }

    public void setRecord_type(int record_type) {
        this.record_type = record_type;
    }
}
