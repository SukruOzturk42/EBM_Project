import Records.Records;

/**
 * Created by sukru on 19.02.2017.
 */
public class Header_Record extends Records {
    private int file_format_version;
    private int file_information_version;
    private int time_year;
    private int time_mounth;
    private int time_day;
    private int time_hour;
    private int time_minute;
    private int time_second;

    public Header_Record() {
    }

    public int getFile_format_version() {
        return file_format_version;
    }

    public void setFile_format_version(int file_format_version) {
        this.file_format_version = file_format_version;
    }

    public int getFile_information_version() {
        return file_information_version;
    }

    public void setFile_information_version(int file_information_version) {
        this.file_information_version = file_information_version;
    }

    public int getTime_year() {
        return time_year;
    }

    public void setTime_year(int time_year) {
        this.time_year = time_year;
    }

    public int getTime_mounth() {
        return time_mounth;
    }

    public void setTime_mounth(int time_month) {
        this.time_mounth = time_month;
    }

    public int getTime_day() {
        return time_day;
    }

    public void setTime_day(int time_day) {
        this.time_day = time_day;
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
