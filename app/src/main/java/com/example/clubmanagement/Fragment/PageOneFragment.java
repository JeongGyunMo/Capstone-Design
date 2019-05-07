package com.example.clubmanagement.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import com.example.clubmanagement.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageOneFragment extends Fragment {
    public static PageOneFragment newInstance(){
        Bundle args = new Bundle();
        PageOneFragment fragment = new PageOneFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View v = inflater.inflate(R.layout.fragment_page_one, container, false);

            Spinner checkSpinner = (Spinner) v.findViewById(R.id.spinner_Check);
            ArrayAdapter Adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.major, android.R.layout.simple_spinner_item);
            Adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            checkSpinner.setAdapter(Adapter);

        return v;
    }

}