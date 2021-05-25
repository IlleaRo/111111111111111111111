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
    private TextView mMtext;
    private View tView;

    private final f2 f2 = new f2();
    private final f1 f1 = new f1();
    private final f3 f3 = new f3();
    private final f4 f4 = new f4();
    private final f5 f5 = new f5();
    private final f6 f6 = new f6();
    private final f7 f7 = new f7();
    private final f8 f8 = new f8();
    private final f9 f9 = new f9();
    private final f10 f10 = new f10();
    private final f11 f11 = new f11();
    private final f12 f12 = new f12();
    private final f13 f13 = new f13();
    private final f15 f15 = new f15();
    private final f16 f16 = new f16();
    private final f17 f17 = new f17();
    private final f19 f19 = new f19();
    private final fError1 fError1 = new fError1();
    private final fError2 fError2 = new fError2();

    private final StartFragment fstart = new StartFragment();

    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    public SharedPreferences mSettings;


    private Integer mCounter = 1;
    private Integer trueCounter = 0;
    public Integer checkCounter;
    final static String TAG_1 = "FRAGMENT_1";

    public Integer getmCounter() {
        return mCounter;
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMtext = findViewById(R.id.mainText);
        tView = getLayoutInflater().inflate(R.layout.activity_main,null, false);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fstart)
                .commit();

        mSettings = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE);
        mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
        Log.d("PREF","COUNTER = "+APP_PREFERENCES_COUNTER);
        Log.d("PREF","Я создаюсь");
        if (mCounter==15){
            Clack(tView,15);
        }
        Log.d("PREF",mCounter.toString());
    }

    public void StartGame(View v){
        Clack(v,mCounter);
    }
    public void NewGame(View v){
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt(APP_PREFERENCES_COUNTER, 1);
        editor.apply();
        mSettings = getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE);
        mCounter = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
        Clack(v,mCounter);
    }


    @SuppressLint("SetTextI18n")
    public void Clack(View view, Integer needLevel) {
        mMtext.setText("Вы на уровне " +needLevel.toString());
        Log.d("НУЖНЫЙ УРОВЕНЬ", String.valueOf(mSettings.getInt(APP_PREFERENCES_COUNTER, 0)));
        mCounter = needLevel;
        if (mCounter==0){mCounter=1;}
        switch (mCounter){
            case 1:
                mMtext.setText("Вы на уровне " +1);
                getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, f1)
                    .commit();
                break;
            case 2:
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
            case 10:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f10)
                        .commit();
                break;
            case 11:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f11)
                        .commit();
                break;
            case 12:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f12)
                        .commit();
                break;
            case 13:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f13)
                        .commit();
                break;
            case 14:
                SharedPreferences.Editor editor = mSettings.edit();
               editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
               editor.apply();
               Log.d("PREF", String.valueOf(getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)));
               setContentView(new Cow(this));
               break;
            case 15:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f15)
                        .commit();
                break;
            case 16:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f16)
                        .commit();
                break;
            case 17:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f17)
                        .commit();
                break;
            case 18:
                SharedPreferences.Editor editor1 = mSettings.edit();
                editor1.putInt(APP_PREFERENCES_COUNTER, mCounter);
                editor1.apply();
                Log.d("PREF", String.valueOf(getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)));
                setContentView(new Rocket(this));
                break;
            case 19:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, f19)
                        .commit();
                break;
            case 20:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fError1)
                        .commit();
                break;
            case 21:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fError2)
                        .commit();
                break;    
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
        // Запоминаем данные
        SharedPreferences.Editor editor = mSettings.edit();
        trueCounter = mSettings.getInt(APP_PREFERENCES_COUNTER,0);
        /*if (trueCounter>mCounter) {
        editor.putInt(APP_PREFERENCES_COUNTER, trueCounter);
        Log.d("PREF","It's end!"+trueCounter);
        }else {*/editor.putInt(APP_PREFERENCES_COUNTER, mCounter);
            Log.d("PREF","It's end!"+mCounter);
        //}
        editor.apply();
        super.onPause();
    }
}
