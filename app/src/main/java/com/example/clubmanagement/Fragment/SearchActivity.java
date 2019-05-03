package com.example.clubmanagement.Fragment;

import android.app.Activity;
import android.os.Bundle;
import com.example.clubmanagement.R;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SearchActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_page_one);

        // Spinner
        Spinner checkSpinner = (Spinner) findViewById(R.id.spinner_Check);
        ArrayAdapter yearAdapter = ArrayAdapter.createFromResource(this,
                R.array.major, android.R.layout.simple_spinner_item);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        checkSpinner.setAdapter(yearAdapter);
    }
}
