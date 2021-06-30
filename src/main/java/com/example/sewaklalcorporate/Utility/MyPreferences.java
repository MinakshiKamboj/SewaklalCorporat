package com.example.sewaklalcorporate.Utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class MyPreferences {
    private static MyPreferences preferences = null;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor editor;
    private String flag = "flag";
    private String isLogedIn = "isLogedIn";
    private String user_id = "user_id";
    private String id = "id";


    public MyPreferences(Context context) {
        setmPreferences(PreferenceManager.getDefaultSharedPreferences(context));
    }
    public SharedPreferences getmPreferences() {
        return mPreferences;
    }

    public void setmPreferences(SharedPreferences mPreferences) {
        this.mPreferences = mPreferences;
    }
    public static MyPreferences getActiveInstance(Context context) {
        if (preferences == null) {
            preferences = new MyPreferences(context);
        }
        return preferences;
    }
    public boolean getIsLoggedIn() {
        return mPreferences.getBoolean(this.isLogedIn, false);
    }
    public void setIsLoggedIn(boolean isLoggedin) {
        editor = mPreferences.edit();
        editor.putBoolean(this.isLogedIn, isLoggedin);
        editor.commit();
    }

    public boolean getflag() {
        return mPreferences.getBoolean(this.flag, false);
    }

    public void setflag(boolean flag) {
        editor = mPreferences.edit();
        editor.putBoolean(this.flag, flag);
        editor.commit();
    }

    public String getUserId() {
        return mPreferences.getString(this.user_id, "");
    }
    public void setUserId(String user_id) {
        editor = mPreferences.edit();
        editor.putString(this.user_id, user_id);
        editor.commit();
    }

    public String getId() {
        return mPreferences.getString(this.id, "");
    }
    public void setId(String id) {
        editor = mPreferences.edit();
        editor.putString(this.id, id);
        editor.commit();
    }


}

