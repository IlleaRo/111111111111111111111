package com.example.a111111111111111111111;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.example.a111111111111111111111.MainActivity.APP_PREFERENCES_COUNTER;

public class StartFragment extends Fragment {

    public String text;
    MainActivity mActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        TextView textOnS = view.findViewById(R.id.textOnNewScreen);
        Button button = (Button) view.findViewById(R.id.contButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

            }
        });
        return view;
    }
}
