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
public class f3 extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f3, container, false);


        TextView mText = view.findViewById(R.id.f3text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Захар сидит в своем доме и редко посещает коров. Он всегда держит ключ при себе. \n" +
                " Попробовать выманить Захара или пробраться к нему ночью?. \n"
        );
        Button button1 = (Button) view.findViewById(R.id.f31button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,5);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.f32button);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,6);
                }
            }
        });
        return view;
    }
}