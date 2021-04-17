package com.example.a111111111111111111111;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
    private boolean isFirst = true;
    private TextView mMtext;
    private final f2 f2 = new f2();
    private final f1 f1 = new f1();
    private final f3 f3 = new f3();
    private final f4 f4 = new f4();
    private final f5 f5 = new f5();
    private final f6 f6 = new f6();
    private final StartFragment fstart = new StartFragment();
    // WE ALL USTALI
    //GGGGGGGGGGGGGGGGGGGGGGGGGAAAAAAAAAAAAAAAAP
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;


    private Integer mCounter = 1;
    public Integer checkCounter;
    final static String TAG_1 = "FRAGMENT_1";
    Button mButton1, mButton2;

    public Integer getmCounter() {
        return mCounter;
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.button);
        mButton2 = findViewById(R.id.button2);
        mMtext = findViewById(R.id.mainText);
        //mButton1.setVisibility(View.INVISIBLE);
        //mButton2.setVisibility(View.INVISIBLE);
        mButton1.setText("Начать");
        mButton2.setText("Продолжить");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fstart)
                .commit();

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
    }


    @SuppressLint("SetTextI18n")
    public void Clack(View view) {
        if (isFirst) {
            mButton2.setVisibility(View.VISIBLE);
            isFirst = false;
        }

        mMtext.setText("Вы на уровне " +mCounter.toString());
        Log.d("НУЖНЫЙ УРОВЕНЬ", String.valueOf(mSettings.getInt(APP_PREFERENCES_COUNTER, 0)));

        switch (mCounter){


            case 1:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, f1)
                    .commit();
                mCounter=2;
                break;
            case 2:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, f2)
                    .commit();
                mCounter=3;
                break;
            case 3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f3)
                        .commit();
                mCounter=4;
                break;
            case 4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f4)
                        .commit();
                mCounter=5;
                break;

            case 5:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f5)
                        .commit();
                mCounter=6;
                break;
            case 6:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f6)
                        .commit();
                mCounter=7;
                break;
            case 7:
                setContentView(new CowSimple (this));
                mCounter=8;
            default:
                mCounter=1;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
            // Получаем число из настроек
            mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
            Log.d("НУЖНЫЙ УРОВЕНЬ", String.valueOf(mSettings.getInt(APP_PREFERENCES_COUNTER, 0)));
            mMtext.setText(mCounter.toString());
            checkCounter = mCounter;
            // Выводим на экран данные из настроек
        }
    }

    public String getCheckCounter() {
        return checkCounter.toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Запоминаем данные
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, mCounter-1);
        editor.apply();
    }
}
