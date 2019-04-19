package andbook.example.smishing_release;

public class IPCheck {
    private static String IP="(https?:\\/\\/)(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\."
            + "(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])";

    public boolean Check_identity_protocol(String Expander_URL){
        if(Expander_URL.matches(IP)==true){ //IP 검사 진행
            return true;
        }
        else
            return false;
    }

}
