package com.theprototypo.billme.util.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Created by walesadanto on 27/7/15.
 */
public class PreferencesManager {

    private static final String AUTH_TOKEN = "auth_token";

    private static PreferencesManager instance;

    /** Returns singleton class instance */
    public static PreferencesManager getInstance() {
        if (instance == null) {
            synchronized (PreferencesManager.class) {
                if (instance == null) {
                    instance = new PreferencesManager();
                }
            }
        }
        return instance;
    }

    public static boolean saveAsString(Context context, String key, String value) {
        if (context == null || key == null || key.isEmpty()) {
            return false;
        }
        SharedPreferences prefs = android.preference.PreferenceManager
                .getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value.toLowerCase());
        return editor.commit();
    }

    public static void saveAuthToken(Context context, String authToken) {
        PreferencesManager.saveAsString(context, AUTH_TOKEN, authToken);
    }

    public static String getAuthToken(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(AUTH_TOKEN, null);
    }

}
