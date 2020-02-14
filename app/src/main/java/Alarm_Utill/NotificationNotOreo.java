package Alarm_Utill;


import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.app.Notification;
import android.graphics.BitmapFactory;
import android.os.Build;

import andbook.example.smishing.R;

public class NotificationNotOreo {

    private static final String phone = "(\\d{3})(\\d{3,4})(\\d{4})";

    private static Notification.Builder builder; // 푸시알람 빌더 생성
    private static NotificationManager notificationManager; // 푸시 알람 매니저 생성
    private static Notification.BigTextStyle bigTextStyle; // 푸시 알람 핀치줌을 위한 텍스트 스타일 생성


    // 안전문자 푸시
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void send_NotifiCation_Safe(Context context,String str_HEAD,String str_BODY) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle(str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("문자가 도착하였습니다. 안전한 SMS 문자입니다.");
        builder.setAutoCancel(true);

        bigTextStyle = new Notification.BigTextStyle(builder);
        bigTextStyle.setBigContentTitle("보낸사람: "+str_HEAD);
        bigTextStyle.bigText("문자내용: "+str_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 의심문자 푸시
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void send_NotifiCation_NotSafe(Context context,String str_HEAD,String str_BODY) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context);
        bigTextStyle = new Notification.BigTextStyle(builder);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle(str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("문자가 도착하였습니다. 스미싱으로 의심되는 문자입니다. 조심하세요.");
        builder.setAutoCancel(true);

        bigTextStyle = new Notification.BigTextStyle(builder);
        bigTextStyle.setBigContentTitle("보낸사람: "+str_HEAD);
        bigTextStyle.bigText("문자내용: "+str_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 악성코드 푸시
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void send_Notification_Malware(Context context,String str_HEAD,String str_BODY) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle(str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("문자가 도착하였습니다. 악성코드가 포함된 문자입니다. 조심하세요.");
        builder.setAutoCancel(true);

        bigTextStyle = new Notification.BigTextStyle(builder);
        bigTextStyle.setBigContentTitle("보낸사람: "+str_HEAD);
        bigTextStyle.bigText("문자내용: "+str_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 공격자 서버 주소 푸시
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void send_Notification_IP(Context context,String str_HEAD,String str_BODY) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context);


        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);//진동으로 알람 진행
        builder.setContentTitle(str_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("문자가 도착하였습니다. 서버 주소가 포함된 문자입니다. 조심하세요.");
        builder.setAutoCancel(true);

        bigTextStyle = new Notification.BigTextStyle(builder);
        bigTextStyle.setBigContentTitle("보낸사람: "+str_HEAD);
        bigTextStyle.bigText("문자내용: "+str_BODY);
        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }

    // 없는 페이지 서버
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void send_Notification_NotFound(Context context,String sTR_HEAD,String sTR_BODY) {

        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        builder = new Notification.Builder(context);

        builder.setSmallIcon(R.drawable.small); // 아이콘 추가
        builder.setWhen(System.currentTimeMillis());
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.big)); // 알림내용 왼쪽 큰 아이콘 적용
        builder.setDefaults(Notification.DEFAULT_VIBRATE);// 진동으로 알람 진행
        builder.setContentTitle(sTR_HEAD.replaceAll(phone, "$1-$2-$3"));
        builder.setContentText("문자가 도착하였습니다. 없는 사이트 이거나 알수없음.");
        builder.setAutoCancel(true);

        bigTextStyle = new Notification.BigTextStyle(builder);
        bigTextStyle.setBigContentTitle("보낸사람: "+sTR_HEAD);
        bigTextStyle.bigText("문자내용: "+sTR_BODY);

        notificationManager.notify((int) (System.currentTimeMillis() / 1000), builder.build());
    }
}