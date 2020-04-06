package db_utill;

public class Net_Table {

    private final String[] net= {"http://www.daum.net","https://www.daum.net"
    };

    // 외부에서 직접 접근 방지 객체 복사진행 캡슐화 유지
    public String[] net_Table_Getter(){
        String[] new_net=new String[net.length];
        System.arraycopy(net,0,new_net,0,net.length);
        return new_net;
    }
}
