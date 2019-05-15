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

public class Club_Member_Data{
    String myJSON;
    private static final String TAG_RESULTS = "result";
    private static final String CLUB_ID = "CLUB_ID";
    private static final String CLUB_NM = "CLUB_NM";
    private static final String CLUB_GB_CD = "CLUB_GB_CD";
    public JSONArray JSON_Club_Item = null;
    public ArrayList<HashMap<String, String>> Club_Item_list;

    public Club_Member_Data(){
        JSON_Club_Item = null;
        Club_Item_list = new ArrayList<HashMap<String, String>>();
        getData("http://192.168.0.3/CLUB.php"); //http://[현재자신의아이피]/PHP_connection.php
    }

    public ArrayList<HashMap<String, String>> GetListData() {
        try {
            JSONObject jsonObj = new JSONObject(myJSON);
            JSON_Club_Item = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < JSON_Club_Item.length(); i++) {
                JSONObject c = JSON_Club_Item.getJSONObject(i);
                String id = c.getString(CLUB_ID);
                String name = c.getString(CLUB_NM);
                String address = c.getString(CLUB_GB_CD);
                HashMap<String, String> Club_Item = new HashMap<String, String>();
                Club_Item.put(CLUB_ID, id);
                Club_Item.put(CLUB_NM, name);
                Club_Item.put(CLUB_GB_CD, address);
                Club_Item_list.add(Club_Item);

            }
            return Club_Item_list;
            //ListAdapter adapter = new SimpleAdapter(ClubData.this, Club_Item_list, R.layout.list_item, new String[]{CLUB_ID, CLUB_NM, CLUB_GB_CD},new int[]{R.id.CLUB_ID, R.id.CLUB_NM, R.id.CLUB_GB_CD});
            //list.setAdapter(adapter);

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
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(uri);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    //InputStreamReader(con.ge)
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
        g.execute(url);
        g.onPostExecute("result");
        g.doInBackground(url);
    }
}
