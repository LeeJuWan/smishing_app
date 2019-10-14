package andbook.example.smishing;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import util.AlarmChannel;


/*
 * Create by 이주완 2019.04.13
 *
 * 2019.04.13 지속적인 업데이트 및 기능 점검 ,관리필요
 * 개발자 : 이주완  소속: 공주대학교 컴퓨터 공학부
 *
 * 추후 도메인 리스트업을 통하여 더많은 안전 리스트 확보
 * -----------------------------------------------
 * 2019.06.23
 * 개선: net 클래스 생성 후 화이트 리스트업 진행  첫 net 도메인 -> daum.net 등록
 * go 클래스 화이트 리스트 업
 * -----------------------------------------------
 * 2019.06.23
 * 개선: ac.kr 클래스 생성 후 화이트 리스트업 진행 학교별로 화이트 리스트 등록
 * -----------------------------------------------
 * 2019.07.24
 * 개선: 전체 소스코드 리펙토링 작업, 푸시 알람 리펙토링, 네트워킹 리펙토링, 네트워킹 NOT FOUND 알람 처리
 * ------------------------------------------------
 * 2019.09.09
 * 개선: UI 작업
 * -------------------------------------------------
 * 2019.09.12
 * 개선: 소스파일 역할에 따른 패키지별로 구분 유지보수 용이 및 메소드이름 첫글자 소문자로 변경
 * --------------------------------------------------
 * 개선: android version up 28 , 알람 채널 생성 및 오레오 , 오레오 미만 버전 별로 Notification 구현
 * UI 위치 수정 , 파일명 refector
 * */


public class MainActivity extends AppCompatActivity {

    private final int PERMISSIONREQUEST_RESULT = 100; // 콜백 호출시 requestcode로 넘어가는 구분자


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //상태바 제거

        Button start = (Button) findViewById(R.id.Start);
        Button end = (Button) findViewById(R.id.End);
        Button info = (Button) findViewById(R.id.Infomation);

        AlarmChannel.createChannel(getApplicationContext());

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_DENIED)
                        Toast.makeText(getApplicationContext(), "권한이 허용되어 탐지중입니다.", Toast.LENGTH_SHORT).show();
                    else
                    CheckPermission();
                }
                else
                    Toast.makeText(getApplicationContext(), "탐지중 (마시멜로우 미만 버전용)", Toast.LENGTH_SHORT).show();
            }
        });
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.big)
                        .setCancelable(false)
                        .setTitle("안전한 모바일 사용을 위하여")
                        .setMessage("Smishing Detection은 사용자에게 도착하는 문자를 읽어들이고 분석합니다. 이후 알림으로 악성유무를 제공합니다.")
                        .setPositiveButton("확인",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss(); //닫기
                                    }
                                }).show();
            }
        });


    }

    //퍼미션 권한 진행 함수
    private void CheckPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_DENIED) {
            //사용자의 최초 퍼미션 허용을 확인         -true: 사용자 퍼미션 거부 , -false: 사용자 동의 미 필요
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECEIVE_SMS)) {
                Toast.makeText(getApplicationContext(), "권한이 필요합니다.", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECEIVE_SMS},
                        PERMISSIONREQUEST_RESULT);
            } else {
                Toast.makeText(getApplicationContext(), "권한이 필요합니다.", Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECEIVE_SMS},
                        PERMISSIONREQUEST_RESULT);
            }

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);

        if (requestCode == PERMISSIONREQUEST_RESULT) {
            if (grantResult.length > 0) {
                for (int aGrantResult : grantResult) {
                    if (aGrantResult == PackageManager.PERMISSION_DENIED) {
                        //권한이 하나라도 거부 될 시
                        new AlertDialog.Builder(MainActivity.this)
                                .setCancelable(false)
                                .setTitle("사용 권한의 문제발생")
                                .setIcon(R.drawable.big)
                                .setMessage("탐지를 위해서 권한을 허용해주세요.")
                                .setPositiveButton("종료", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                }).setNegativeButton("권한 설정", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                                        .setData(Uri.parse("package:" + getPackageName()));
                                startActivity(intent);
                                dialog.dismiss();
                            }
                        }).show();
                        return;
                    }
                }
            }
        }
    }
}
