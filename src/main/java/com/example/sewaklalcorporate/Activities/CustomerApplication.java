package com.example.sewaklalcorporate.Activities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.example.sewaklalcorporate.Utility.Preferences;

public class CustomerApplication extends Application {
    private static CustomerApplication instance;
    public static Context getContext() {
        return instance;
    }

    public static CustomerApplication getApplication() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Preferences.initSharedPreferences(this);
    }
    private Activity mCurrentActivity = null;

    public Activity getCurrentActivity(){
        return mCurrentActivity;
    }
    public void setCurrentActivity(Activity mCurrentActivity){
        this.mCurrentActivity = mCurrentActivity;
    }
}