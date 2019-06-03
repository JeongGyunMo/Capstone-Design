package com.example.clubmanagement.Database;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class RestaurantData {
    String myJSON;
    public String Temp;
    private static final String TAG_RESULTS = "result";
    private static final String REST_NM = "REST_NM";
    private static final String REST_PHONE_NO = "REST_PHONE_NO"; // 동아리 이름


    public JSONArray JSON_Restaurant;
    public ArrayList<HashMap<String, String>> Restaurant_list;
    private String temp;

    public RestaurantData(){
        JSON_Restaurant = null;
        Restaurant_list = new ArrayList<>();
        getData("http://192.168.0.12/RESTAURANT.php"); //http://[현재자신의아이피]/PHP_connection.php
    }

    public ArrayList<HashMap<String, String>> GetListData(String temp) {
        this.temp = temp;
        try {
            JSONObject jsonObj = new JSONObject(temp);
            JSON_Restaurant = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < JSON_Restaurant.length(); i++) {
                JSONObject c = JSON_Restaurant.getJSONObject(i);
                String name = c.getString(REST_NM);
                String number = c.getString(REST_PHONE_NO);
                HashMap<String, String> Restaurant = new HashMap<String, String>();
                Restaurant.put(REST_NM, name);
                Restaurant.put(REST_PHONE_NO, number);
                Restaurant_list.add(Restaurant);
            }
            return Restaurant_list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Restaurant_list;
    }
    public void ClearListData(){
        Restaurant_list.clear();
    }
    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String uri = params[0];
                try {
                    URL url = new URL(uri);//URL 객체 생성
                    //URL을 이용해서 웹페이지에 연결하는 부분
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setConnectTimeout(1000);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.setRequestMethod("POST");

                    //바이트단위 입력스트림 생성 소스는 httpURLConnection
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String temp;
                    //문자열 처리를 더 빠르게 하기 위해 StringBuilder클래스를 사용함
                    StringBuilder stringBuilder = new StringBuilder();
                    //한줄씩 읽어서 stringBuilder에 저장함
                    while ((temp = bufferedReader.readLine()) != null) {
                        stringBuilder.append(temp + "\n");//stringBuilder에 넣어줌
                    }
                    //사용했던 것도 다 닫아줌
                    bufferedReader.close();
                    httpURLConnection.disconnect();
                    Temp =  stringBuilder.toString().trim();
                    return Temp;//trim은 앞뒤의 공백을 제거함

                } catch (Exception e) {
                    return null;
                }
            }
            @Override
            protected void onPostExecute(String result) {myJSON = result; }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
        g.onPostExecute("result");
        g.doInBackground(url);
    }
}
