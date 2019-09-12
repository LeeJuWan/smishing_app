package andbook.example.smishing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends Activity{

    protected void onCreate(Bundle savedInstanceStat){
        super.onCreate(savedInstanceStat);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //상태바 제거
        try{
            Thread.sleep(3000); //대기초 설정
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
