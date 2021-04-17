package com.example.a111111111111111111111;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import static android.text.style.TtsSpan.ARG_TEXT;

public class f1 extends Fragment {



    public static f1 newInstande(String text){
        f1 fragment = new f1();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT,text);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment
        return view;
    }

}