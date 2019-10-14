package util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import link_data.*;

public class DomainCheck {
    private final String regex = "(http://|https://|www)(([a-z\\d]([a-z\\d-]*[a-z\\d])|([ㄱ-힣])*)\\.)+(([a-z]{2,}))"; //프로토콜,호스트만 추출

    private Co_kr_Table co_kr_table = new Co_kr_Table();
    private Com_Table com_table = new Com_Table();
    private Go_kr_Table go_kr_table = new Go_kr_Table();
    private Net_Table net_table = new Net_Table();
    private Ac_kr_Table ac_kr_table = new Ac_kr_Table();

    private int CO = 0;
    private int GO = 0;
    private int COM = 0;
    private int NET = 0;
    private int AC = 0;

    public int co_kr_Check(String sTR_URL) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sTR_URL);
        if (m.find()) ;

        for (int i = 0; i < co_kr_table.co_Kr_Table_Getter().length; i++) {
            if (co_kr_table.co_Kr_Table_Getter()[i].equals(m.group())) {
                //co.kr 테이블에 일치하는 URL 존재할 시
                CO = 1;//도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
        }
        return CO;
    }

    public int go_kr_Check(String sTR_URL) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sTR_URL);
        if (m.find()) ;

        for (int i = 0; i < go_kr_table.go_Table_Getter().length; i++) {
            if (go_kr_table.go_Table_Getter()[i].equals(m.group())) {
                //go.kr 테이블에 일치하는 URL 존재할 시
                GO = 1; //도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
        }
        return GO;
    }

    public int com_Check(String sTR_URL) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sTR_URL);
        if (m.find()) ;

        for (int i = 0; i < com_table.com_Table_Getter().length; i++) {
            if (com_table.com_Table_Getter()[i].equals(m.group())) {
                //com 테이블에 일치하는 URL 존재할 시
                COM = 1;//도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
            COM = 0;
        }
        return COM;
    }

    public int net_Check(String sTR_URL) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sTR_URL);
        if (m.find()) ;

        for (int i = 0; i < net_table.net_Table_Getter().length; i++) {
            if (net_table.net_Table_Getter()[i].equals(m.group())) {
                //net 테이블에 일치하는 URL 존재할 시
                NET = 1;//도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
            NET = 0;
        }
        return NET;
    }

    public int ac_kr_Check(String sTR_URL) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sTR_URL);
        if (m.find()) ;

        for (int i = 0; i < ac_kr_table.ac_Kr_Table_Getter().length; i++) {
            if (ac_kr_table.ac_Kr_Table_Getter()[i].equals(m.group())) {
                //ac.kr 테이블에 일치하는 URL 존재할 시
                AC = 1;//도메인이 적합하므로 1을반환하여 적합성을 표시
                break;
            }
            AC = 0;
        }
        return AC;
    }
}
