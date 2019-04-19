package andbook.example.smishing_release;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;


public class Background extends Service {


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        String STR_URL="";
        String STR_HEAD="";
        String STR_BODY="";
        String STR_Expander_URL="";
        String Phone = "(\\d{3})(\\d{3,4})(\\d{4})";

        STR_DATA strData=new STR_DATA();
        Domain_Check domainCheck=new Domain_Check();
        IPCheck ipCheck=new IPCheck();
        URL_Extract urlExtract=new URL_Extract();
        Expander_URL expanderUrl=new Expander_URL();

        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle(builder);

        STR_BODY=strData.Get_STR_BODY();
        STR_HEAD=strData.Get_STR_HEAD(); //SMS 리시버를 통해 얻은 문자내용+수신자를 옮김

        STR_URL=urlExtract.URL_Extract_sub(STR_BODY); //STR_BODY의 문자내용중 URL만 추출

        if(STR_URL.contains("co.kr")){
            if(domainCheck.CO_KR_Check(STR_URL) == 1){ //1일시 도메인 적합
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("안전한 SMS 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
            else{
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("스미싱으로 의심되는 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
        }
        else if(STR_URL.contains(".com")){
            if(domainCheck.COM_Check(STR_URL) == 1){
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("안전한 SMS 문자입니다.1");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
            else{
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("스미싱으로 의심되는 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
        }
        else if(STR_URL.contains(".go.kr")){
            if(domainCheck.GO_KR_Check(STR_URL) == 1){
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("안전한 SMS 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
            else{
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("스미싱으로 의심되는 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
        }
        else if(STR_URL.contains("http://naver.me")){
            //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
            //단축이여도 안전한 URL로 판단
            builder.setSmallIcon(R.drawable.small); //아이콘 추가
            builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
            builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
            builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
            builder.setContentText("안전한 SMS 문자입니다.");
            builder.setAutoCancel(true);
            bigPictureStyle.setBigContentTitle(STR_HEAD);
            bigPictureStyle.setSummaryText(STR_BODY);
            manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
        }
        else if(STR_URL.contains(".net")){
            //추후 업데이트
        }
        else{
            //위의 if~else if 조건은 단축이 아닌 원본 URL로 SMS문자로 왔을 경우를 탐지
            //현 else 문 부터는 단축URL일 경우에 오는 조건이기에 URL 확장 진행을 진행한다.
            //또한 안전한 도메인을 단축URL로 보낼 수 있는 경우도 있기에 위의 if~else if 와 같이 도메인 적합성을 다시 검사한다.
            //프로토콜~ 쿼리스트링까지 추출한 URL을 리다이렉팅 시켜 원래의 원본 URL을 추출
            expanderUrl.Set_URL(STR_URL);
            expanderUrl.start();
            STR_Expander_URL=expanderUrl.Get_URL();

            if(STR_Expander_URL.contains(".apk") || STR_Expander_URL.contains(".APK")){
                //앱을 설치하라는 문자 또한 구글 플레이 스토어로 연결되는 URL이 포함되어 있기에
                //모든 상황에서의 SMS 문자로는 apk포함 URL이 올 이유가 없기에 apk 포함 URL일 시 지체없이 악성파일로 판단
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("악성파일이 포함된 스미싱 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
            //다시한번 확장된 URL의 도메인 적합성 진행
            else if(STR_URL.contains("co.kr")){
                if(domainCheck.CO_KR_Check(STR_URL) == 1){ //1일시 도메인 적합
                    builder.setSmallIcon(R.drawable.small); //아이콘 추가
                    builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                    builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                    builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                    builder.setContentText("안전한 SMS 문자입니다.");
                    builder.setAutoCancel(true);
                    bigPictureStyle.setBigContentTitle(STR_HEAD);
                    bigPictureStyle.setSummaryText(STR_BODY);
                    manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
                }
            }
            else if(STR_URL.contains(".com")){
                if(domainCheck.COM_Check(STR_URL) == 1){
                    builder.setSmallIcon(R.drawable.small); //아이콘 추가
                    builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                    builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                    builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                    builder.setContentText("안전한 SMS 문자입니다.1");
                    builder.setAutoCancel(true);
                    bigPictureStyle.setBigContentTitle(STR_HEAD);
                    bigPictureStyle.setSummaryText(STR_BODY);
                    manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
                }
            }
            else if(STR_URL.contains(".go.kr")){
                if(domainCheck.GO_KR_Check(STR_URL) == 1){
                    builder.setSmallIcon(R.drawable.small); //아이콘 추가
                    builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                    builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                    builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                    builder.setContentText("안전한 SMS 문자입니다.");
                    builder.setAutoCancel(true);
                    bigPictureStyle.setBigContentTitle(STR_HEAD);
                    bigPictureStyle.setSummaryText(STR_BODY);
                    manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
                }
            }
            else if(STR_URL.contains("http://naver.me")){
                //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
                //단축이여도 안전한 URL로 판단
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("안전한 SMS 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
            else if(STR_URL.contains(".net")){
                //추후 업데이트
            }
            else{
                //개인 홍보성 문자 및 스팸메일 확률이 높은 마지막 조건
                builder.setSmallIcon(R.drawable.small); //아이콘 추가
                builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
                builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
                builder.setContentTitle(STR_HEAD.replaceAll(Phone,"$1-$2-$3"));
                builder.setContentText("스팸 또는 광고 목적의 문자입니다.");
                builder.setAutoCancel(true);
                bigPictureStyle.setBigContentTitle(STR_HEAD);
                bigPictureStyle.setSummaryText(STR_BODY);
                manager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
            }
        }
        return  super.onStartCommand(intent,flags,startId);
    }
}
