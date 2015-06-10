package com.example.lucascoaquira.gnirak;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Lucas Coaquira on 08/05/2015.
 */
public class utilCodes {
    public static final String APP_PREFS_NAME = "AppPrefs";
    public static boolean isRadioPlaying = false;
    public static boolean isVideoPlaying = false;
    public static boolean isAudioPlaying = false;

    private Activity activity;
    private static utilCodes instance;

    public utilCodes(Activity act) {
        activity = act;
    }

    public static utilCodes getInstace(Activity acti) {
        if (instance == null) {
            instance = new utilCodes(acti);
        }
        return instance;
    }

    /*preferences names*/
    public static final String ACEPTO_RELACION = "ACEPTO_RELACION";

    public enum Players {
        RadioPlayer,
        VideoPlayer,
        AudioPlayer
    }

    public boolean isPlaying(Players player) {
        switch (player) {
            case RadioPlayer:
                return isRadioPlaying;
            case AudioPlayer:
                return isAudioPlaying;
            case VideoPlayer:
                return isVideoPlaying;
            default:
                return false;
        }

    }

    public void savePreference(String key, String value) {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(APP_PREFS_NAME, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public void clearPrefs() {
        SharedPreferences sharedPreferences = activity.getSharedPreferences(APP_PREFS_NAME, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();
        edit.commit();
    }

    public String getPreferences(String key){
        SharedPreferences sharedPreferences = activity.getSharedPreferences(APP_PREFS_NAME, 0);
        return sharedPreferences.getString(key,null);
    }
}
