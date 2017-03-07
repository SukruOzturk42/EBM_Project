
import Records.Event_Records.*;
import Structuretypes.*;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;

public class App {

    public static  void decode_gsn(int...values){
        System.out.println( "foo: "+ Arrays.toString( values ));}
    public static void main(String[]args) throws IOException {
long t0=System.currentTimeMillis();
        System.out.println(t0);
BitInputStream bs=new BitInputStream("C:/Users/sukru/Desktop/EBM_project/EBM/input/585.ebm");
        Path path = Paths.get("C:/Users/sukru/Desktop/EBM_project/EBM/input/585.ebm");
        byte[] data = Files.readAllBytes(path);

        Header_Record header_record=new Header_Record();

  header_record.setRecord_length(bs.readBits(16));
  header_record.setRecord_type(bs.readBits(8));
  header_record.setFile_format_version(bs.readBits(8));
  header_record.setFile_information_version(bs.readBits(8));
  header_record.setTime_year(bs.readBits(16));
  header_record.setTime_mounth(bs.readBits(8));
  header_record.setTime_day(bs.readBits(8));
  header_record.setTime_hour(bs.readBits(8));
  header_record.setTime_minute(bs.readBits(8));
  header_record.setTime_second(bs.readBits(8));
    System.out.println("Record Type=Header Record "+header_record.getRecord_type()+"\n"+"Time Format Vesion="+header_record.getFile_format_version()+"\n"+"Tİme_Information Version="+header_record.getFile_format_version()+"\n"
                       +"Date=>"+header_record.getTime_year()+"-"+header_record.getTime_mounth()+"-"+header_record.getTime_day()+"\n"
                       +"Time=>"+header_record.getTime_hour()+":"+header_record.getTime_minute()+":"+header_record.getTime_second()+"\n"

    );

Header header;
Location location;
int count=0;
    while(bs.availableBits()!=0){

        int available=0;
        int skip_bits=0;
       available =bs.availableBits();
        int record_length=bs.readBits(16);
        int record_type=bs.readBits(8);
        if(record_type==1){
            long t1= System.currentTimeMillis();
            System.out.println(t1+"=>"+count);
            count++;
                int event_id=bs.readBits(8);
                switch (event_id){
                    case 0:
                        Attach_Event attach_event=new Attach_Event();
                        attach_event.setRecord_length(record_length);
                        attach_event.setRecord_type(record_type);
                        header=new Header();
                        header.setEvent_id(event_id);
                        header.setEvent_result(bs.readBits(2));
                        header.setTime_hour(bs.readBits(5));
                        header.setTime_minute(bs.readBits(6));
                        header.setTime_second(bs.readBits(6));
                        attach_event.setHEADER(header);
                        attach_event.setAttach_type(bs.readBits(2));
                        attach_event.setRat(bs.readBits(2));
                        attach_event.setCAUSE_CODE(bs.readBits(10));
                        attach_event.setSUB_COUSE_CODE(bs.readBits(10));
                        attach_event.setLocation(bs.readBits(12),bs.readBits(12),bs.readBits(16),
                                bs.readBits(8),bs.readBits(1),bs.readBits(16),bs.readBits(1),bs.readBits(16));
                        attach_event.setImsi(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        attach_event.setPtmsi_val(bs.readBit());
                        attach_event.setPtmsi(bs.readBits(24),bs.readBits(8));
                        attach_event.setImeisv_val(bs.readBit());
                        attach_event.setImeisv(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        attach_event.setHlr(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        attach_event.setMsisd(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        attach_event.setCause_prot_type(bs.readBits(2));
                        bs.skipBits(8*record_length-(available-bs.availableBits()));
                        long t2=System.currentTimeMillis();

                        break;
                    case 1:
                     Activate_Event   event_records=new Activate_Event();
                        event_records.setRecord_length(record_length);
                        event_records.setRecord_type(record_type);
                        header=new Header();
                        header.setEvent_id(event_id);
                        header.setEvent_result(bs.readBits(2));
                        header.setTime_hour(bs.readBits(5));
                        header.setTime_minute(bs.readBits(6));
                        header.setTime_second(bs.readBits(6));
                        event_records.setHEADER(header);
                        event_records.setACTIVATION_TYPE(bs.readBits(2));
                        event_records.setRAT(bs.readBits(2));
                        event_records.setCAUSE_PROT_TYPE(bs.readBits(2));
                        event_records.setCAUSE_CODE(bs.readBits(10));
                        event_records.setSUB_COUSE_CODE(bs.readBits(10));
                        location=new Location();
                        location.setMCC(bs.readBits(12));
                        location.setMNC(bs.readBits(12));
                        location.setLAC(bs.readBits(16));
                        location.setRAC(bs.readBits(8));
                        location.setVal_CI(bs.readBits(1));
                        location.setCI(bs.readBits(16));
                        location.setVal_SAC(bs.readBits(1));
                        location.setSAC(bs.readBits(16));
                        event_records.setLOCATION(location);
                        event_records.setIMSI(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        event_records.setImeisv_val(bs.readBit());
                        event_records.setIMEISV(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        event_records.setVal_GSN(bs.readBit());
                        event_records.setGSN(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                        int apn_length=bs.readBits(7);
                       // Burdaki bitler apn için decode nasıl yapılıyor ona bakılacak
                        bs.skipBits(apn_length*8);
                        event_records.setMSISD(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        event_records.setNSAPI(bs.readBits(4));
                        int linked_nsapi_val=bs.readBit();
                        if(linked_nsapi_val==1){
                            event_records.setL_NSAPI(bs.readBits(4));
                        }
                        Ipaddress ıpaddress=new Ipaddress();
                        int option_ipV4=bs.readBit();
                        if(option_ipV4!=0){
                            ıpaddress.setIPV4(0);
                        }
                        else{
                           ıpaddress.setIPV4(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                        }
                        int option_ipV6=bs.readBit();
                        if(option_ipV6!=0){
                            ıpaddress.setIPV6(0);
                        }
                        else {
                            ıpaddress.setIPV4(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));

                        }
                        System.out.println(8*record_length-(available-bs.availableBits()));
                        bs.skipBits(8*record_length-(available-bs.availableBits()));

                        break;
                    case 2:
                       Rau_Event rau_event=new Rau_Event();
                        rau_event.setRecord_length(record_length);
                        rau_event.setRecord_type(record_type);
                         header=new Header();
                        header.setEvent_id(event_id);
                        header.setEvent_result(bs.readBits(2));
                        header.setTime_hour(bs.readBits(5));
                        header.setTime_minute(bs.readBits(6));
                        header.setTime_second(bs.readBits(6));
                        rau_event.setHEADER(header);
                        rau_event.setRAT(bs.readBits(2));
                        rau_event.setINTRA_RAU_TYPE(bs.readBits(1));
                        rau_event.setUPDATE_TYPE(bs.readBits(2));
                        rau_event.setCAUSE_CODE(bs.readBits(10));
                        rau_event.setSUB_COUSE_CODE(bs.readBits(10));
                        rau_event.setLocation(bs.readBits(12),bs.readBits(12),bs.readBits(16),
                                bs.readBits(8),bs.readBits(1),bs.readBits(16),bs.readBits(1),bs.readBits(16));

                        rau_event.setIMSI(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        rau_event.setPtmsi_val(bs.readBit());
                        rau_event.setPTMSI(bs.readBits(24),bs.readBits(8));
                        rau_event.setImeisv_val(bs.readBit());
                        rau_event.setIMEISV(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        rau_event.setOLD_LOCATİON(bs.readBits(12),bs.readBits(12),bs.readBits(16),bs.readBits(8));
                        rau_event.setTRANSFERRED_PDP(bs.readBits(4));
                        rau_event.setDROPPED_PDP(bs.readBits(4));
                        rau_event.setHOMEZONE_IDENTITY(bs.readBits(8));

                        int h_skip=bs.availableBits()%8;
                        rau_event.setMSISD(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        int check_pdp=bs.readBits(8);
                        Pdp_info pdp_info=new Pdp_info();
                        if(check_pdp>0){
                            pdp_info.setNSAPI(bs.readBits(4));
                            pdp_info.setGSN(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                            Ipaddress ıpaddress_rau=new Ipaddress();
                            int rau_option_ipV4=bs.readBit();
                            if(rau_option_ipV4==1){
                                ıpaddress_rau.setIPV4(0);
                            }
                            else{
                                ıpaddress_rau.setIPV4(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                            }
                            int option_ipV6_rau=bs.readBit();
                            if(option_ipV6_rau==0){
                                ıpaddress_rau.setIPV6(0);
                            }
                            else {
                                ıpaddress_rau.setIPV6(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));

                            }
                            pdp_info.setIpaddress(ıpaddress_rau);

                        }
                        rau_event.setPDP_INFO(pdp_info);
                        rau_event.setCAUSE_PROT_TYPE(bs.readBits(2));
                        rau_event.setHLR(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        bs.skipBits(8*record_length-(available-bs.availableBits()));
                        System.out.println(available-bs.availableBits());
                        System.out.println(8*record_length-(available-bs.availableBits()));
                        System.out.println(rau_event.toString());
                        break;
                    case 4:
                        Deactivate_Event deactivate_event=new Deactivate_Event();
                        deactivate_event.setRecord_length(record_length);
                        deactivate_event.setRecord_type(record_type);
                        header=new Header();
                        header.setEvent_id(event_id);
                        header.setEvent_result(bs.readBits(2));
                        header.setTime_hour(bs.readBits(5));
                        header.setTime_minute(bs.readBits(6));
                        header.setTime_second(bs.readBits(6));
                        deactivate_event.setHEADER(header);
                        deactivate_event.setRat(bs.readBits(2));
                        deactivate_event.setDeactivation_trigger(bs.readBits(3));
                        deactivate_event.setCAUSE_CODE(bs.readBits(10));
                        deactivate_event.setSUB_COUSE_CODE(bs.readBits(10));
                        deactivate_event.setLocation(bs.readBits(12),bs.readBits(12),bs.readBits(16),
                                bs.readBits(8),bs.readBits(1),bs.readBits(16),bs.readBits(1),bs.readBits(16));
                        deactivate_event.setImsi(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        deactivate_event.setImeisv_val(bs.readBit());
                        deactivate_event.setImeisv(bs.readBits(24),bs.readBits(24),bs.readBits(16));
                        deactivate_event.setVal_GSN(bs.readBit());
                        deactivate_event.setGSN(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                        int apn_length_deactive=bs.readBits(7);
                        // Burdaki bitler apn için decode nasıl yapılıyor ona bakılacak
                        bs.skipBits(apn_length_deactive*8);
                        //Homezone identity bu kısım sıkıntılı
                        deactivate_event.setHomezone_identity(bs.readBits(8));
                        deactivate_event.setMsisd(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        deactivate_event.setNsapi(bs.readBits(4));
                        Ipaddress ıpaddress_deactive=new Ipaddress();
                        int option_ipV4_deactive=bs.readBit();
                        if(option_ipV4_deactive==1){
                            ıpaddress_deactive.setIPV4(0);
                        }
                        else{
                            ıpaddress_deactive.setIPV4(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                        }
                        int option_ipV6_deactive=bs.readBit();
                        if(option_ipV6_deactive==0){
                            ıpaddress_deactive.setIPV6(0);
                        }
                        else {
                            ıpaddress_deactive.setIPV6(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));

                        }
                        deactivate_event.setIpaddress(ıpaddress_deactive);
                        deactivate_event.setCause_prot_type(bs.readBits(2));

                        bs.skipBits(8*record_length-(available-bs.availableBits()));
                        break;

                    case 14:
                        int step=bs.availableBits();
                        Detach_Event detach_event=new Detach_Event();
                        detach_event.setRecord_length(record_length);
                        detach_event.setRecord_type(record_type);
                        detach_event.setL_header(bs.readBits(2),bs.readBits(5),bs.readBits(6),bs.readBits(6),bs.readBits(10),bs.readBits(16));
                        detach_event.setRAT(bs.readBits(2));
                        detach_event.setDetach_trigger(bs.readBits(2));
                        detach_event.setDetach_type(bs.readBits(4));
                        detach_event.setCAUSE_PROT_TYPE(bs.readBits(2));
                        detach_event.setCAUSE_CODE(bs.readBits(10));
                        detach_event.setSUB_COUSE_CODE(bs.readBits(10));

                        detach_event.setLocation(bs.readBits(12),bs.readBits(12),bs.readBits(16),
                                                bs.readBits(8),bs.readBits(1),bs.readBits(16),bs.readBits(1),bs.readBits(16));

                        detach_event.setMsıd(bs.readBits(24),bs.readBits(24),bs.readBits(16),
                                bs.readBit(),
                                bs.readBits(24),bs.readBits(8),
                                bs.readBit(),
                                bs.readBits(24),bs.readBits(24),bs.readBits(16),
                                bs.readBits(24),bs.readBits(24),bs.readBits(24));

                        detach_event.setHLR(bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        bs.skipBits(8*record_length-(available-bs.availableBits()));
                        break;

                    case 15:
                       Service_Request_Event service_request_event=new Service_Request_Event();
                        service_request_event.setRecord_length(record_length);
                        service_request_event.setRecord_type(record_type);
                        service_request_event.setL_header(bs.readBits(2),bs.readBits(5),bs.readBits(6),bs.readBits(6),bs.readBits(10),bs.readBits(16));
                        service_request_event.setRAT(bs.readBits(2));
                        service_request_event.setService_req_trigger(bs.readBits(2));
                        service_request_event.setServictype(bs.readBits(3));
                        service_request_event.setPaging_attempts(bs.readBits(3));
                        service_request_event.setRequest_retries(bs.readBits(6));
                        service_request_event.setCause_prot_type(bs.readBits(2));
                        service_request_event.setCause_code(bs.readBits(10));
                        service_request_event.setSub_cause_code(bs.readBits(10));
                        service_request_event.setLocation(bs.readBits(12),bs.readBits(12),bs.readBits(16),
                                bs.readBits(8),bs.readBits(1),bs.readBits(16),bs.readBits(1),bs.readBits(16));

                        service_request_event.setMsıd(bs.readBits(24),bs.readBits(24),bs.readBits(16),
                                bs.readBit(),
                                bs.readBits(24),bs.readBits(8),
                                bs.readBit(),
                                bs.readBits(24),bs.readBits(24),bs.readBits(16),
                                bs.readBits(24),bs.readBits(24),bs.readBits(24));
                        Pdp_info pdp_info_detach=new Pdp_info();
                        int check_pdp_detach=bs.readBits(8);
                        if(check_pdp_detach>0){
                            pdp_info_detach.setNSAPI(bs.readBits(4));
                            pdp_info_detach.setGSN(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                            Ipaddress ıpaddress_rau=new Ipaddress();
                            int rau_option_ipV4=bs.readBit();
                            if(rau_option_ipV4!=0){
                                ıpaddress_rau.setIPV4(0);
                            }
                            else{
                                ıpaddress_rau.setIPV4(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));
                            }
                            int option_ipV6_rau=bs.readBit();
                            if(option_ipV6_rau!=0){
                                ıpaddress_rau.setIPV6(0);
                            }
                            else {
                                ıpaddress_rau.setIPV4(bs.readBits(8),bs.readBits(8),bs.readBits(8),bs.readBits(8));

                            }
                            pdp_info_detach.setIpaddress(ıpaddress_rau);
                            service_request_event.setPdp_info(pdp_info_detach);
                        }
                        bs.skipBits(8*record_length-(available-bs.availableBits()));
                        break;

                }

            }

        }
    }
}

