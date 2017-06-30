package com.lj.exam.test;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public final class HttpUtils {
    
    public static void main(String[] args) {
        String url = "http://localhost:8080/test-ww/rest/ExamRecordInfoRest/insertExamRecord";
        HttpClient client = new DefaultHttpClient();  
        HttpPost httpPost = new HttpPost(url); 
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            httpPost.addHeader("city", "010");
            httpPost.addHeader("version", "2");
            HttpEntity entity = new StringEntity("");
            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            params.add(new BasicNameValuePair("param", "{\"examineRoomCode\":\"1234\",\"courseCode\":\"1234\",\"courseSubCode\":\"1234\",\"examineeNum\":\"1234\",\"examineeName\":\"1234\",\"score\":\"1234\",\"video\":\"1234\",\"file\":\"1234\"}"));
            
            //httpPost.setEntity(entity);
            
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            
            HttpResponse response = client.execute(httpPost);
            System.out.println(response.getStatusLine());
        } catch (Exception e) {
            e.printStackTrace();
        }}
}
