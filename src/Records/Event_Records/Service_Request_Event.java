package Records.Event_Records;

import Structuretypes.*;

import java.util.HashMap;

/**
 * Created by sukru on 1.03.2017.
 */
public class Service_Request_Event extends Event_Records {
    private L_Header l_header;
    private int RAT;
    private int service_req_trigger;
    private int servictype;
    private int paging_attempts;
    private int request_retries;
    private int cause_prot_type;
    private int cause_code;
    private int sub_cause_code;
    private Location location;
    private Msıd msıd;
   private Pdp_info pdp_info;

    public L_Header getL_header() {
        return l_header;
    }

    public void setL_header(int...values) {
        L_Header l_header=new L_Header();
        Header header=new Header();
        header.setEvent_result(values[0]);
        header.setTime_hour(values[1]);
        header.setTime_minute(values[2]);
        header.setTime_second(values[3]);
        l_header.setHeader(header);
        l_header.setTime_milisecond(values[4]);
        l_header.setDuration(values[5]);

        this.l_header = l_header;
    }

    public int getRAT() {
        return RAT;
    }

    public void setRAT(int RAT) {
        this.RAT = RAT;
    }

    public int getService_req_trigger() {
        return service_req_trigger;
    }

    public void setService_req_trigger(int service_req_trigger) {
        this.service_req_trigger = service_req_trigger;
    }

    public int getServictype() {
        return servictype;
    }

    public void setServictype(int servictype) {
        this.servictype = servictype;
    }

    public int getPaging_attempts() {
        return paging_attempts;
    }

    public void setPaging_attempts(int paging_attempts) {
        this.paging_attempts = paging_attempts;
    }

    public int getRequest_retries() {
        return request_retries;
    }

    public void setRequest_retries(int request_retries) {
        this.request_retries = request_retries;
    }

    public int getCause_prot_type() {
        return cause_prot_type;
    }

    public void setCause_prot_type(int cause_prot_type) {
        this.cause_prot_type = cause_prot_type;
    }

    public int getCause_code() {
        return cause_code;
    }

    public void setCause_code(int cause_code) {
        this.cause_code = cause_code;
    }


    public int getSub_cause_code() {
        return sub_cause_code;
    }

    public void setSub_cause_code(int sub_cause_code) {
        this.sub_cause_code = sub_cause_code;
    }
    public Location getLocation() {
        return location;
    }

    public void setLocation(int...values) {
        Location location=new Location(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7]);
        this.location = location;
    }
    public Msıd getMsıd() {
        return msıd;
    }

    public void setMsıd(int...values) {
        Msıd msıd=new Msıd();
        msıd.setIMSI(values[0],values[1],values[2]);
        msıd.setPTMSI(values[3],values[4]);
        msıd.setIMEISV(values[5],values[6],values[7]);
        msıd.setMSISD(values[8],values[9],values[10]);
        this.msıd = msıd;
    }

    public Pdp_info getPdp_info() {
        return pdp_info;
    }

    public void setPdp_info(Pdp_info pdp_info) {
        this.pdp_info = pdp_info;
    }

}
