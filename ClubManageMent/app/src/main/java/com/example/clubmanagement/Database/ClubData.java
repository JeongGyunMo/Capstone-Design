package com.example.clubmanagement.Database;

import android.app.ProgressDialog;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Thread.sleep;

public class ClubData{
    String myJSON;
    public String Temp;
    private static final String TAG_RESULTS = "result";
    private static final String CLUB_ID = "CLUB_ID"; // 동아리 번호
    private static final String CLUB_NM = "CLUB_NM"; // 동아리 이름
    private static final String CLUB_GB_CD = "CLUB_GB_CD"; // 중동/전공
    private static final String CLUB_AT_CD = "CLUB_AT_CD"; // 학술/운동...
    private static final String CLUB_CNT = "CLUB_CNT";
    private static final String CLUB_AIM = "CLUB_AIM";
    private static final String CLUB_ACTIVE = "CLUB_ACTIVE";
    private static final String CLUB_ROOM = "CLUB_ROOM";
    private static final String OPEN_DT = "OPEN_DT";
    private static final String INTRO_CONT = "INTRO_CONT";
    private static final String INTRO_FILE_NM = "INTRO_FILE_NM";
    private static final String INTRO_FILE_PATH = "INTRO_FILE_PATH";
    private static final String INTRO_SAVE_FILE_NM = "INTRO_SAVE_FILE_NM";
    private static final String INPUT_ID = "INPUT_ID";
    private static final String INPUT_IP = "INPUT_IP";
    private static final String INPUT_DATE = "INPUT_DATE";
    private static final String UPDATE_ID = "UPDATE_ID";
    private static final String UPDATE_IP = "UPDATE_IP";
    private static final String UPDATE_DATE = "UPDATE_DATE";

    public JSONArray JSON_Club_Item = null;
    public ArrayList<HashMap<String, String>> Club_Item_list;

    public ClubData(){
        JSON_Club_Item = null;
        Club_Item_list = new ArrayList<HashMap<String, String>>();
      getData("http://192.168.0.9/CLUB.php"); //http://[현재자신의아이피]/PHP_connection.php
    }

    public ArrayList<HashMap<String, String>> GetListData(String temp) {
        try {
            JSONObject jsonObj = new JSONObject(temp);
            JSON_Club_Item = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < JSON_Club_Item.length(); i++) {
                JSONObject c = JSON_Club_Item.getJSONObject(i);
                String id = c.getString(CLUB_ID);
                String name = c.getString(CLUB_NM);
                String GB_CD = c.getString(CLUB_GB_CD);
                String AT_CD = c.getString(CLUB_AT_CD);
                String CNT = c.getString(CLUB_CNT);
                String AIM = c.getString(CLUB_AIM);
                String ACTIVE = c.getString(CLUB_ACTIVE);
                String ROOM = c.getString(CLUB_ROOM);
                String OPENDT = c.getString(OPEN_DT);
                String CONT = c.getString(INTRO_CONT);
                String FILE_NM = c.getString(INTRO_FILE_NM);
                String FILE_PATH = c.getString(INTRO_FILE_PATH);
                String SAVE_FILE_NM = c.getString(INTRO_SAVE_FILE_NM);
                String INID = c.getString(INPUT_ID);
                String INIP = c.getString(INPUT_IP);
                String INDATE = c.getString(INPUT_DATE);
                String UPID = c.getString(UPDATE_ID);
                String UPIP = c.getString(UPDATE_IP);
                String UPDATE = c.getString(UPDATE_DATE);
                HashMap<String, String> Club_Item = new HashMap<String, String>();
                Club_Item.put(CLUB_ID, id);
                Club_Item.put(CLUB_NM, name);
                Club_Item.put(CLUB_GB_CD, GB_CD);
                Club_Item.put(CLUB_AT_CD, AT_CD);
                Club_Item.put(CLUB_CNT, CNT);
                Club_Item.put(CLUB_AIM, AIM);
                Club_Item.put(CLUB_ACTIVE, ACTIVE);
                Club_Item.put(CLUB_ROOM, ROOM);
                Club_Item.put(OPEN_DT, OPENDT);
                Club_Item.put(INTRO_CONT, CONT);
                Club_Item.put(INTRO_FILE_NM, FILE_NM);
                Club_Item.put(INTRO_FILE_PATH, FILE_PATH);
                Club_Item.put(INTRO_SAVE_FILE_NM, SAVE_FILE_NM);
                Club_Item.put(INPUT_ID, INID);
                Club_Item.put(INPUT_IP, INIP);
                Club_Item.put(INPUT_DATE, INDATE);
                Club_Item.put(UPDATE_ID, UPID);
                Club_Item.put(UPDATE_IP, UPIP);
                Club_Item.put(UPDATE_DATE, UPDATE);
                Club_Item_list.add(Club_Item);
            }
            return Club_Item_list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Club_Item_list;
    }
    public void ClearListData(){
        Club_Item_list.clear();
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
