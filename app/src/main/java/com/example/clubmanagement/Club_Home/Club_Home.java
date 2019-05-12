package com.example.clubmanagement.Club_Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.clubmanagement.R;

public class Club_Home extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_form);
    }

    public void MoveHomePage(String name){
        startActivity(new Intent(this,Club_Home.class));

    }

    private void StartClubHomePage() {

    }

}