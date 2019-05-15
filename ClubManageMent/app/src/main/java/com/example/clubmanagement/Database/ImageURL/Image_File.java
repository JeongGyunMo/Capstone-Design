
package com.example.clubmanagement.Database.ImageURL;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class Image_File implements Runnable{
    // 1. 변수 선언
    ImageView img1;
    Bitmap bitmap; // 비트맵 객체
    // 메인 스레드와 백그라운드 스레드 간의 통신
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // 서버에서 받아온 이미지를 핸들러를 경유해 이미지뷰에 비트맵 리소스 연결
            img1.setImageBitmap(bitmap);
        }
    };

    public Image_File(){
        Thread th = new Thread(Image_File.this);
        // 동작 수행
        th.start();
    }

    @Override
    public void run() {
        // http://192.168.0.127/resources/images/like1.png
        URL url = null;
        try{
            // 스트링 주소를 url 형식으로 변환
            url = new URL("http://192.168.0.3/club_icon/노네임.png");
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
