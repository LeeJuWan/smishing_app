package util;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 알람 채널 생성 및 푸시알람 구현
public class AlarmChannel {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ // 알람채널을 위한 ID 및 상세 메시지 생성
            Channel.GROUP_ID,
            Channel.GROUP_NAME,
            Channel.MESSAGE_ID,
            Channel.MESSAGE_NAME,
            Channel.MESSAGE_DESC})
    public @interface  Channel{
        // 채널 그룹
        String GROUP_ID = "smishing_detection",
                GROUP_NAME = "스미싱 탐지";
        // 메시지 채널
        String MESSAGE_ID ="smishing",
                MESSAGE_NAME = "알람 메시지",
                MESSAGE_DESC = "문자 분석후 알람을 보냅니다.";
    }

    @TargetApi(Build.VERSION_CODES.O)
    public static void createChannel(Context context) {

        // 채널 그룹 생성
        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannelGroup group = new NotificationChannelGroup(
                Channel.GROUP_ID, Channel.GROUP_ID);
        notificationManager.createNotificationChannelGroup(group);

        // 채널 생성: 메시지
        NotificationChannel channelMessage = new NotificationChannel(
                Channel.MESSAGE_ID, Channel.MESSAGE_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        channelMessage.setDescription(Channel.MESSAGE_DESC); // 채널 설명
        channelMessage.setGroup(Channel.GROUP_ID); // 속해있는 채널 그룹 ID
        channelMessage.enableLights(true); // LED 점멸 기능
        channelMessage.setLightColor(Color.RED); // LED 색상(적색)
        channelMessage.enableVibration(true); // 진동 가능
        notificationManager.createNotificationChannel(channelMessage);
    }

}