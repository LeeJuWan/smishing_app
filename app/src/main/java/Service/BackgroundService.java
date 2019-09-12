package Service;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import java.util.concurrent.ExecutionException;

import Network.ExpanderNetwork;
import UrlSource.IPCheck;
import UrlSource.URL_Extract;
import UrlSource.DomainCheck;
import andbook.example.smishing.MessageActivity;
import andbook.example.smishing.R;
import UrlSource.Str_Data;


public class BackgroundService extends Service {
    private static NotificationManager notificationManager;
    private static NotificationCompat.Builder builder;
    private static NotificationCompat.BigTextStyle bigTextStyle;

    private Intent intent;

    private String sTR_Expander_URL = "";
    private String sTR_HEAD = "";
    private String sTR_BODY = "";
    private String sTR_URL="";
    private final String phone = "(\\d{3})(\\d{3,4})(\\d{4})";

    private DomainCheck domainCheck = new DomainCheck();
    private IPCheck ipCheck = new IPCheck();
    private URL_Extract Extract = new URL_Extract();
    private ExpanderNetwork expanderURL;

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        sTR_BODY = Str_Data.getStrBody();
        sTR_HEAD = Str_Data.getStrHead(); //SMS 리시버를 통해 얻은 문자내용+수신자를 옮김
        sTR_URL = Extract.url_ExtractSub(sTR_BODY);


