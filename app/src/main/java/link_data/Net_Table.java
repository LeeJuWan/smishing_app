package link_data;

public class Net_Table {

    private String[] net= {"http://www.daum.net","https://www.daum.net"
    };

    public String[] net_Table_Getter(){
        String[] new_net=new String[net.length];
        System.arraycopy(net,0,new_net,0,net.length);//외부에서 직접 접근 방지 객체 복사진행 캡슐화 유지
        return new_net;
    }
}
