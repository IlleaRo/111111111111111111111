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

public class f2 extends Fragment {
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f2, container, false);
        TextView mText = view.findViewById(R.id.f2text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Для начала ей необходимо раздобыть ключ от загона. Она может попробовать украсть его у Захара-смотрителя. \n"
                );
        Button button1 = (Button) view.findViewById(R.id.f21button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,3);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.f22button);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,4);
                }
            }
        });
        return view;
    }
}