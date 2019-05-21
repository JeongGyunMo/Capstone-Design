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

public class StudentData {
    String myJSON;
    public String Temp;
    private static final String TAG_RESULTS = "result";
    private static final String STUDENT_ID = "STUDENT_ID"; // 동아리 번호
    private static final String PASSWORD = "PASSWORD"; // 동아리 이름

    public JSONArray JSON_Student_Item = null;
    public ArrayList<HashMap<String, String>> Student_Item_list;

    public StudentData(){
        JSON_Student_Item = null;
        Student_Item_list = new ArrayList<HashMap<String, String>>();
        getData("http://192.168.0.3/Student.php"); //http://[현재자신의아이피]/PHP_connection.php
    }

    public ArrayList<HashMap<String, String>> GetListData() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            JSON_Student_Item = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < JSON_Student_Item.length(); i++) {
                JSONObject c = JSON_Student_Item.getJSONObject(i);
                String id = c.getString(STUDENT_ID);
                String name = c.getString(PASSWORD);

                HashMap<String, String> Club_Item = new HashMap<String, String>();
                Club_Item.put(STUDENT_ID, id);
                Club_Item.put(PASSWORD, name);

                Student_Item_list.add(Club_Item);
            }

            return Student_Item_list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Student_Item_list;
    }
    public void ClearListData(){
        Student_Item_list.clear();
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
                    //Temp =  stringBuilder.toString().trim();
                    return  stringBuilder.toString().trim(); //trim은 앞뒤의 공백을 제거함

                } catch (Exception e) {
                    return null;
                }
            }
            @Override
            protected void onPostExecute(String result) {myJSON = result; }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }
}