        if (sTR_URL.contains(".co.kr")) {
            if (domainCheck.co_kr_Check(sTR_URL) == 1) { //1일시 도메인 적합
                send_NotifiCation_Safe();
                stopSelf(); //작업 후 서비스 종료
            } else {
                send_NotifiCation_NotSafe();
                stopSelf();
            }
        } else if (sTR_URL.contains(".com")) {
            if (domainCheck.com_Check(sTR_URL) == 1) {
                send_NotifiCation_Safe();
                stopSelf();
            } else {
                send_NotifiCation_NotSafe();
                stopSelf();
            }
        } else if (sTR_URL.contains(".go.kr")) {
            if (domainCheck.go_kr_Check(sTR_URL) == 1) {
                send_NotifiCation_Safe();
                stopSelf();
            } else {
                send_NotifiCation_NotSafe();
                stopSelf();
            }
        } else if (sTR_URL.contains("http://naver.me")) {
            //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
            //단축이여도 안전한 URL로 판단
            send_NotifiCation_Safe();
            stopSelf();
        } else if (sTR_URL.contains(".net")) {
            if (domainCheck.net_Check(sTR_URL) == 1) {
                send_NotifiCation_Safe();
                stopSelf();
            } else {
                send_NotifiCation_NotSafe();
                stopSelf();
            }
        } else if (sTR_URL.contains(".ac.kr")) {
            if (domainCheck.ac_kr_Check(sTR_URL) == 1) {
                send_NotifiCation_Safe();
                stopSelf();
            } else {
                send_NotifiCation_NotSafe();
                stopSelf();
            }
        } else {
            //위의 if~else if 조건은 단축이 아닌 원본 URL로 SMS문자로 왔을 경우를 탐지
            //현 else 문 부터는 단축URL일 경우에 오는 조건이기에 URL 확장 진행을 진행한다.
            //또한 안전한 도메인을 단축URL로 보낼 수 있는 경우도 있기에 위의 if~else if 와 같이 도메인 적합성을 다시 검사한다.
            //프로토콜~ 쿼리스트링까지 추출한 URL을 리다이렉팅 시켜 원래의 원본 URL을 추출
            try {
                expanderURL = new ExpanderNetwork();
                sTR_Expander_URL = expanderURL.execute(sTR_URL).get();
            } catch (InterruptedException e) {
                System.err.println("BackGround InterruptedException");
            } catch (ExecutionException e) {
                System.err.println("BackGround ExecutionExceptio");
            }
            if (sTR_Expander_URL.contains("notFound")) {
                //not found 페이지 삭제됬거나 찾지못함
                send_Notification_NotFound();
                stopSelf();
            } else if (sTR_Expander_URL.contains(".apk") || sTR_Expander_URL.contains(".APK")) {
                //앱을 설치하라는 문자 또한 구글 플레이 스토어로 연결되는 URL이 포함되어 있기에
                //모든 상황에서의 SMS 문자로는 apk포함 URL이 올 이유가 없기에 apk 포함 URL일 시 지체없이 악성파일로 판단
                send_Notification_Malware();
                stopSelf();
            } else if (ipCheck.Check_identity_protocol(sTR_Expander_URL)) {
                //IP가 첨부된 URL을 탐지
                send_Notification_IP();
                stopSelf();
            }
            //다시한번 확장된 URL의 도메인 적합성 진행
            else if (sTR_Expander_URL.contains(".co.kr")) {
                if (domainCheck.co_kr_Check(sTR_Expander_URL) == 1) { //1일시 도메인 적합
                    send_NotifiCation_Safe();
                    stopSelf();
                } else {
                    send_NotifiCation_NotSafe();
                    stopSelf();
                }
            } else if (sTR_Expander_URL.contains(".com")) {
                if (domainCheck.com_Check(sTR_Expander_URL) == 1) {
                    send_NotifiCation_Safe();
                    stopSelf();
                } else {
                    send_NotifiCation_NotSafe();
                    stopSelf();
                }
            } else if (sTR_Expander_URL.contains(".go.kr")) {
                if (domainCheck.go_kr_Check(sTR_Expander_URL) == 1) {
                    send_NotifiCation_Safe();
                    stopSelf();
                } else {
                    send_NotifiCation_NotSafe();
                    stopSelf();
                }
            } else if (sTR_Expander_URL.contains("http://naver.me")) {
                //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
                //단축이여도 안전한 URL로 판단
                send_NotifiCation_Safe();
                stopSelf();
            } else if (sTR_Expander_URL.contains(".net")) {
                if (domainCheck.net_Check(sTR_Expander_URL) == 1) {
                    send_NotifiCation_Safe();
                    stopSelf();
                } else {
                    send_NotifiCation_NotSafe();
                    stopSelf();
                }
            } else if (sTR_Expander_URL.contains(".ac.kr")) {
                if (domainCheck.ac_kr_Check(sTR_Expander_URL) == 1) {
                    send_NotifiCation_Safe();
                    stopSelf();
                } else {
                    send_NotifiCation_NotSafe();
                    stopSelf();
                }
            } else {
                send_NotifiCation_NotSafe();
                stopSelf();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    //안전문자 푸시
    private void send_NotifiCation_Safe() {
        intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra("body",sTR_BODY);
        intent.putExtra("head",sTR_HEAD);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        bigTextStyle = new NotificationCompat.BigTextStyle(builder);

        builder.setSmallIcon(R.drawable.small); //아이콘 추가
        builder.setTicker("안전한 SMS 문자입니다.");
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
        builder.setContentTitle(sTR_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("안전한 SMS 문자입니다.");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        bigTextStyle.setBigContentTitle(sTR_HEAD);
        bigTextStyle.bigText(sTR_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    //의심문자 푸시
    private void send_NotifiCation_NotSafe() {
        intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra("body",sTR_BODY);
        intent.putExtra("head",sTR_HEAD);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        bigTextStyle = new NotificationCompat.BigTextStyle(builder);

        builder.setSmallIcon(R.drawable.small); //아이콘 추가
        builder.setTicker("스미싱으로 의심되는 문자입니다.조심하세요.");
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
        builder.setContentTitle(sTR_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("스미싱으로 의심되는 문자입니다.조심하세요.");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        bigTextStyle.setBigContentTitle(sTR_HEAD);
        bigTextStyle.bigText(sTR_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    //악성코드 푸시
    private void send_Notification_Malware() {
        intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra("body",sTR_BODY);
        intent.putExtra("head",sTR_HEAD);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        bigTextStyle = new NotificationCompat.BigTextStyle(builder);

        builder.setSmallIcon(R.drawable.small); //아이콘 추가
        builder.setTicker("악성코드가 포함된 문자입니다.");
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
        builder.setContentTitle(sTR_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("악성코드가 포함된 문자입니다.");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        bigTextStyle.setBigContentTitle(sTR_HEAD);
        bigTextStyle.bigText(sTR_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    //공격자 서버 주소 푸시
    private void send_Notification_IP() {
        intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra("body",sTR_BODY);
        intent.putExtra("head",sTR_HEAD);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        bigTextStyle = new NotificationCompat.BigTextStyle(builder);

        builder.setSmallIcon(R.drawable.small); //아이콘 추가
        builder.setTicker("서버 주소가 포함된 문자입니다.조심하세요.");
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
        builder.setContentTitle(sTR_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("서버 주소가 포함된 문자입니다.조심하세요.");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        bigTextStyle.setBigContentTitle(sTR_HEAD);
        bigTextStyle.bigText(sTR_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    private void send_Notification_NotFound() {
        intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra("body",sTR_BODY);
        intent.putExtra("head",sTR_HEAD);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new NotificationCompat.Builder(getApplicationContext());
        bigTextStyle = new NotificationCompat.BigTextStyle(builder);

        builder.setSmallIcon(R.drawable.small); //아이콘 추가
        builder.setTicker("없는 사이트 이거나 알수없음.");
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.big)); //알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
        builder.setContentTitle(sTR_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("없는 사이트 이거나 알수없음.");
        builder.setAutoCancel(true);
        builder.setContentIntent(pendingIntent);
        bigTextStyle.setBigContentTitle(sTR_HEAD);
        bigTextStyle.bigText(sTR_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }
}
