package link_data;

public class Co_kr_Table {
    private String[] co= {"http://www.sk.co.kr","http://www.posco.co.kr", "http://www.hyosung.co.kr",
            "https://www.hyosung.co.kr", "http://www.ypbooks.co.kr", "http://www.kyobobook.co.kr",
            "https://www.aladin.co.kr", "https://www.kdb.co.kr", "https://www.ibk.co.kr",
            "https://www.citibank.co.kr", "https://www.dgb.co.kr", "http://hanex.hanjin.co.kr", "http://www.dhl.co.kr",
            "https://www.cvsnet.co.kr", "http://www.ds3211.co.kr", "https://mms.doortodoor.co.kr","http://www.uplus.co.kr",
            "https://www.uplus.co.kr","https://www.estsoft.co.kr","http://www.estsoft.co.kr"
    };

    public String[] co_Kr_Table_Getter(){
        String[] new_co=new String[co.length];
        System.arraycopy(co,0,new_co,0,co.length);//외부에서 직접 접근 방지 객체 복사진행 캡슐화 유지
        return new_co;
    }
}
