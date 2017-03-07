import java.util.HashMap;

/**
 * Created by sukru on 4.03.2017.
 */
public class Enums {
    public static String service_req_trigger_name(int value){
        HashMap service_req_trigger_name=new HashMap();
        service_req_trigger_name.put(0,"MS");
        service_req_trigger_name.put(1,"SGSN");
        service_req_trigger_name.put(2,"GGSN");
        service_req_trigger_name.put(3,"HLR");
        return (String)service_req_trigger_name.get(value);
    }
    public static String service_type_name(int value){
        HashMap service_type_name=new HashMap();
        service_type_name.put(0,"SIGNALLING");
        service_type_name.put(1,"DATA");
        service_type_name.put(2,"PAGING_RESPONSE");
        service_type_name.put(3,"MBMS_MULTICAST_SER_RECP");
        service_type_name.put(3,"MBMS_BROADCAST_SER_RECP");
        return (String)service_type_name.get(value);
    }
 }