package alarm_utill;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;

import andbook.example.smishing.R;

public class NotificationOreo {

    private static final String phone = "(\\d{3})(\\d{3,4})(\\d{4})";

    private static Notification.Builder builder; // 푸시알람 빌더 생성
    private static NotificationManager notificationManager; // 푸시 알람 매니저 생성



    // 안전문자 푸시
    @TargetApi(Build.VERSION_CODES.O)
    public static void send_NotifiCation_Safe(Context context, @AlarmChannel.Channel String channel, String str_HEAD, String str_BODY,String str_URL) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context,channel);


        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setAutoCancel(true);
        builder.setStyle(new Notification.BigTextStyle()
                .setSummaryText("안전한 SMS 문자입니다.")
                .bigText("문자내용: "+str_BODY+"\n\n"+"##접속주소: "+str_URL)
                .setBigContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3")))
                .build();

        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 의심문자 푸시
    @TargetApi(Build.VERSION_CODES.O)
    public static void send_NotifiCation_NotSafe(Context context,@AlarmChannel.Channel String channel,String str_HEAD,String str_BODY,String str_URL) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context,channel);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setAutoCancel(true);
        builder.setStyle(new Notification.BigTextStyle()
                .setSummaryText("스미싱으로 의심되는 문자입니다.")
                .bigText("문자내용: "+str_BODY+"\n\n"+"##접속주소: "+str_URL)
                .setBigContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3")))
                .build();

        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 악성코드 푸시
    @TargetApi(Build.VERSION_CODES.O)
    public static void send_Notification_Malware(Context context,@AlarmChannel.Channel String channel,String str_HEAD,String str_BODY,String str_URL) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context,channel);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setAutoCancel(true);
        builder.setStyle(new Notification.BigTextStyle()
                .setSummaryText("스미싱 문자입니다.")
                .bigText("문자내용: "+str_BODY+"\n\n"+"##접속주소: "+str_URL)
                .setBigContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3")))
                .build();

        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 공격자 서버 주소 푸시
    @TargetApi(Build.VERSION_CODES.O)
    public static void send_Notification_IP(Context context,@AlarmChannel.Channel String channel,String str_HEAD,String str_BODY,String str_URL) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context,channel);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setAutoCancel(true);
        builder.setStyle(new Notification.BigTextStyle()
                .setSummaryText("스미싱 문자입니다.")
                .bigText("문자내용: "+str_BODY+"\n\n"+"##접속주소: "+str_URL)
                .setBigContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3")))
                .build();

        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 없는 페이지일 시
    @TargetApi(Build.VERSION_CODES.O)
    public static void send_Notification_NotFound(Context context,@AlarmChannel.Channel String channel,String str_HEAD,String str_BODY) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context,channel);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setAutoCancel(true);
        builder.setStyle(new Notification.BigTextStyle()
                .setSummaryText("없는 사이트 이거나 알수없음")
                .bigText("문자내용: "+str_BODY)
                .setBigContentTitle("발신번호: "+str_HEAD.replaceAll(phone, "$1-$2-$3")))
                .build();

        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }
}
