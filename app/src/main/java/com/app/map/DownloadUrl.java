package com.app.map;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadUrl {


    public String readUrl(String strUrl) throws Exception {

        String data = "";
        InputStream inputStream =null;
        HttpURLConnection httpURLConnection = null;

        try {

            URL url = new URL(strUrl);
            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String line = "";
            while((line = br.readLine() ) != null ){
                stringBuffer.append(line);

            }

            data = stringBuffer.toString();
            br.close();

        }catch( Exception e ){

        }finally {
            inputStream.close();
            httpURLConnection.disconnect();
        }

        return data;

    }
}
