package service_utill;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

import urlpasing_utill.STR_DATA;

public class SMSReceiverService extends BroadcastReceiver {


    @Override  // 수신 시 호출 되는 콜백 메서드
    public void onReceive(Context context, Intent intent) {

        // 문자 이벤트 일시 if 실행
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            // SMS 메시지 파싱 진행
            Bundle bundle = intent.getExtras();

            if(bundle != null){
                Object[] pdus = (Object[]) bundle.get("pdus");
                SmsMessage[] msg = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) { //pdu 포맷으로 되어 있는 메시지 복원
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        //마시메로우 버전 이상일 시
                        String format = bundle.getString("format");
                        msg[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                    } else {
                        msg[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    }
                }
                // 문자 URL 체크용
                String str_body = msg[0].getMessageBody();

                // 문자 내용에 URL이 있는지 확인 후 백그라운드로 작업진행 없다면 else
                if (str_body.contains("http://") || str_body.contains("https://") || str_body.contains("www.")
                        || str_body.contains(".com") || str_body.contains(".kr") || str_body.contains(".ly") ||
                        str_body.contains(".xyz")) {
                    // 백그라운드 분석을 위해 static 변수에 삽입
                    STR_DATA.strBody = msg[0].getMessageBody();
                    STR_DATA.strHead = msg[0].getOriginatingAddress();

                    Intent mintent = new Intent(context, BackgroundService.class);
                    context.startService(mintent); // 백그라운드 실행
                } else ;
                // nothing
            }
        }
    }
}