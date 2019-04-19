package andbook.example.smishing_release;

import android.os.AsyncTask;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class Expander_URL extends Thread{
    private String Expand_URL="";
    private String STR_URL="";

    @Override
    public void run(){
        try{
            URL url=new URL(this.STR_URL);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setInstanceFollowRedirects(false);
            this.Expand_URL=conn.getHeaderField("Location");
            conn.disconnect();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void Set_URL(String URL){
       this.STR_URL=URL;
    }
    public String Get_URL(){
        return Expand_URL;
    }
}
/*public class Expander_URL extends AsyncTask<String ,Void ,String>{

    private String Expand_URL="";
    private String STR_URL="";


    @Override
    protected String doInBackground(String... params) {
        String expander="";
        try{
            URL url=new URL(params[0]);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setInstanceFollowRedirects(false);
            expander=conn.getHeaderField("Location");
            conn.disconnect();

        }catch (IOException e){
            e.printStackTrace();
        }
        return expander;
    }

    protected void onPostExcute(String expander){
        super.onPostExecute(expander);
        Expand_URL=expander;
    }
    public void Set_URL(String URL){
        STR_URL=URL;
    }
    public String Get_URL(){
        return Expand_URL;
    }
}
*/