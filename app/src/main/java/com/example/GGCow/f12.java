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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link f12#newInstance} factory method to
 * create an instance of this fragment.
 */
public class f12 extends Fragment {

        @SuppressLint("SetTextI18n")
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_f12, container, false);
            TextView mText = view.findViewById(R.id.f12text);
            mText.setMovementMethod(new ScrollingMovementMethod());
            mText.setText("\t"+"ВЫХОДИТ ЗАХАР."+"\n"+"Он очень зол, что не смог одолеть пятиклашку на SF’е на миду. Вас заметили радом с Артурито – необходимо срочно что-то ответить.");
            Button button1 = (Button) view.findViewById(R.id.f121button);
            button1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    FragmentActivity activity = getActivity();
                    if (activity instanceof MainActivity){
                        ((MainActivity) activity).Clack(v,13);
                    }
                }
            });
            Button button2 = (Button) view.findViewById(R.id.f122button);
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