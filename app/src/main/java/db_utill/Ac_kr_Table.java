package db_utill;

public class Ac_kr_Table {
    private final String[] ac= {"http://www.kongju.ac.kr","http://www.snu.ac.kr","https://www.snu.ac.kr","https://www.business.kaist.ac.kr",
            "http://www.business.kaist.ac.kr","http://kcu.ac.kr","http://songsin.catholic.ac.kr","https://songsin.catholic.ac.kr",
            "https://songeui.catholic.ac.kr","http://songeui.catholic.ac.kr","http://www.mtu.ac.kr","https://www.mtu.ac.kr",
            "http://www.konkuk.ac.kr","https://www.konkuk.ac.kr","https://www.gwnu.ac.kr","http://www.gwnu.ac.kr",
            "http://www.kangwon.ac.kr","https://www.kangwon.ac.kr","http://graduate.kangwon.ac.kr","http://gsba.kangwon.ac.kr",
            "http://www.knu.ac.kr","https://www.knu.ac.kr","http://www.gnu.ac.kr","https://www.gnu.ac.kr","https://www.kongju.ac.kr"
    };


    // 외부에서 직접 접근 방지 객체 복사진행 캡슐화 유지
    public String[] ac_Kr_Table_Getter(){
        String[] new_ac=new String[ac.length];
        System.arraycopy(ac,0,new_ac,0,ac.length);
        return new_ac;
    }
}