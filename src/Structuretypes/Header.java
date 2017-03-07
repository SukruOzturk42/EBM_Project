package Structuretypes;

/**
 * Created by sukru on 20.02.2017.
 */
public class Header {
   private int event_id;
   private  int event_result;
   private int time_hour;
   private int time_minute;
   private int time_second;

    public Header() {
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getEvent_result() {
        return event_result;
    }

    public void setEvent_result(int event_result) {
        this.event_result = event_result;
    }

    public int getTime_hour() {
        return time_hour;
    }

    public void setTime_hour(int time_hour) {
        this.time_hour = time_hour;
    }

    public int getTime_minute() {
        return time_minute;
    }

    public void setTime_minute(int time_minute) {
        this.time_minute = time_minute;
    }

    public int getTime_second() {
        return time_second;
    }

    public void setTime_second(int time_second) {
        this.time_second = time_second;
    }
}
