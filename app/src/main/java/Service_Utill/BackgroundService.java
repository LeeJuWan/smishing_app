package Service_Utill;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import java.util.concurrent.ExecutionException;

import Network_Utill.ExpanderNetwork;
import Alarm_Utill.AlarmChannel;
import Alarm_Utill.NotificationNotOreo;
import Alarm_Utill.NotificationOreo;
import URLPasing_Utill.DomainCheck;
import URLPasing_Utill.IPCheck;
import URLPasing_Utill.STR_DATA;
import URLPasing_Utill.URLExtract;


public class BackgroundService extends Service {

    private String str_Expander_URL,
            str_HEAD,
            str_BODY,
            str_URL;

    private DomainCheck domainCheck;
    private IPCheck ipCheck;
    private URLExtract extract;
    private  ExpanderNetwork expanderURL;
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        str_Expander_URL="";
        str_HEAD="";
        str_BODY="";
        str_URL="";
        domainCheck = new DomainCheck();
        ipCheck = new IPCheck();
        extract = new URLExtract();
        expanderURL= new ExpanderNetwork();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        str_BODY = STR_DATA.strBody;
        str_HEAD = STR_DATA.strHead; // SMS 리시버를 통해 얻은 문자내용+수신자를 옮김
        str_URL = extract.url_ExtractSub(str_BODY); // URL만 추출진행


        if (str_URL.contains(".co.kr")) {
            if (domainCheck.co_kr_Check(str_URL) == 1) { // 1일시 도메인 적합
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf(); // 작업 후 서비스 종료
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
        }
        else if (str_URL.contains(".com")) {
            if (domainCheck.com_Check(str_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
        }
        else if (str_URL.contains(".go.kr")) {
            if (domainCheck.go_kr_Check(str_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
        }
        else if (str_URL.contains("naver.me"))
        {
            //네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
            //단축이여도 안전한 URL로 판단
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
            else
                NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
            stopSelf();
        }
        else if (str_URL.contains(".net")) {
            if (domainCheck.net_Check(str_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
        }
        else if (str_URL.contains(".ac.kr"))
        {
            if (domainCheck.ac_kr_Check(str_URL) == 1) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
            else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_URL);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_URL);
                stopSelf();
            }
        } else {
            // 위의 if~else if 조건은 단축이 아닌, '원본 UR'L로 SMS문자로 왔을 경우를 탐지한다.
            // 본 else문부터는 '단축 URL'일 경우에 오는 조건이기에 'URL 확장 진행'을 진행한다.
            // 또한 안전한 도메인을 '단축 URL'로 보낼 수 있는 경우도 있기에, 위의 if~else if와 같이 도메인 적합성을 '다시' 검사한다.
            // '프로토콜~ 쿼리스트링'까지 추출한 URL을 리다이렉팅시켜 원래의 '원본 URL'을 추출한다.
            try {
                str_Expander_URL = expanderURL.execute(str_URL).get();
            } catch (InterruptedException e) {
                System.err.println("Background InterruptedException error");
            } catch (ExecutionException e) {
                System.err.println("Background ExecutionExceptio error");
            }
            if (str_Expander_URL.contains("notFound")) {
                // not found 페이지 삭제됬거나 찾지못함
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_Notification_NotFound(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY);
                else
                    NotificationNotOreo.send_Notification_NotFound(getApplicationContext(),str_HEAD,str_BODY);
                stopSelf();
            }
            else if (str_Expander_URL.contains(".apk") || str_Expander_URL.contains(".APK")) {
                // 앱을 설치하라는 문자 또한 구글 플레이 스토어로 연결되는 URL이 포함되어 있기에
                // 모든 상황에서의 SMS 문자로는 'apk포함' URL이 올 이유가 없기에 'apk포함' URL일 시 지체없이 악성파일로 판단
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_Notification_Malware(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                else
                    NotificationNotOreo.send_Notification_Malware(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                stopSelf();
            }
            else if (ipCheck.Check_identity_protocol(str_Expander_URL)) {
                // ip가 첨부된 URL을 탐지
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_Notification_IP(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                else
                    NotificationNotOreo.send_Notification_IP(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                stopSelf();
            }
            // 다시한번 확장된 URL의 도메인 적합성 진행
            else if (str_Expander_URL.contains(".co.kr")) {
                if (domainCheck.co_kr_Check(str_Expander_URL) == 1)
                { // 1일시 도메인 적합
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
            }
            else if(str_Expander_URL.contains(".com"))
            {
                if (domainCheck.com_Check(str_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
            }
            else if (str_Expander_URL.contains(".go.kr"))
            {
                if (domainCheck.go_kr_Check(str_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
            }
            else if (str_Expander_URL.contains("naver.me"))
            {
                // 네이버 me는 네이버 서비스에서만 사용가능한 URL이기에
                // 단축이여도 안전한 URL로 판단
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                else
                    NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                stopSelf();
            }
            else if (str_Expander_URL.contains(".net"))
            {
                if (domainCheck.net_Check(str_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
            }
            else if (str_Expander_URL.contains(".ac.kr"))
            {
                if (domainCheck.ac_kr_Check(str_Expander_URL) == 1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_Safe(getApplicationContext(), AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_Safe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
                else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                        NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                    else
                        NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                    stopSelf();
                }
            }
            else { // White list에 없는 사이트
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                    NotificationOreo.send_NotifiCation_NotSafe(getApplicationContext(),AlarmChannel.Channel.MESSAGE_ID,str_HEAD,str_BODY,str_Expander_URL);
                else
                    NotificationNotOreo.send_NotifiCation_NotSafe(getApplicationContext(),str_HEAD,str_BODY,str_Expander_URL);
                stopSelf();
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
