package com.example.a111111111111111111111;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.example.a111111111111111111111.MainActivity.APP_PREFERENCES_COUNTER;

public class StartFragment extends Fragment {
    public void setText1(String text) {
        this.text = text;
    }

    public String text;
    MainActivity mActivity = new MainActivity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        TextView textOnS = view.findViewById(R.id.textOnNewScreen);
        Button button = (Button) view.findViewById(R.id.contButton);
        button.setOnClickListener(new ActionForContinue());

        return view;
    }

    private class ActionForContinue implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mActivity.Clack(v);
        }
    }
}
