package andbook.example.smishing_release;


/*
 * 2019.04.13 지속적인 업데이트 및 기능 점검 ,관리필요
 * 개발자 : 이주완  소속: 공주대학교 컴퓨터 공학부
 * 추후 도메인 리스트업을 통하여 더많은 안전 리스트 확보
 * */


import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public Button Btn1;
    public Button Btn2;
    public Button Btn3;
    public int code=0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        Btn1 = (Button) findViewById(R.id.Start);
        Btn2 = (Button) findViewById(R.id.End);
        Btn3=(Button)findViewById(R.id.infomation);
       /* StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);*/
        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.RECEIVE_SMS) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getApplicationContext(), "탐지 중", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "권한이 필요합니다.", Toast.LENGTH_SHORT).show();
                        requestPermissions(new String[]{Manifest.permission.RECEIVE_SMS}, 1);
                    }
                }
            }
        });
        Btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                builder.setTitle("안전한 모바일 사용을 위하여");
                builder.setMessage("Smishing Detection은 상업적 광고와 수익을 추구하지 않습니다." +
                        " 사용자들의 안전한 모바일 환경에 도움이 되기위해 재능 기부 형태로 개발하였습니다." +
                        " 시작 버튼을 선택하셔서 초기의 최소한의 권한만 요구합니다. 그 이후 조용히 숨어있다가 악성문자"+
                        " 발견시 SNS알림 형태로 알려드립니다."+
                        " 남녀노소 누구나 편하게 이용하실수 있습니다." +
                        " 지속적인 업데이트를 통하여 넓은 범위의 악성문자를 탐지하겠습니다.\n감사합니다. :)\n"+
                        "[문의사항 개발자 leejuwan123@naver.com]");
                builder.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel(); //닫기
                            }
                        });
                builder.setNegativeButton("도움말 닫기",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel(); //닫기
                            }
                        });
                builder.show();
            }
        });
    }
    @Override
    public  void onRequestPermissionsResult(int requestCode, @NonNull String[] permission, @NonNull int[] grantResult){
        super.onRequestPermissionsResult(requestCode,permission,grantResult);

        switch (requestCode){
            case 1: {
                if (grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    code =+ 1;
                }
                break;
            }
            case 2: {
                if (grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                    code =+ 1;
                }
                break;
            }
            default:
                break;
        }
    }
}

