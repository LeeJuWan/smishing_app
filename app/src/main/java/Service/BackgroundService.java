package service;


import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import java.util.concurrent.ExecutionException;

import network.ExpanderNetwork;
import util.AlarmChannel;
import util.IPCheck;
import util.NotificationNotOreo;
import util.NotificationOreo;
import util.URL_Extract;
import util.DomainCheck;
import util.STR_DATA;


public class BackgroundService extends Service {

    private String sTR_Expander_URL = "";
    private String sTR_HEAD = "";
    private String sTR_BODY = "";
    private String sTR_URL="";

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

        sTR_BODY = STR_DATA.getStrBody();
        sTR_HEAD = STR_DATA.getStrHead(); //SMS 리시버를 통해 얻은 문자내용+수신자를 옮김
        sTR_URL = Extract.url_ExtractSub(sTR_BODY);


        if (sTR_URL.contains(".co.kr")) {
            if (domainCheck.co_kr_Check(sTR_URL) == 1) { //1일시 도메인 적합
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf(); //작업 후 서비스 종료
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
        }
        else if (sTR_URL.contains(".com")) {
            if (domainCheck.com_Check(sTR_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
        }
        else if (sTR_URL.contains(".go.kr")) {
            if (domainCheck.go_kr_Check(sTR_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
        }
        else if (sTR_URL.contains("http://naver.me"))
        {
            //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
            //단축이여도 안전한 URL로 판단
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
            else
                NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
            stopSelf();
        }
        else if (sTR_URL.contains(".net")) {
            if (domainCheck.net_Check(sTR_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
        }
        else if (sTR_URL.contains(".ac.kr"))
        {
            if (domainCheck.ac_kr_Check(sTR_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
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
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_Notification_NotFound(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_Notification_NotFound(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else if (sTR_Expander_URL.contains(".apk") || sTR_Expander_URL.contains(".APK")) {
                //앱을 설치하라는 문자 또한 구글 플레이 스토어로 연결되는 URL이 포함되어 있기에
                //모든 상황에서의 SMS 문자로는 apk포함 URL이 올 이유가 없기에 apk 포함 URL일 시 지체없이 악성파일로 판단
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_Notification_Malware(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_Notification_Malware(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else if (ipCheck.Check_identity_protocol(sTR_Expander_URL)) {
                //IP가 첨부된 URL을 탐지
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_Notification_IP(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_Notification_IP(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            //다시한번 확장된 URL의 도메인 적합성 진행
            else if (sTR_Expander_URL.contains(".co.kr")) {
                if (domainCheck.co_kr_Check(sTR_Expander_URL) == 1)
                { //1일시 도메인 적합
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
            }
            else if (sTR_Expander_URL.contains(".com"))
            {
                if (domainCheck.com_Check(sTR_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
            }
            else if (sTR_Expander_URL.contains(".go.kr"))
            {
                if (domainCheck.go_kr_Check(sTR_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
            }
            else if (sTR_Expander_URL.contains("http://naver.me"))
            {
                //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
                //단축이여도 안전한 URL로 판단
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
            else if (sTR_Expander_URL.contains(".net"))
            {
                if (domainCheck.net_Check(sTR_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
            }
            else if (sTR_Expander_URL.contains(".ac.kr"))
            {
                if (domainCheck.ac_kr_Check(sTR_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                    stopSelf();
                }
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,sTR_HEAD,sTR_BODY);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),sTR_HEAD,sTR_BODY);
                stopSelf();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
