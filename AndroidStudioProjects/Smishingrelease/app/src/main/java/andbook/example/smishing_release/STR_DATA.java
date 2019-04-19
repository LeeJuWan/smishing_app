package andbook.example.smishing_release;

public class STR_DATA {
    private static String STR_BODY="";
    private static String STR_HEAD="";

    public void Set_STR_BODY(String STR_body){
        STR_BODY=STR_body;
    }
    public void Set_STR_HEAD(String STR_head){
        STR_HEAD=STR_head;
    }
    public String Get_STR_BODY(){
        return STR_BODY;
    }
    public String Get_STR_HEAD(){
        return STR_HEAD;
    }
}
