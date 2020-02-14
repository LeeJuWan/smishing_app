package URLPasing_Utill;

public class IPCheck {

    private final String ip = "(https?:\\/\\/)(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\."
            + "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])";

    public boolean Check_identity_protocol(String expander_URL){
        //IP 검사 진행
        return expander_URL.matches(ip);
    }
}
