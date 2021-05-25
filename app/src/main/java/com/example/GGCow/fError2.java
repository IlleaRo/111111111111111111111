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

public class fError2 extends Fragment {
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f_error2, container, false);
        TextView mText = view.findViewById(R.id.fError2text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Захар заподозрил вас в убийстве Артурито. Он вызвал знаменитого коровьего детектива Шерлока Коумса. Нужно что-то придумать...  \n"
                + "Продолжение следует...");
        Button button1 = (Button) view.findViewById(R.id.fError2button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,1);
                }
            }
        });

        return view;
    }
}