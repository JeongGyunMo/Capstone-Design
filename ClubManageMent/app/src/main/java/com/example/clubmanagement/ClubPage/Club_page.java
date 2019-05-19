package com.example.clubmanagement.ClubPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.clubmanagement.Apply.ApplyActivity;
import com.example.clubmanagement.R;

public class Club_page extends AppCompatActivity {
    Button button1;
    /*  Button button2;
      Button button3;
      Button button4;
      Button button5;
      Button button6;
  */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clubpage);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Club_page.this, ApplyActivity.class));
            }
        });

      /*  button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Club_page.this, ApplyActivity.class));
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Club_page.this, ApplyActivity.class));
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Club_page.this, ApplyActivity.class));
            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Club_page.this, ApplyActivity.class));
            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Club_page.this, ApplyActivity.class));
            }
        });
*/
    }
}
