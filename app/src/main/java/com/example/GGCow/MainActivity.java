package com.example.GGCow;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private final f7 f7 = new f7();
    private final f8 f8 = new f8();
    private final f9 f9 = new f9();



    private final StartFragment fstart = new StartFragment();
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public SharedPreferences mSettings;


    private Integer mCounter = 1;
    public Integer checkCounter;
    final static String TAG_1 = "FRAGMENT_1";
   // Button mButton1, mButton2;

    public Integer getmCounter() {
        return mCounter;
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mButton1 = findViewById(R.id.button);
       // mButton2 = findViewById(R.id.button2);
        mMtext = findViewById(R.id.mainText);
       // mButton1.setVisibility(View.INVISIBLE);
       // mButton2.setVisibility(View.INVISIBLE);
       // mButton1.setText("Начать");
       // mButton2.setText("Продолжить");

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fstart)
                .commit();

        mSettings = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE);
        Log.d("PREF","Я создаюсь");
    }

    public void StartGame(View v){
        Clack(v,mCounter);
    }


    @SuppressLint("SetTextI18n")
    public void Clack(View view, Integer needLevel) {
        if (isFirst) {
           // mButton2.setVisibility(View.VISIBLE);
            isFirst = false;
        }
        mMtext.setText("Вы на уровне " +needLevel.toString());
        Log.d("НУЖНЫЙ УРОВЕНЬ", String.valueOf(mSettings.getInt(APP_PREFERENCES_COUNTER, 0)));
        mCounter = needLevel;
        switch (needLevel){
            case 1:
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, f1)
                    .commit();
                //mButton2.setVisibility(View.INVISIBLE);
                //mButton1.setText("Я готов!!!");
                break;
            case 2:
               // mButton2.setVisibility(View.VISIBLE);
               // mButton1.setText("Украсть ключ");
               // mButton2.setText("Ждать");
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, f2)
                    .commit();

                break;
            case 3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f3)
                        .commit();
                break;
            case 4:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f4)
                        .commit();
                break;

            case 5:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f5)
                        .commit();
                break;
            case 6:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f6)
                        .commit();
                break;
            case 7:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f7)
                        .commit();
                break;
            case 8:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f8)
                        .commit();
                break;
            case 9:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f9)
                        .commit();
                break;
               // SharedPreferences.Editor editor = mSettings.edit();
                //editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
                //editor.apply();

               // Log.d("PREF", String.valueOf(getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)));
               // setContentView(new Rocket(this));
            default:
                mCounter=1;
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
        if (mSettings.contains(APP_PREFERENCES_COUNTER)) { Log.d("PREF","Я проснулся");
            // Получаем число из настроек
            mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
            Log.d("PREF", String.valueOf("Нужный уровень"+mSettings.getInt(APP_PREFERENCES_COUNTER, 0)));
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
        editor.putInt("counter", mCounter);
        editor.apply();
        Log.d("PREF","я на паузе ");
    }


}
