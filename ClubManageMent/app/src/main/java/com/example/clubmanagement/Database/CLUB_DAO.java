package com.example.clubmanagement.Database;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.clubmanagement.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class CLUB_DAO extends Activity {
    String myJSON;
    private static final String CLUB_ID = "CLUB_ID";
    private static final String CLUB_NM = "CLUB_NM";
    private static final String CLUB_GB_CD = "CLUB_GB_CD";
    private static final String CLUB_AT_CD = "CLUB_AT_CD";
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
    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_listview);
        list = (ListView) findViewById(R.id.listView);
        personList = new ArrayList<HashMap<String, String>>();
        getData("http://192.168.0.11/PHP_connection.php"); //http://[현재자신의아이피]/PHP_connection.php
    }
    public void showList() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(CLUB_ID);
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String id = c.getString(CLUB_ID);
                String nm = c.getString(CLUB_NM);
                String gb_cd = c.getString(CLUB_GB_CD);
                String at_cd= c.getString(CLUB_AT_CD);
                String cnt = c.getString(CLUB_CNT);
                String aim = c.getString(CLUB_AIM);
                String active = c.getString(CLUB_ACTIVE);
                String room = c.getString(CLUB_ROOM);
                String open_dt = c.getString(OPEN_DT);
                String intro_cont = c.getString(INTRO_CONT);
                String intro_file_nm= c.getString(INTRO_FILE_NM);
                String intro_file_path= c.getString(INTRO_FILE_PATH);
                String intro_save_file_nm= c.getString(INTRO_SAVE_FILE_NM);
                String input_id= c.getString(INPUT_ID);
                String input_ip = c.getString(INPUT_IP);
                String input_date= c.getString(INPUT_DATE);
                String update_id= c.getString(UPDATE_ID);
                String update_ip = c.getString(UPDATE_IP);
                String update_date= c.getString(UPDATE_DATE);
                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(CLUB_ID, id);
                persons.put(CLUB_NM, nm);
                persons.put(CLUB_GB_CD, gb_cd);
                persons.put(CLUB_AT_CD, at_cd);
                persons.put(CLUB_CNT, cnt);
                persons.put(CLUB_AIM, aim);
                persons.put(CLUB_ACTIVE, active);
                persons.put(CLUB_ROOM, room);
                persons.put(OPEN_DT, open_dt);
                persons.put(INTRO_CONT, intro_cont);
                persons.put(INTRO_FILE_NM, intro_file_nm);
                persons.put(INTRO_FILE_PATH, intro_file_path);
                persons.put(INTRO_SAVE_FILE_NM, intro_save_file_nm);
                persons.put(INPUT_ID, input_id);
                persons.put(INPUT_IP, input_ip);
                persons.put(INPUT_DATE, input_date);
                persons.put(UPDATE_ID, update_ip);
                persons.put(UPDATE_IP, update_ip);
                persons.put(UPDATE_DATE, update_date);
                personList.add(persons);
            }
            ListAdapter adapter = new SimpleAdapter(
                    CLUB_DAO.this, personList, R.layout.list_item,
                    new String[]{CLUB_ID, CLUB_NM, CLUB_GB_CD,CLUB_AT_CD, CLUB_CNT,
                            CLUB_AIM,CLUB_ACTIVE, CLUB_ROOM, OPEN_DT,INTRO_CONT,
                            INTRO_FILE_NM, INTRO_FILE_PATH,INTRO_SAVE_FILE_NM,
                            INPUT_ID,INPUT_IP,INPUT_DATE,UPDATE_ID,UPDATE_IP,UPDATE_DATE
                    },
                    new int[]{R.id.title, R.id.context}
            );
            list.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void getData(String url) {
        class GetDataJSON extends AsyncTask<String, Void, String> {
            @Override
            protected String doInBackground(String... params) {
                String uri = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
            @Override
            protected void onPostExecute(String result) {
                myJSON = result;
                showList();
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute(url);
    }
}
