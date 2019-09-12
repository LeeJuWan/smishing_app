package Network;


import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;

public class ExpanderNetwork extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        String expand_URL = null;
        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY);
            connection.setInstanceFollowRedirects(false);
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND)
                expand_URL = "notFound";
            else
                expand_URL = connection.getHeaderField("Location");
            connection.getInputStream().close();
        } catch (MalformedURLException e) {
            System.err.println("Async MalformedURLException");
        } catch (IOException e) {
            System.err.println("Expander IOException");
        }
        if (expand_URL == null)
            expand_URL = "notFound";
        return expand_URL;
    }
}