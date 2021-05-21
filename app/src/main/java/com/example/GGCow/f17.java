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
public class f17 extends Fragment {
        @SuppressLint("SetTextI18n")
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_f17, container, false);
            TextView mText = view.findViewById(R.id.f16text);
            mText.setMovementMethod(new ScrollingMovementMethod());
            mText.setText("Удивительно то, что это сработало. \n"+
                            "Вы оказались под землей, где стояла советская ракета “УКРОП 7”. " +
                    "Пришло время полетать!"
            );
            Button button1 = (Button) view.findViewById(R.id.f17button);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentActivity activity = getActivity();
                    if (activity instanceof MainActivity) {
                        ((MainActivity) activity).Clack(v, 18);
                    }
                }
            });
            return view;
        }
    }