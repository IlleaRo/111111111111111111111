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
public class f11 extends Fragment {

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f11, container, false);
        TextView mText = view.findViewById(R.id.f11text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Попытка пробраться не увенчалась успехом. Захар никогда не спит, у него есть ДОТА. Вы стали деликатесом на Ленинском рынке.\n");
        Button button = (Button) view.findViewById(R.id.f111button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity != null && activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,1);
                }
            }
        });
        return view;
    }

}