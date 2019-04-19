package andbook.example.smishing_release;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity{

    protected void onCreate(Bundle savedInstanceStat){
        super.onCreate(savedInstanceStat);
        try{
            Thread.sleep(3000); //대기초 설정
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}
