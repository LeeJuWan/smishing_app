package network_utill;


import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

public class ExpanderNetwork extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {

        String expand_URL = "";

        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            connection.setInstanceFollowRedirects(false);
            connection.connect();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
                expand_URL = "notFound"; // 없는 페이지일 시

            else {
                if(TextUtils.isEmpty(connection.getHeaderField("Location")))
                    expand_URL = "notFound"; // 최근 접속 경로 찾지못함
                else
                    expand_URL = connection.getHeaderField("Location");
            }
            connection.getInputStream().close(); // 연결 종료
        } catch (MalformedURLException e) {
            System.err.println("ExpanderNetwork MalformedURLException");
        } catch (IOException e) {
            System.err.println("ExpanderNetwork IOException");
        }
        return expand_URL;
    }
}