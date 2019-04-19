package andbook.example.smishing_release;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SmsReceiver extends BroadcastReceiver {
    public static String Action= "android.provider.Telephony.SMS_RECEIVED";

    public STR_DATA strData=new STR_DATA();
    public String STR_BODY=""; //문자 내용 추출
    public String STR_HEAD=""; //문자 수신번호 내용 추출

    @Override //수신시 호출 되는 콜백 메서드
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction() == Action){ //문자 이벤트 일시 if 실행
            //SMS 메시지 파싱 진행
            Bundle bundle=intent.getExtras();

            if(bundle != null){
                Object[] pdus=(Object[]) bundle.get("pdus");
                SmsMessage[] msg=new SmsMessage[pdus.length];
                for(int i=0;i<pdus.length;i++) { //pdu 포맷으로 되어 있는 메시지 복원

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                        //마시메로우 버전 이상일시
                        String format=bundle.getString("format");
                        msg[i]=SmsMessage.createFromPdu((byte[])pdus[i],format);
                    }else{
                        msg[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                    }
                }
                strData.Set_STR_BODY(msg[0].getMessageBody().toString());
                strData.Set_STR_HEAD(msg[0].getOriginatingAddress());
                //문자 내용에 URL이 있는지 확인 후 백그라운드로 작업진행 없다면 else
                if(STR_BODY.contains("http://") || STR_BODY.contains("https://") || STR_BODY.contains("www.")
                        ||STR_BODY.contains(".com") || STR_BODY.contains(".kr")) {
                    Intent mintent = new Intent(context, Background.class);
                    context.startService(mintent); //백그라운드 실행
                }
                else{
                    //문자내용중 URL이 없기에 아무런 작업도 안함 (ignore)
                }
            }
        }
        else{
            // empty
        }

    }
}
