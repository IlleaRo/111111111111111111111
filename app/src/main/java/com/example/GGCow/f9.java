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
public class f9 extends Fragment {


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_f9, container, false);
        TextView mText = view.findViewById(R.id.f9text);
        mText.setMovementMethod(new ScrollingMovementMethod());
        mText.setText("9)\tТеодор вас не понял – вы остались одни…\n" +
                "\n"+ "\n"+ "\n"+ "\n"+
                "a.\tПридется использовать знания коровы-электрика Артурито. Артурито, будучи в Испании, дважды оказался в заложниках, но выжил, и теперь является крайне уважаемый в Криводановском обществе. (10)\n" +
                "b.\tПерекусить провода самостоятельно (11) \n"
        );
        Button button1 = (Button) view.findViewById(R.id.f91button);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,10);
                }
            }
        });
        Button button2 = (Button) view.findViewById(R.id.f92button);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentActivity activity = getActivity();
                if (activity instanceof MainActivity){
                    ((MainActivity) activity).Clack(v,11);
                }
            }
        });
        return view;
    }
}