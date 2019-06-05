package com.example.clubmanagement.Form;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.clubmanagement.Apply.ApplyActivity;
import com.example.clubmanagement.Fragment.FragmentStart;
import com.example.clubmanagement.R;

public class Application_Form extends AppCompatActivity{
    Button apply;
    Button cancel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.application_form);

        apply = (Button) findViewById(R.id.join) ;
        apply.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Application_Form.this, ApplyActivity.class));
            }
        });

        cancel = (Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Application_Form.this, FragmentStart.class));
            }
        });
    }
}
