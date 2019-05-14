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

public class ClubData{
    String myJSON;
    private static final String TAG_RESULTS = "result";
    private static final String TAG_ID = "CLUB_ID";
    private static final String TAG_NAME = "CLUB_NM";
    private static final String TAG_ADD = "CLUB_GB_CD";
    JSONArray peoples = null;
    ArrayList<HashMap<String, String>> personList;

    public ClubData(){
        peoples = null;
        personList = new ArrayList<HashMap<String, String>>();
        getData("http://192.168.0.3/CLUB.php"); //http://[현재자신의아이피]/PHP_connection.php
    }

    public ArrayList<HashMap<String, String>> GetListData() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String id = c.getString(TAG_ID);
                String name = c.getString(TAG_NAME);
                String address = c.getString(TAG_ADD);
                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(TAG_ID, id);
                persons.put(TAG_NAME, name);
                persons.put(TAG_ADD, address);
                personList.add(persons);

            }
            return personList;
            //ListAdapter adapter = new SimpleAdapter(ClubData.this, personList, R.layout.list_item, new String[]{TAG_ID, TAG_NAME, TAG_ADD},new int[]{R.id.CLUB_ID, R.id.CLUB_NM, R.id.CLUB_GB_CD});
            //list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return personList;
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
            }
        }
        GetDataJSON g = new GetDataJSON();
        g.onPostExecute("result");
        g.doInBackground(url);
        g.execute(url);

    }
}
