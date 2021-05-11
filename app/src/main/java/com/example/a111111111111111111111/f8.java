package com.example.a111111111111111111111;

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


public class f8 extends Fragment {


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f8, container, false);
        TextView mText = view.findViewById(R.id.f8text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("У вас есть бык, который влюблен в вас. Теодор может снести столб по вашей просьбе. Как вы его попросите? \n"
        );
        Button button1 = (Button) view.findViewById(R.id.f81button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,9);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.f82button);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,9);
                }
            }
        });
        return view;
    }
}