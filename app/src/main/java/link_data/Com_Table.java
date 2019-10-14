package link_data;

public class Com_Table {
    private String[] com = {"http://www.benikea.com", "http://www.asiaculturecity.com", "https://www.gsshop.com",
            "http://www.samsung.com", "https://www.samsung.com", "https://www.hyundai.com", "http://www.hyundai.com",
            "http://www.doosan.com", "https://www.hyosungitx.com", "http://www.harim.com", "http://www.s-oil.com",
            "http://www.kumhoasiana.com", "https://kr.koreanair.com", "https://www.eastarjet.com", "https://banking.nonghyup.com",
            "http://banking.nonghyup.com", "http://www.nonghyup.com", "http://www.nonghyup.com", "https://www.wooribank.com",
            "http://www.wooribank.com", "https://www.suhyup-bank.com", "http://www.suhyup-bank.com", "https://www.kebhana.com",
            "http://www.kebhana.com", "https://www.kakaobank.com", "http://www.kakaobank.com", "https://www.kbanknow.com",
            "https://crowd.ibks.com", "https://www.myasset.com",
            "https://www.nhqv.com", "https://www.samsungpop.com", "https://www.miraeassetdaewoo.com", "https://www.iprovest.com",
            "https://www.kiwoom.com", "https://home.imeritz.com", "https://www.kbstar.com", "https://www.lotteglogis.com",
            "https://www.ilogen.com", "https://www.cjlogistics.com", "https://www.kgbps.com", "https://yellowcap24.com",
            "https://www.yellowcap24.com", "https://www.fedex.com", "http://www.emspremium.com", "https://kdexp.com",
            "http://앱다운.com", "https://play.google.com", "https://www.naver.com", "http://www.naver.com",
            "https://www.estsecurity.com", "http://www.estsecurity.com", "http://www.tistory.com", "https://www.tistory.com",
            "http://www.nate.com", "https://www.nate.com", "http://zum.com", "http://www.google.com", "https://www.google.com",
            "https://www.skinfosec.com", "http://www.skinfosec.com"
    };

    public String[] com_Table_Getter() {
        String[] new_com = new String[com.length];
        System.arraycopy(com, 0, new_com, 0, com.length);//외부에서 직접 접근 방지 객체 복사진행 캡슐화 유지
        return new_com;

    }
}
