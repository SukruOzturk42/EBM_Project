package Structuretypes;

/**
 * Created by sukru on 20.02.2017.
 */
public class L_Header {
    private Header header;
    private int time_milisecond;
    private int duration;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public int getTime_milisecond() {
        return time_milisecond;
    }

    public void setTime_milisecond(int time_milisecond) {
        this.time_milisecond = time_milisecond;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
