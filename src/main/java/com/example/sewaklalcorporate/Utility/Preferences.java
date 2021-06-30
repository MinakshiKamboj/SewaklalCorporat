package com.example.sewaklalcorporate.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class Preferences {

    private static final String PREF_NAME = "Pioneer_Prefs";
    public static final String LOGIN_KEY = "isUserLoggedIn";
    public static final String WISHLIST_SHOWCASE = "wishListShowcase";
    public static final String CHECKBOX_SHOWCASE = "checkBocShowcase";

    private static SharedPreferences xebiaSharedPrefs;
    private static SharedPreferences.Editor editor;
    private static Preferences sharedPreferenceUtil;


    private String user_id = "user_id";


    public static void initSharedPreferences(Context context) {
        sharedPreferenceUtil = new Preferences();
        sharedPreferenceUtil.xebiaSharedPrefs = context.getSharedPreferences(
                PREF_NAME, AppCompatActivity.MODE_PRIVATE);
        sharedPreferenceUtil.editor = sharedPreferenceUtil.xebiaSharedPrefs
                .edit();
    }

    public static Preferences getInstance() {

        return sharedPreferenceUtil;
    }

    private Preferences() {
        // TODO Auto-generated constructor stub
    }

    public static synchronized boolean saveData(String key, String value) {
        editor.putString(key, value);
        return editor.commit();
    }

    public static synchronized boolean saveData(String key, Set<String> value) {
        editor.putStringSet(key, value);
        return editor.commit();
    }

    public static synchronized boolean saveData(String key, boolean value) {
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static synchronized boolean saveData(String key, long value) {
        editor.putLong(key, value);
        return editor.commit();
    }

    public static synchronized boolean saveData(String key, float value) {
        editor.putFloat(key, value);
        return editor.commit();
    }

    public static synchronized boolean saveData(String key, int value) {
        editor.putInt(key, value);
        return editor.commit();
    }

    public static boolean isUserLoggerIn() {
        return getData(LOGIN_KEY, false);
    }
    public static boolean isEventCreated() {
        return getData(WISHLIST_SHOWCASE, false);
    }
    public static boolean isWhisListSelected() {
        return getData(CHECKBOX_SHOWCASE, false);
    }

	/*
     * public synchronized boolean saveData(String key, Set<String> value) {
	 * //editor.putStringSet(key, value); return editor.commit(); }
	 */

    public static synchronized boolean removeData(String key) {
        editor.remove(key);
        return editor.commit();
    }

    public static synchronized Boolean getData(String key, boolean defaultValue) {
        return xebiaSharedPrefs.getBoolean(key, defaultValue);
    }

    public static synchronized String getData(String key, String defaultValue) {
        return xebiaSharedPrefs.getString(key, defaultValue);
    }

    public static synchronized Set<String> getData(String key, Set<String> defaultValue) {
        return xebiaSharedPrefs.getStringSet(key, defaultValue);
    }

    public static synchronized float getData(String key, float defaultValue) {

        return xebiaSharedPrefs.getFloat(key, defaultValue);
    }

    public static synchronized int getData(String key, int defaultValue) {
        return xebiaSharedPrefs.getInt(key, defaultValue);
    }

    public static synchronized long getData(String key, long defaultValue) {
        return xebiaSharedPrefs.getLong(key, defaultValue);
    }

    public static synchronized void deleteAllData() {

        sharedPreferenceUtil = null;
        editor.clear();
        editor.commit();
    }

    public String getUserId() {
        return xebiaSharedPrefs.getString(this.user_id, "");
    }
    public void setUserId(String user_id) {
        editor = xebiaSharedPrefs.edit();
        editor.putString(this.user_id, user_id);
        editor.commit();
    }
}