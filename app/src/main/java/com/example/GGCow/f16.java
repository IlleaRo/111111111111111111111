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
public class f16 extends Fragment {
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f16, container, false);
        TextView mText = view.findViewById(R.id.f16text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("Памятник неодобрительно посмотрел на Вас. \n" +
                "Каменное лицо насмешливо, как будто зная корову, смотрело на нее. Коу видела, как на его виске бьется тонкая склеротическая жилка. \n" +
                "Ваш разум помутнел: за вами выехал санитар. "
        );
        Button button1 = (Button) view.findViewById(R.id.f16button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity).Clack(v, 1);
                }
            }
        });
        return view;
    }
}