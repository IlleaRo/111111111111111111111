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

public class f7 extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f7, container, false);
        TextView mText = view.findViewById(R.id.f7text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Перед вами огромная куча проводов.\n" +
                "Вы можете перегрызть провод с надписью, написанной подчерком Захара 'Кто тронет - умрёт'.\n" +
                "Или каким-нибудь образом попробовать снести столб. Выбор за вами.\n"
        );
        Button button1 = (Button) view.findViewById(R.id.f71button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,20);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.f72button);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,8);
                }
            }
        });
        return view;
    }
}