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
public class f15 extends Fragment {
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f15, container, false);
        TextView mText = view.findViewById(R.id.f15text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("\t"+"Коу удалось сбежать от Захара. " +"\n"+
                "Вы очутились в центре города. Перед вами памятник В.И. Ленину. Артурито рассказывал," +
                " что под гранитовой плитой есть бункер, где он сам служил. Жаль, что вы не запомнили как туда попасть… "
        );
        Button button1 = (Button) view.findViewById(R.id.f151button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity).Clack(v, 16);
                }
            }
        });

        Button button2 = (Button) view.findViewById(R.id.f152button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity) {
                    ((MainActivity) activity).Clack(v, 17);
                }
            }
        });
        return view;
    }
}