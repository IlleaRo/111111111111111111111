package com.example.GGCow;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class f13 extends Fragment {


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f13, container, false);
        TextView mText = view.findViewById(R.id.f13text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Артурито не мог опозориться не мог опозориться и выполнил вашу просьбу. К сожалению, от него остался " +
                "только сочный бекон отменного качества, уже соленный.  \n"
        );
        Button button1 = (Button) view.findViewById(R.id.f131button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity).Clack(v, 14);
                }
            }
        });
        return view;
    }
}