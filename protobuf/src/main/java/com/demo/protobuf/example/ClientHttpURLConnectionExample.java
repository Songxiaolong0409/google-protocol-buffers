package com.demo.protobuf.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class ClientHttpURLConnectionExample {

    @GetMapping("/client2")
    public String client2() {
        String url="http://127.0.0.1:8081/getProtobuf/";

//        UserBuilder.User user=UserBuilder.User.newBuilder();

//        final byte[] data = new byte[user.getSerializedSize()];

        try {
//            CodedOutputStream output = CodedOutputStream.newInstance(data);
//            user.writeTo(output);

            return post(url,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    /** @throws IOException
     * @throws MalformedURLException
     */
    private String post(String url, byte[] args) throws MalformedURLException, ConnectException, IOException {
        String result = null;

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
        conn.setConnectTimeout(30 * 1000);
        conn.setReadTimeout(30 * 1000);
        conn.setRequestMethod(RequestMethod.GET.name());
        conn.setDoInput(true);
        conn.setDoOutput(true);

        //conn.setRequestProperty("Accept", "application/json, text/javascript, */*; q=0.01");
        //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        //conn.setRequestProperty("Charset", "UTF-8");
//        conn.setRequestProperty("Content-Length", "" + args.length);

//        OutputStream os = conn.getOutputStream();
//        os.write(args);

        if (200 == conn.getResponseCode()) {
            InputStream in = conn.getInputStream();
            InputStreamReader ir = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(ir);

            String strLine;
            StringBuffer buffer = new StringBuffer();
            while ((strLine = br.readLine()) != null) {
                buffer.append(strLine);
            }

            br.close();
            ir.close();
            in.close();

            result = buffer.toString();
        }

//        os.close();
        conn.disconnect();

        return result;
    }
}
