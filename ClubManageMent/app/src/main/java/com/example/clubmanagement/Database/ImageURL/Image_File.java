package com.example.clubmanagement.Database.ImageURL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Handler;
import android.os.Message;

public class Image_File implements Runnable{
    // 1. 변수 선언

    public Bitmap bitmap; // 비트맵 객체

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private String Url;

    public Image_File(String url){
        Url = url;
        Thread th = new Thread(Image_File.this);
        th.start();
    }

    // 백그라운드 스레드
    @Override
    public void run() {
        URL url = null;
        try{
            // 스트링 주소를 url 형식으로 변환
            url = new URL(Url);
            // url에 접속 시도
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.connect();
            // 스트림 생성
            InputStream is = conn.getInputStream();
            // 스트림에서 받은 데이터를 비트맵 변환

            // 인터넷에서 이미지 가져올 때는 Bitmap을 사용해야함
            bitmap = BitmapFactory.decodeStream(is);

            // 핸들러에게 화면 갱신을 요청한다.
            handler.sendEmptyMessage(0);
            // 연결 종료
            is.close();
            conn.disconnect();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
