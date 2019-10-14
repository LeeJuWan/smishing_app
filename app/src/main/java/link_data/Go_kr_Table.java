package link_data;

public class Go_kr_Table {
    private String[] go= {"http://www.president.go.kr","http://edu.humanrights.go.kr", "http://www.bai.go.kr", "http://www.humanrights.go.kr",
            "https://www.pacst.go.kr", "http://pss.go.kr", "http://webzine.nuac.go.kr", "http://www.nuac.go.kr",
            "http://www.humangongmo.kr", "http://library.humanrights.go.kr", "http://www.nis.go.kr",
            "http://www.bai-eri.go.kr", "http://english.bai.go.kr", "http://service5.nis.go.kr",
            "http://museum.nis.go.kr", "http://www.pasa.go.kr", "http://service1.nis.go.kr", "http://www.kcc.go.kr",
            "http://www.pmo.go.kr", "http://www.111.go.kr", "https://www.nis.go.kr", "http://www.tiic.go.kr",
            "http://www.evaluation.go.kr", "http://eng.pmo.go.kr", "http://www.econedu.go.kr", "http://www.odakorea.go.kr",
            "http://www.k-pis.go.kr", "http://www.moef.go.kr", "http://www.tt.go.kr",
            "http://ifi.mosf.go.kr", "http://www.alio.go.kr", "http://www.bokgwon.go.kr", "http://www.childschool.go.kr",
            "http://www.bokgwon.go.kr", "http://www.cnuhh.com", "http://www.bokgwon.go.kr", "http://www.moe.go.kr",
            "http://edss.moe.go.kr", "http://admin.epki.go.kr", "http://www.epki.go.kr", "http://kids.moe.go.kr",
            "http://www.history.go.kr", "http://sillok.history.go.kr", "http://www.epik.go.kr", "http://www.neti.go.kr",
            "http://www.niied.go.kr", "http://www.topik.go.kr", "https://www.koreaexim.go.kr", "https://www.epost.go.kr",
            "http://www.kosaf.go.kr","https://www.spo.go.kr","http://www.spo.go.kr","http://www.academyinfo.go.kr"
    };

    public String[] go_Table_Getter()
    {
        String[] new_go=new String[go.length];
        System.arraycopy(go,0,new_go,0,go.length);//외부에서 직접 접근 방지 객체 복사진행 캡슐화 유지
        return new_go;
    }
}
