package com.example.a111111111111111111111;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.fragment.app.Fragment;

public class COW extends Fragment implements View.OnClickListener {

    Canvas canvas = new Canvas();
    public boolean stopped = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public COW() { }


    // TODO: Rename and change types and number of parameters
    public static COW newInstance(String param1, String param2) {
        COW fragment = new COW();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = getView().findViewById(R.id.not);
        frameLayout.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_c_o_w, container, false);
    }

    public int x, y;
    private int xVelocity = 10;
    public int yVelocity = 5;




    public Bitmap getResizedBitmap(Bitmap bm, int newWidth, int newHeight) {
        canvas.drawRGB(0, 100, 205);

        int width = bm.getWidth();
        int height = bm.getHeight();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // CREATE A MATRIX FOR THE MANIPULATION
        Matrix matrix = new Matrix();
        // RESIZE THE BIT MAP
        matrix.postScale(scaleWidth, scaleHeight);

        // "RECREATE" THE NEW BITMAP
        Bitmap resizedBitmap =
                Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
        bm.recycle();
        return resizedBitmap;
    }

    @Override
    public void onClick(View v) {
        y = y - (yVelocity * 10);
    }

    class DrawThread extends Thread {
        @Override
        public void run() {
            while (!stopped) {
                canvas.drawRGB(0, 150, 205);
            }
        }
    }

}
