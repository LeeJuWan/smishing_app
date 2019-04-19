package andbook.example.smishing_release;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import URL_DATA.*;

public class Domain_Check {
    private static String regex= "(http://|https://|www)(([a-z\\d]([a-z\\d-]*[a-z\\d])|([ㄱ-힣])*)\\.)+(([a-z]{2,}))"; //프로토콜,호스트만 추출

    CO_KR_TABLE co_kr_table=new CO_KR_TABLE();
    COM_TABLE com_table=new COM_TABLE();
    GO_KR_TABLE go_kr_table=new GO_KR_TABLE();
    private int CO=0;
    private int GO=0;
    private int COM=0;

    public int CO_KR_Check(String STR_URL){
        Pattern p =Pattern.compile(regex);
        Matcher m =p.matcher(STR_URL);
        if(m.find());

        for(int i=0; i<co_kr_table.Co_Kr_Table_Getter().length;i++){
            if(co_kr_table.Co_Kr_Table_Getter()[i].equals(m.group())){
                //co.kr 테이블에 일치하는 URL 존재할 시
                CO=1;//도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
        }
        return CO;
    }
    public int GO_KR_Check(String STR_URL){
        Pattern p =Pattern.compile(regex);
        Matcher m =p.matcher(STR_URL);
        if(m.find());

        for(int i=0; i<go_kr_table.GO_Table_Getter().length;i++){
            if(go_kr_table.GO_Table_Getter()[i].equals(m.group())){
                //go.kr 테이블에 일치하는 URL 존재할 시
                GO=1; //도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
        }
        return GO;
    }
    public int COM_Check(String STR_URL){
        Pattern p =Pattern.compile(regex);
        Matcher m =p.matcher(STR_URL);
        if(m.find());

        for(int i=0;i<com_table.Com_Table_Getter().length;i++){
            if(com_table.Com_Table_Getter()[i].equals(m.group())){
                //com 테이블에 일치하는 URL 존재할 시
                COM=1;//도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
            COM=0;
        }
        return COM;
    }
}
